package br.com.horizon.controller;

import br.com.horizon.dto.ClasseDTO;
import br.com.horizon.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClasseDTO>> findAll() {
        return new ResponseEntity<>(this.classeService.findAll(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClasseDTO> create(@RequestBody @Valid ClasseDTO objectDTO) {
        return new ResponseEntity<>(this.classeService.create(objectDTO), HttpStatus.OK);
    }


}
