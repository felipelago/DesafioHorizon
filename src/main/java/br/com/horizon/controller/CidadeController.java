package br.com.horizon.controller;

import br.com.horizon.dto.CidadeDTO;
import br.com.horizon.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CidadeDTO>> findAll() {
        return new ResponseEntity<>(this.cidadeService.findAll(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CidadeDTO> create(@RequestBody @Valid CidadeDTO objectDTO) {
        return new ResponseEntity<>(this.cidadeService.create(objectDTO), HttpStatus.OK);
    }


}
