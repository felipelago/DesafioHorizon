package br.com.horizon.service;

import br.com.horizon.dto.FiltroPassagemDTO;
import br.com.horizon.dto.PassagemDTO;

import java.util.List;

public interface PassagemService {

    PassagemDTO create(PassagemDTO object);

    PassagemDTO update(PassagemDTO object, Long id);

    List<PassagemDTO> findAll();

    PassagemDTO findById(Long id);

}
