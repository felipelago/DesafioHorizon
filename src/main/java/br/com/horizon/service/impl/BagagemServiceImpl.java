package br.com.horizon.service.impl;

import br.com.horizon.dto.BagagemDTO;
import br.com.horizon.error.ResourceNotAcceptableException;
import br.com.horizon.model.Bagagem;
import br.com.horizon.repository.BagagemRepository;
import br.com.horizon.service.BagagemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BagagemServiceImpl implements BagagemService {

    @Autowired
    private BagagemRepository bagagemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BagagemDTO create(BagagemDTO object) {
        var categorySaved = bagagemRepository.save(this.modelMapper.map(object, Bagagem.class));
        return this.modelMapper.map(categorySaved, BagagemDTO.class);
    }

    @Override
    public BagagemDTO update(BagagemDTO brandDTO, Long id) {
        brandDTO.setId(id);
        existsById(id);
        var brandSaved = bagagemRepository.save(this.modelMapper.map(brandDTO, Bagagem.class));
        return this.modelMapper.map(brandSaved, BagagemDTO.class);
    }

    @Override
    public List<BagagemDTO> findAll() {
        var brands = bagagemRepository.findAll();
        return brands.stream().map(brand -> this.modelMapper.map(brand, BagagemDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BagagemDTO findById(Long id) {
        existsById(id);
        return this.modelMapper.map(bagagemRepository.findById(id), BagagemDTO.class);
    }

    private void existsById(Long id) {
        if (!bagagemRepository.existsById(id)) {
            throw new ResourceNotAcceptableException("Nenhum registro encontrado!");
        }
    }

}
