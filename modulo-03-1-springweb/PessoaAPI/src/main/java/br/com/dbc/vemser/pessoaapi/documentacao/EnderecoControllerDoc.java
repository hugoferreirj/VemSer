package br.com.dbc.vemser.pessoaapi.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface EnderecoControllerDoc {
    @Operation(summary = "Listar endereços", description = "Lista todos os endereços do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // GET localhost:8080/endereco
    public ResponseEntity<List<EnderecoDTO>> list();

    @Operation(summary = "Listar endereços de uma pessoa", description = "Lista todos os endereços de uma pessoa utilizando id da pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços de uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}/pessoa") // GET localhost:8080/contato/{idPessoa}
    public ResponseEntity<List<EnderecoDTO>> listByPessoa(@PathVariable("idPessoa") Integer id);

    @Operation(summary = "Retornar um endereço pelo ID", description = "Retorna um endereço pelo ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idEndereco}") // GET localhost:8080/endereco/{idPessoa}
    public ResponseEntity<List<EnderecoDTO>> listByEndereco(@PathVariable("idEndereco") Integer id);

    @Operation(summary = "Criar um novo endereço", description = "Cria um endereço associado a uma pessoa pelo ID da pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria um novo endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}") // POST localhost:8080/endereco/{idPessoa}
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception;

    @Operation(summary = "Editar um endereço", description = "Edita um endereço pelo ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Edita um endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idEndereco}") // PUT localhost:8080/endereco/{idEndereco}
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                                              @Valid @RequestBody EnderecoDTO enderecoAtualizar) throws RegraDeNegocioException;

    @Operation(summary = "Deletar um endereço", description = "Deleta um endereço pelo ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta um endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/{idContato}
    public ResponseEntity<Void> delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException;
}
