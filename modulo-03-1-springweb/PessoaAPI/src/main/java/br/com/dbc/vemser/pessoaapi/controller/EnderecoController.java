package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco") // localhost:8080/endereco
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping // GET localhost:8080/endereco
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idPessoa}/pessoa") // GET localhost:8080/contato/{idPessoa}
    public List<Endereco> listByPessoa(@PathVariable("idPessoa") Integer id) {
        return enderecoService.listByPessoa(id);
    }

    @GetMapping("/{idEndereco}") // GET localhost:8080/contato/{idPessoa}
    public List<Endereco> listByEndereco(@PathVariable("idEndereco") Integer id) {
        return enderecoService.listByEndereco(id);
    }

    @PostMapping("/{idPessoa}") // POST localhost:8080/contato/{idPessoa}
    public Endereco create(@PathVariable("idPessoa") Integer id, @RequestBody Endereco endereco) {
        endereco.setIdPessoa(id);
        return enderecoService.create(endereco);
    }

    @PutMapping("/{idEndereco}") // PUT localhost:8080/endereco/{idEndereco}
    public Endereco update(@PathVariable("idEndereco") Integer id,
                         @RequestBody Endereco enderecoAtualizar) throws Exception {
        return enderecoService.update(id, enderecoAtualizar);
    }

    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/contato/{idContato}
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }
}
