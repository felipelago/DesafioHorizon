package br.com.horizon.controller;

import br.com.horizon.dto.PassagemDTO;
import br.com.horizon.dto.VooDTO;
import br.com.horizon.service.PassagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/passagens")
public class PassagemController {

    @Autowired
    private PassagemService passagemService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PassagemDTO>> findAll() {
        return new ResponseEntity<>(this.passagemService.findAll(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PassagemDTO> create(@RequestBody @Valid PassagemDTO objectDTO) {
        return new ResponseEntity<>(this.passagemService.create(objectDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PassagemDTO> findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(this.passagemService.findById(id), HttpStatus.OK);
    }

}
