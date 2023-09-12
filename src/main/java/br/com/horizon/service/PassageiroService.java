package br.com.horizon.service;

import br.com.horizon.dto.PassageiroDTO;

import java.util.List;

public interface PassageiroService {

    PassageiroDTO create(PassageiroDTO object);

    PassageiroDTO update(PassageiroDTO object, Long id);

    List<PassageiroDTO> findAll();

    PassageiroDTO findById(Long id);

}
