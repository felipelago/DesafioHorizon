package br.com.horizon.service.impl;

import br.com.horizon.dto.VooClasseDTO;
import br.com.horizon.dto.VooDTO;
import br.com.horizon.error.ResourceNotAcceptableException;
import br.com.horizon.model.VooClasse;
import br.com.horizon.repository.VooClasseRepository;
import br.com.horizon.service.VooClasseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VooClasseServiceImpl implements VooClasseService {

    @Autowired
    private VooClasseRepository VooClasseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VooClasseDTO create(VooClasseDTO object) {
        var categorySaved = VooClasseRepository.save(this.modelMapper.map(object, VooClasse.class));
        return this.modelMapper.map(categorySaved, VooClasseDTO.class);
    }

    @Override
    public VooClasseDTO update(VooClasseDTO brandDTO, Long id) {
        brandDTO.setId(id);
        existsById(id);
        var brandSaved = VooClasseRepository.save(this.modelMapper.map(brandDTO, VooClasse.class));
        return this.modelMapper.map(brandSaved, VooClasseDTO.class);
    }

    @Override
    public List<VooClasseDTO> findAll() {
        var brands = VooClasseRepository.findAll();
        return brands.stream().map(brand -> this.modelMapper.map(brand, VooClasseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public VooClasseDTO findById(Long id) {
        existsById(id);
        return this.modelMapper.map(VooClasseRepository.findById(id), VooClasseDTO.class);
    }

    private void existsById(Long id) {
        if (!VooClasseRepository.existsById(id)) {
            throw new ResourceNotAcceptableException("Nenhum registro encontrado!");
        }
    }

    private void ruleBeforeCreate(VooDTO vooDTO){

    }

}
