package br.com.horizon.service;

import br.com.horizon.dto.FiltroPassagemDTO;
import br.com.horizon.dto.PassagemDTO;
import br.com.horizon.dto.VooDTO;

import java.util.List;

public interface VooService {

    VooDTO create(VooDTO object);

    VooDTO update(VooDTO object, Long id);

    List<VooDTO> findAll();

    VooDTO findById(Long id);

    void cancelById(Long id);

    List<VooDTO> findByFilter(FiltroPassagemDTO filtroPassagemDTO);
}
