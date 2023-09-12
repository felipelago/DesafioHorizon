package br.com.horizon.service;

import br.com.horizon.dto.FiltroPassagemDTO;
import br.com.horizon.dto.PassagemDTO;
import br.com.horizon.dto.VooClasseDTO;

import java.util.List;

public interface VooClasseService {

    VooClasseDTO create(VooClasseDTO object);

    VooClasseDTO update(VooClasseDTO object, Long id);

    List<VooClasseDTO> findAll();

    VooClasseDTO findById(Long id);

}
