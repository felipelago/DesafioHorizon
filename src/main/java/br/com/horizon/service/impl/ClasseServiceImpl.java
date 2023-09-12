package br.com.horizon.service.impl;

import br.com.horizon.dto.ClasseDTO;
import br.com.horizon.error.ResourceNotAcceptableException;
import br.com.horizon.model.Classe;
import br.com.horizon.repository.ClasseRepository;
import br.com.horizon.service.ClasseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClasseServiceImpl implements ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClasseDTO create(ClasseDTO object) {
        findByName(object);
        var categorySaved = classeRepository.save(this.modelMapper.map(object, Classe.class));
        return this.modelMapper.map(categorySaved, ClasseDTO.class);
    }

    @Override
    public ClasseDTO update(ClasseDTO brandDTO, Long id) {
        brandDTO.setId(id);
        findByName(brandDTO);
        existsById(id);
        var brandSaved = classeRepository.save(this.modelMapper.map(brandDTO, Classe.class));
        return this.modelMapper.map(brandSaved, ClasseDTO.class);
    }

    @Override
    public List<ClasseDTO> findAll() {
        var brands = classeRepository.findAll();
        return brands.stream().map(brand -> this.modelMapper.map(brand, ClasseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ClasseDTO findById(Long id) {
        existsById(id);
        return this.modelMapper.map(classeRepository.findById(id), ClasseDTO.class);
    }

    private void existsById(Long id) {
        if (!classeRepository.existsById(id)) {
            throw new ResourceNotAcceptableException("Nenhum registro encontrado!");
        }
    }

    private void findByName(ClasseDTO objectDTO) {
        var objectExists = classeRepository.findByNome(objectDTO.getNome());
        if (objectExists != null && objectDTO.getId() == null ||
                objectExists != null && objectDTO.getId() != null && !objectExists.getId().equals(objectDTO.getId()))
            throw new ResourceNotAcceptableException("Registro já cadastrado!");
    }
}
