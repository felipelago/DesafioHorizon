package br.com.horizon.service.impl;

import br.com.horizon.dto.CidadeDTO;
import br.com.horizon.error.ResourceNotAcceptableException;
import br.com.horizon.model.Cidade;
import br.com.horizon.repository.CidadeRepository;
import br.com.horizon.service.CidadeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CidadeDTO create(CidadeDTO object) {
        findByName(object);
        var categorySaved = cidadeRepository.save(this.modelMapper.map(object, Cidade.class));
        return this.modelMapper.map(categorySaved, CidadeDTO.class);
    }

    @Override
    public CidadeDTO update(CidadeDTO brandDTO, Long id) {
        brandDTO.setId(id);
        findByName(brandDTO);
        existsById(id);
        var brandSaved = cidadeRepository.save(this.modelMapper.map(brandDTO, Cidade.class));
        return this.modelMapper.map(brandSaved, CidadeDTO.class);
    }

    @Override
    public List<CidadeDTO> findAll() {
        var brands = cidadeRepository.findAll();
        return brands.stream().map(brand -> this.modelMapper.map(brand, CidadeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CidadeDTO findById(Long id) {
        existsById(id);
        return this.modelMapper.map(cidadeRepository.findById(id), CidadeDTO.class);
    }

    private void existsById(Long id) {
        if (!cidadeRepository.existsById(id)) {
            throw new ResourceNotAcceptableException("Nenhum registro encontrado!");
        }
    }

    private void findByName(CidadeDTO objectDTO) {
        var objectExists = cidadeRepository.findByNome(objectDTO.getNome());
        if (objectExists != null && objectDTO.getId() == null ||
                objectExists != null && objectDTO.getId() != null && !objectExists.getId().equals(objectDTO.getId()))
            throw new ResourceNotAcceptableException("Registro já cadastrado!");
    }
}
