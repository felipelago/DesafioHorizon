package br.com.horizon.service.impl;

import br.com.horizon.dto.ClasseDTO;
import br.com.horizon.dto.FiltroPassagemDTO;
import br.com.horizon.dto.PassagemDTO;
import br.com.horizon.dto.VooDTO;
import br.com.horizon.error.ResourceNotAcceptableException;
import br.com.horizon.model.Voo;
import br.com.horizon.repository.VooRepository;
import br.com.horizon.service.AeroportoService;
import br.com.horizon.service.VooService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class VooServiceImpl implements VooService {

    @Autowired
    private VooRepository vooRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AeroportoService aeroportoService;

    @Override
    public VooDTO create(VooDTO object) {
        verifyByCityAndSameAirport(object);
        var categorySaved = vooRepository.save(this.modelMapper.map(object, Voo.class));
        return this.modelMapper.map(categorySaved, VooDTO.class);
    }

    @Override
    public VooDTO update(VooDTO brandDTO, Long id) {
        brandDTO.setId(id);
        existsById(id);
        var brandSaved = vooRepository.save(this.modelMapper.map(brandDTO, Voo.class));
        return this.modelMapper.map(brandSaved, VooDTO.class);
    }

    @Override
    public List<VooDTO> findAll() {
        var brands = vooRepository.findAll();
        return brands.stream().map(brand -> this.modelMapper.map(brand, VooDTO.class)).collect(Collectors.toList());
    }

    @Override
    public VooDTO findById(Long id) {
        existsById(id);
        return this.modelMapper.map(vooRepository.findById(id), VooDTO.class);
    }

    private void existsById(Long id) {
        if (!vooRepository.existsById(id)) {
            throw new ResourceNotAcceptableException("Nenhum registro encontrado!");
        }
    }

    @Override
    public void cancelById(Long id) {
        existsById(id);
        int cancel = vooRepository.cancelById(id);
        if (cancel == 0) {
            throw new ResourceNotAcceptableException("Não foi possivel cancelar o voo, pois já se encontra cancelado!");
        }
    }

    private void verifyByCityAndSameAirport(VooDTO vooDTO) {

        var airportDestiny = aeroportoService.findById(vooDTO.getAeroportoDestino().getId());
        var airportOrigi = aeroportoService.findById(vooDTO.getAeroportoOrigem().getId());

        if (airportDestiny.getId().equals(airportOrigi.getId())) {
            throw new ResourceNotAcceptableException("O voo não pode ter como origem e destino o mesmo aeroporto.");
        }

        if (airportDestiny.getCidade().getNome().equals(airportOrigi.getCidade().getNome())) {
            throw new ResourceNotAcceptableException("Os aeroportos não podem estar situados na mesma cidade.");
        }

        if (vooDTO.getClasses() == null || vooDTO.getClasses().isEmpty()) {
            throw new ResourceNotAcceptableException("O voo devem possuir no mínimo uma classe");
        }

        if (checkForDuplicates(vooDTO.getClasses())) {
            throw new ResourceNotAcceptableException("Não deve haver duas ou mais classes do mesmo tipo no mesmo voo.");
        }

    }

    //Nós sabemos isso HashSet não permite valores duplicados nele. Podemos fazer uso dessa propriedade para verificar se há duplicatas em um array. A ideia é inserir todos os elementos do array em um HashSet. Agora a array contém uma duplicata se o comprimento da array não for igual ao tamanho do conjunto.
    private static <T> boolean checkForDuplicates(List<ClasseDTO> classeDTOList) {
        Set<T> set = new HashSet(classeDTOList);
        return classeDTOList.size() != set.size();
    }


    @Override
    public List<VooDTO> findByFilter(FiltroPassagemDTO filtroPassagemDTO) {

        var dataInicio = filtroPassagemDTO.getDataPesquisa();
        var dataFinal = filtroPassagemDTO.getDataPesquisa();


        if (filtroPassagemDTO.getDataPesquisa() == null) {
            dataInicio = LocalDateTime.now();
            var c1 = Calendar.getInstance();
            c1.add(Calendar.DAY_OF_YEAR, 30);;
            dataFinal = c1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        }

        if (filtroPassagemDTO.getDataPesquisa() != null && filtroPassagemDTO.getDataPesquisa().isBefore(LocalDateTime.now())) {
            throw new ResourceNotAcceptableException("Não é possivel pesquisar voos passados.");
        }

        var result = vooRepository.findAllByAeroportoDestino_NomeContainsAndAeroportoOrigem_NomeContainsAndDataPartidaBetween(filtroPassagemDTO.getAeroportoDestino(), filtroPassagemDTO.getAeroportoOrigem(), dataInicio, dataFinal);
        return result.stream().map(user -> this.modelMapper.map(user, VooDTO.class)).collect(Collectors.toList());

    }

}