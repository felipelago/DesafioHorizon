package br.com.horizon.controller;

import br.com.horizon.dto.AeroportoDTO;
import br.com.horizon.service.AeroportoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/aeroportos")
public class AeroportoController {

    @Autowired
    private AeroportoService aeroportoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AeroportoDTO>> findAll() {
        return new ResponseEntity<>(this.aeroportoService.findAll(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AeroportoDTO> create(@RequestBody @Valid AeroportoDTO objectDTO) {
        return new ResponseEntity<>(this.aeroportoService.create(objectDTO), HttpStatus.OK);
    }


}
