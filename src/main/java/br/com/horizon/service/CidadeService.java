package br.com.horizon.service;

import br.com.horizon.dto.CidadeDTO;

import java.util.List;

public interface CidadeService {

    CidadeDTO create(CidadeDTO object);

    CidadeDTO update(CidadeDTO object, Long id);

    List<CidadeDTO> findAll();

    CidadeDTO findById(Long id);

}
