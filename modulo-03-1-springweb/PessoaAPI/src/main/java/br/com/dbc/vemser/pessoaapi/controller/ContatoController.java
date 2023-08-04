package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log
@RestController
@Validated
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping // GET localhost:8080/contato
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}") // GET localhost:8080/contato/{idPessoa}
    public List<Contato> listByPessoa(@PathVariable("idPessoa") Integer id) {
        return contatoService.listByPessoa(id);
    }

    @PostMapping("/{idPessoa}") // POST localhost:8080/contato/{idPessoa}
    public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoCreateDTO contato, @PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("Criar contato");
        return new ResponseEntity<>(contatoService.create(contato, id), HttpStatus.OK);
    }

    @PutMapping("/{idContato}") // PUT localhost:8080/contato/{idContato}
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                          @Valid @RequestBody ContatoDTO contatoAtualizar) throws RegraDeNegocioException {
        log.info("Editar contato");
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}") // DELETE localhost:8080/contato/{idContato}
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        log.info("Deletar contato");
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }


}
