package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@Slf4j
@AllArgsConstructor
public class ConsultasController {

    private final EnderecoRepository enderecoRepository;
    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;

    @GetMapping("/listar-enderecos-por-pais")
    public ResponseEntity<List<EnderecoEntity>> findAllByPais(@RequestParam String pais) {
        return ResponseEntity.ok(enderecoRepository.findAllByPais(pais));
    }

    @GetMapping("/listar-enderecos-por-pessoa")
    public ResponseEntity<List<EnderecoEntity>> findEnderecosByIdPessoa(@RequestParam Integer idPessoa) {
        return ResponseEntity.ok(enderecoRepository.findAllByIdPessoa(idPessoa));
    }

    @GetMapping("/listar-contatos-por-tipo-de-contato")
    public ResponseEntity<List<ContatoEntity>> findAllWithTipoContato(@RequestParam TipoContato tipoContato) {
        return ResponseEntity.ok(contatoRepository.findAllWithTipoContato(tipoContato));
    }

    @GetMapping("/listar-pessoas-com-endereco")
    public ResponseEntity<List<PessoaEntity>> findAllWithEnderecos() {
        return ResponseEntity.ok(pessoaRepository.findAllWithEnderecos());
    }

    @GetMapping("/listar-enderecos-por-cidade-ou-pais")
    public ResponseEntity<List<EnderecoEntity>> findAllByPaisOrCidade(@RequestParam String nome) {
        return ResponseEntity.ok(enderecoRepository.findAllByPaisOrCidade(nome));
    }

    @GetMapping("/listar-enderecos-sem-complemento")
    public ResponseEntity<List<EnderecoEntity>> findAllWhereComplementoIsNull() {
        return ResponseEntity.ok(enderecoRepository.findAllWhereComplementoIsNull());
    }

    @GetMapping("/listar-contatos-por-pessoa")
    public ResponseEntity<List<ContatoEntity>> findContatosByIdPessoa(@RequestParam Integer idPessoa) {
        return ResponseEntity.ok(contatoRepository.findAllByIdPessoa(idPessoa));
    }

    @GetMapping("/listar-pessoas-sem-endereco")
    public ResponseEntity<List<PessoaEntity>> findAllWithoutEnderecos() {
        return ResponseEntity.ok(pessoaRepository.findAllWithoutEnderecos());
    }
}
