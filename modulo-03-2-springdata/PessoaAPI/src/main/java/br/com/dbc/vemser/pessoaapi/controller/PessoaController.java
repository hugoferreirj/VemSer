package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.documentacao.PessoaControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Slf4j
public class PessoaController implements PessoaControllerDoc {

    // Modelo ANTIGO de Injeção
    // @Autowired
    private final PessoaService pessoaService;

    @Value("${user}")
    private String usuario;

    @Value("${spring.application.name}")
    private String app;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/hello") // GET localhost:8080/pessoa/hello
    public String hello() {
        log.info("hello");
        return "Hello WORLD!\n" + " <br>App: " + app + " <br>Usuario: " + usuario;
    }

    @GetMapping("/hello-2") // GET localhost:8080/pessoa/hello-2
    public String hello2() {
        return "Hello world 2!";
    }

    @GetMapping // GET localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() {
        return new ResponseEntity<>(pessoaService.list(), HttpStatus.OK);
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") String nome) {
        return new ResponseEntity<>(pessoaService.listByName(nome), HttpStatus.OK);
    }

    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        log.info("criando pessoa");
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                            @RequestBody PessoaDTO pessoaAtualizar) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        PessoaDTO pessoaAlterada = pessoaService.update(id, pessoaAtualizar);
        return ResponseEntity.ok(pessoaAlterada);
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byname-contains") // GET localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<PessoaDTO>> findAllByNomeContains(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(pessoaService.findAllByNomeContains(nome));
    }


    @GetMapping("/listar-com-pets")
    public ResponseEntity<List<PessoaPetDTO>> findAllWithPetsOrByIdPessoa(@RequestParam(required = false) Integer id) throws RegraDeNegocioException {
        return ResponseEntity.ok(pessoaService.findAllWithPetsOrByIdPessoa(id));
    }

    @GetMapping("/listar-com-contatos")
    public ResponseEntity<List<PessoaContatosDTO>> findAllWithContatosOrByIdPessoa(@RequestParam(required = false) Integer id) throws RegraDeNegocioException {
        return ResponseEntity.ok(pessoaService.findAllWithContatosOrByIdPessoa(id));
    }

    @GetMapping("/listar-com-enderecos")
    public ResponseEntity<List<PessoaEnderecosDTO>> findAllWithEnderecosOrByIdPessoa(@RequestParam(required = false) Integer id) throws RegraDeNegocioException {
        return ResponseEntity.ok(pessoaService.findAllWithEnderecosOrByIdPessoa(id));
    }


}
