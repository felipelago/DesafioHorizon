package br.com.horizon.service;

import br.com.horizon.dto.ClasseDTO;

import java.util.List;

public interface ClasseService {

    ClasseDTO create(ClasseDTO object);

    ClasseDTO update(ClasseDTO object, Long id);

    List<ClasseDTO> findAll();

    ClasseDTO findById(Long id);

}
