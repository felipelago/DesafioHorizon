package br.com.horizon.service.impl;

import br.com.horizon.dto.FiltroPassagemDTO;
import br.com.horizon.dto.PassagemDTO;
import br.com.horizon.error.ResourceNotAcceptableException;
import br.com.horizon.model.Classe;
import br.com.horizon.model.Passagem;
import br.com.horizon.model.Voo;
import br.com.horizon.repository.PassagemRepository;
import br.com.horizon.service.ClasseService;
import br.com.horizon.service.PassagemService;
import br.com.horizon.service.VooService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PassagemServiceImpl implements PassagemService {

    @Autowired
    private PassagemRepository passagemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VooService vooService;

    @Autowired
    private ClasseService classeService;

    @Override
    public PassagemDTO create(PassagemDTO object) {
        rulesBeforeBuy(object);
        var categorySaved = passagemRepository.saveAndFlush(this.modelMapper.map(object, Passagem.class));
        return this.modelMapper.map(categorySaved, PassagemDTO.class);
    }

    @Override
    public PassagemDTO update(PassagemDTO brandDTO, Long id) {
        brandDTO.setId(id);
        existsById(id);
        var brandSaved = passagemRepository.save(this.modelMapper.map(brandDTO, Passagem.class));
        return this.modelMapper.map(brandSaved, PassagemDTO.class);
    }

    @Override
    public List<PassagemDTO> findAll() {
        var brands = passagemRepository.findAll();
        return brands.stream().map(brand -> this.modelMapper.map(brand, PassagemDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PassagemDTO findById(Long id) {
        existsById(id);
        return this.modelMapper.map(passagemRepository.findById(id), PassagemDTO.class);
    }

    private void existsById(Long id) {
        if (!passagemRepository.existsById(id)) {
            throw new ResourceNotAcceptableException("Nenhum registro encontrado!");
        }
    }

    private void rulesBeforeBuy(PassagemDTO passagemDTO) {

        var classeDTO = classeService.findById(passagemDTO.getClasse().getId());
        var vooDTO = vooService.findById(passagemDTO.getVoo().getId());
        var qntAssento = passagemRepository.countByVooAndClasse(this.modelMapper.map(passagemDTO.getVoo(), Voo.class),
                this.modelMapper.map(passagemDTO.getClasse(), Classe.class));

        vooDTO.getClasses().forEach(classe -> {
            if (classe.getId().equals(classeDTO.getId())) {
                if (qntAssento >= classe.getQtdAssento()) {
                    throw new ResourceNotAcceptableException("Não existe mais assentos disponiveis na Classe " + classeDTO.getNome());
                }
            }
        });

        passagemDTO.setValorTotal(vooDTO.getValorVoo() + classeDTO.getValor());

        if (passagemDTO.getBagagem() != null && passagemDTO.getBagagem().getDespachado()) {
            var valorCalculado = 0.1 * classeDTO.getValor();
            passagemDTO.setValorTotal(passagemDTO.getValorTotal() + valorCalculado);
        }

    }

}
