package br.com.horizon.controller;

import br.com.horizon.dto.PassageiroDTO;
import br.com.horizon.service.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/passageiros")
public class PassageiroController {

    @Autowired
    private PassageiroService passageiroService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PassageiroDTO>> findAll() {
        return new ResponseEntity<>(this.passageiroService.findAll(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PassageiroDTO> create(@RequestBody @Valid PassageiroDTO objectDTO) {
        return new ResponseEntity<>(this.passageiroService.create(objectDTO), HttpStatus.OK);
    }


}
