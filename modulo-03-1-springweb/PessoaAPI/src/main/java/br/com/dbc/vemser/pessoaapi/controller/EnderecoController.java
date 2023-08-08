package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.documentacao.EnderecoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
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
@RequestMapping("/endereco") // localhost:8080/endereco
public class EnderecoController implements EnderecoControllerDoc {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping // GET localhost:8080/endereco
    public ResponseEntity<List<EnderecoDTO>> list() {
        return new ResponseEntity<>(enderecoService.list(), HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}/pessoa") // GET localhost:8080/contato/{idPessoa}
    public ResponseEntity<List<EnderecoDTO>> listByPessoa(@PathVariable("idPessoa") Integer id) {
        return new ResponseEntity<>(enderecoService.listByPessoa(id), HttpStatus.OK);
    }

    @GetMapping("/{idEndereco}") // GET localhost:8080/endereco/{idPessoa}
    public ResponseEntity<List<EnderecoDTO>> listByEndereco(@PathVariable("idEndereco") Integer id) {
        return new ResponseEntity<>(enderecoService.listByEndereco(id), HttpStatus.OK);
    }

    @PostMapping("/{idPessoa}") // POST localhost:8080/endereco/{idPessoa}
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        log.info("Criar endereço");
        return new ResponseEntity<>(enderecoService.create(id, endereco), HttpStatus.OK);
    }

    @PutMapping("/{idEndereco}") // PUT localhost:8080/endereco/{idEndereco}
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                                              @Valid @RequestBody EnderecoDTO enderecoAtualizar) throws RegraDeNegocioException {
        log.info("Editar endereço");
        return new ResponseEntity<>(enderecoService.update(id, enderecoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/{idContato}
    public ResponseEntity<Void> delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        log.info("Deletar endereço");
        enderecoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
