package br.com.horizon.service.impl;

import br.com.horizon.dto.AeroportoDTO;
import br.com.horizon.error.ResourceNotAcceptableException;
import br.com.horizon.model.Aeroporto;
import br.com.horizon.repository.AeroportoRepository;
import br.com.horizon.service.AeroportoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AeroportoServiceImpl implements AeroportoService {

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AeroportoDTO create(AeroportoDTO object) {
        findByName(object);
        var categorySaved = aeroportoRepository.save(this.modelMapper.map(object, Aeroporto.class));
        return this.modelMapper.map(categorySaved, AeroportoDTO.class);
    }

    @Override
    public AeroportoDTO update(AeroportoDTO brandDTO, Long id) {
        brandDTO.setId(id);
        findByName(brandDTO);
        existsById(id);
        var brandSaved = aeroportoRepository.save(this.modelMapper.map(brandDTO, Aeroporto.class));
        return this.modelMapper.map(brandSaved, AeroportoDTO.class);
    }

    @Override
    public List<AeroportoDTO> findAll() {
        var brands = aeroportoRepository.findAll();
        return brands.stream().map(brand -> this.modelMapper.map(brand, AeroportoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AeroportoDTO findById(Long id) {
        existsById(id);
        return this.modelMapper.map(aeroportoRepository.findById(id), AeroportoDTO.class);
    }

    private void existsById(Long id) {
        if (!aeroportoRepository.existsById(id)) {
            throw new ResourceNotAcceptableException("Nenhum registro encontrado!");
        }
    }

    private void findByName(AeroportoDTO objectDTO) {
        var objectExists = aeroportoRepository.findByNome(objectDTO.getNome());
        if (objectExists != null && objectDTO.getId() == null ||
                objectExists != null && objectDTO.getId() != null && !objectExists.getId().equals(objectDTO.getId()))
            throw new ResourceNotAcceptableException("Registro já cadastrado!");
    }

}
