package br.com.horizon.service;

import br.com.horizon.dto.BagagemDTO;

import java.util.List;

public interface BagagemService {

    BagagemDTO create(BagagemDTO object);

    BagagemDTO update(BagagemDTO object, Long id);

    List<BagagemDTO> findAll();

    BagagemDTO findById(Long id);

}
