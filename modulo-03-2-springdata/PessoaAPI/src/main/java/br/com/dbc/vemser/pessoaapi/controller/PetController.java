package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PetService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@RequestMapping("/pet") // localhost:8080/pet
public class PetController {
    private final PetService petService;

    @GetMapping // GET localhost:8080/pet
    public ResponseEntity<List<PetDTO>> list() {
        return new ResponseEntity<>(petService.list(), HttpStatus.OK);
    }


    @PostMapping("/{idPessoa}") // POST localhost:8080/pet/{idPessoa}
    public ResponseEntity<PetDTO> create(@Valid @RequestBody PetCreateDTO pet, @PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        return new ResponseEntity<>(petService.create(pet, id), HttpStatus.OK);
    }

    @PutMapping("/{idPet}") // PUT localhost:8080/pet/{idPet}
    public ResponseEntity<PetDTO> update(@PathVariable("idPet") Integer id,
                                         @Valid @RequestBody PetDTO petAtualizar) throws RegraDeNegocioException {
        return new ResponseEntity<>(petService.update(id, petAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idPet}") // DELETE localhost:8080/pet/{idPet}
    public ResponseEntity<Void> delete(@PathVariable("idPet") Integer id) throws RegraDeNegocioException {
        petService.delete(id);
        return ResponseEntity.ok().build();
    }


}
