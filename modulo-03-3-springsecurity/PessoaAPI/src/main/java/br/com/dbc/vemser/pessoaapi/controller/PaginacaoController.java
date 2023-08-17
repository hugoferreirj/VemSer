package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paginacao")
@Slf4j
@AllArgsConstructor
public class PaginacaoController {

    private final EnderecoRepository enderecoRepository;
    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;

    // Controller
    @GetMapping("/contatos")
    public List<ContatoEntity> findContatosSortedUsingPages(Integer pagina, Integer quantidadeRegistros){
        Sort ordenacao = Sort.by("descricao");

        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
        Page<ContatoEntity> contatoEntitiesPaginado = contatoRepository.findAllUsingPages(pageable);
        return contatoEntitiesPaginado.getContent();
    }

    @GetMapping("/enderecos")
    public List<EnderecoEntity> findEnderecosSortedUsingPages(Integer pagina, Integer quantidadeRegistros){
        Sort ordenacao = Sort.by("cep");

        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
        Page<EnderecoEntity> enderecoEntitiesPaginado = enderecoRepository.findAllUsingPages(pageable);
        return enderecoEntitiesPaginado.getContent();
    }

    @GetMapping("/enderecos-por-pais")
    public List<EnderecoEntity> findEnderecosFilteredUsingPages(Integer pagina, Integer quantidadeRegistros, @RequestParam String pais){
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros);
        Page<EnderecoEntity> enderecoEntitiesPaginado = enderecoRepository.findbyPaisUsingPages(pageable, pais);
        return enderecoEntitiesPaginado.getContent();
    }
}
