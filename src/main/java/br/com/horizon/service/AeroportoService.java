package br.com.horizon.service;

import br.com.horizon.dto.AeroportoDTO;

import java.util.List;

public interface AeroportoService {

    AeroportoDTO create(AeroportoDTO object);

    AeroportoDTO update(AeroportoDTO object, Long id);

    List<AeroportoDTO> findAll();

    AeroportoDTO findById(Long id);

}
