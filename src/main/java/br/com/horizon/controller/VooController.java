package br.com.horizon.controller;

import br.com.horizon.dto.FiltroPassagemDTO;
import br.com.horizon.dto.VooDTO;
import br.com.horizon.service.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/voos")
public class VooController {

    @Autowired
    private VooService vooService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VooDTO> create(@RequestBody @Valid VooDTO objectDTO) {
        return new ResponseEntity<>(this.vooService.create(objectDTO), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VooDTO> update(@RequestBody @Valid VooDTO objectDTO, @PathVariable("id") Long id) {
        return new ResponseEntity<>(this.vooService.update(objectDTO, id), HttpStatus.OK);
    }

    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VooDTO> findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(this.vooService.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "cancelar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> cancelById(@PathVariable(name = "id") Long id) {
        this.vooService.cancelById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/findByFilter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VooDTO>> findByFilter(@ModelAttribute FiltroPassagemDTO filtroPassagemDTO) {
        return new ResponseEntity<>(this.vooService.findByFilter(filtroPassagemDTO), HttpStatus.OK);
    }

}