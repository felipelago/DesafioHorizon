package br.com.horizon.service.impl;

import br.com.horizon.dto.PassageiroDTO;
import br.com.horizon.error.ResourceNotAcceptableException;
import br.com.horizon.model.Passageiro;
import br.com.horizon.repository.PassageiroRepository;
import br.com.horizon.service.PassageiroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PassageiroServiceImpl implements PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PassageiroDTO create(PassageiroDTO object) {
        findByName(object);
        var categorySaved = passageiroRepository.save(this.modelMapper.map(object, Passageiro.class));
        return this.modelMapper.map(categorySaved, PassageiroDTO.class);
    }

    @Override
    public PassageiroDTO update(PassageiroDTO brandDTO, Long id) {
        brandDTO.setId(id);
        findByName(brandDTO);
        existsById(id);
        var brandSaved = passageiroRepository.save(this.modelMapper.map(brandDTO, Passageiro.class));
        return this.modelMapper.map(brandSaved, PassageiroDTO.class);
    }

    @Override
    public List<PassageiroDTO> findAll() {
        var brands = passageiroRepository.findAll();
        return brands.stream().map(brand -> this.modelMapper.map(brand, PassageiroDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PassageiroDTO findById(Long id) {
        existsById(id);
        return this.modelMapper.map(passageiroRepository.findById(id), PassageiroDTO.class);
    }

    private void existsById(Long id) {
        if (!passageiroRepository.existsById(id)) {
            throw new ResourceNotAcceptableException("Nenhum registro encontrado!");
        }
    }

    private void findByName(PassageiroDTO objectDTO) {
        var objectExists = passageiroRepository.findByNome(objectDTO.getNome());
        if (objectExists != null && objectDTO.getId() == null ||
                objectExists != null && objectDTO.getId() != null && !objectExists.getId().equals(objectDTO.getId()))
            throw new ResourceNotAcceptableException("Registro já cadastrado!");
    }
}
