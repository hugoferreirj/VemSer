package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.documentacao.ProfessorControllerDoc;
import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.service.ProfessorService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@Data
@RequestMapping("/professor") // localhost:8080/professor
public class ProfessorController implements ProfessorControllerDoc {

    private final ProfessorService professorService;

    @GetMapping // GET localhost:8080/professor
    public ResponseEntity<List<ProfessorEntity>> list() {
        return new ResponseEntity<>(professorService.list(), HttpStatus.OK);
    }

    @PostMapping // POST localhost:8080/professor
    public ResponseEntity<ProfessorEntity> create(@Valid @RequestBody ProfessorEntity professor) {
        return new ResponseEntity<>(professorService.create(professor), HttpStatus.OK);
    }
}
