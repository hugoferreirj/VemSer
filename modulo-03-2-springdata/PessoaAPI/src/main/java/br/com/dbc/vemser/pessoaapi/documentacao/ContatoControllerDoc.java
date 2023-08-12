package br.com.dbc.vemser.pessoaapi.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface ContatoControllerDoc {

    @Operation(summary = "Listar contatos", description = "Lista todas os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // GET localhost:8080/contato
    public ResponseEntity<List<ContatoDTO>> list();

    @Operation(summary = "Listar contatos de uma pessoa", description = "Lista os contatos de uma pessoa pelo ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos de uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}") // GET localhost:8080/contato/{idPessoa}
    public ResponseEntity<List<ContatoDTO>> listByPessoa(@PathVariable("idPessoa") Integer id) throws EntidadeNaoEncontradaException;

    @Operation(summary = "Criar contato", description = "Cria um novo contato associado a uma pessoa pelo ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria um novo contato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}") // POST localhost:8080/contato/{idPessoa}
    public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoCreateDTO contato, @PathVariable("idPessoa") Integer id) throws RegraDeNegocioException;

    @Operation(summary = "Editar contato", description = "Edita um contato pelo ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Edita um contato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idContato}") // PUT localhost:8080/contato/{idContato}
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                                             @Valid @RequestBody ContatoDTO contatoAtualizar) throws RegraDeNegocioException;

    @Operation(summary = "Deletar contato", description = "Deleta um contato pelo ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta um contato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}") // DELETE localhost:8080/contato/{idContato}
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException;

}
