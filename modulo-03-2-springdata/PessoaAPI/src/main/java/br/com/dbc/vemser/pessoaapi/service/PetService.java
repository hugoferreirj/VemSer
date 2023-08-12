package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class PetService {

    private final PetRepository petRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;


    public PetDTO create(PetCreateDTO pet, Integer idPessoa) throws RegraDeNegocioException {
        if (pessoaService.findById(idPessoa) != null) {
            PetEntity entity = objectMapper.convertValue(pet, PetEntity.class);
            entity.setPessoaEntity(pessoaService.findById(idPessoa));

            PetEntity petCriado = petRepository.save(entity);
            PetDTO petDTO = objectMapper.convertValue(petCriado, PetDTO.class);

            return petDTO;
        } else {
            return null;
        }
    }

    public List<PetDTO> list() {
        return petRepository.findAll().stream()
                .map(pet -> objectMapper.convertValue(pet, PetDTO.class))
                .collect(Collectors.toList());
    }

    public PetDTO update(Integer idPet,
                         PetDTO petAtualizar) throws RegraDeNegocioException {
        petAtualizar.setIdPet(idPet);
        PetEntity entity = getPet(petAtualizar.getIdPet());
        if (entity != null) {
            entity.setPessoaEntity(petAtualizar.getPessoaEntity());
            entity.setNome(entity.getNome());
            entity.setTipoPet(entity.getTipoPet());
            petRepository.save((entity));
        }
        return petAtualizar;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        PetEntity petRecuperado = getPet(id);
        if (petRecuperado != null) {
            petRepository.delete(petRecuperado);
        }
    }

    private PetEntity getPet(Integer id) throws RegraDeNegocioException {
        PetEntity petRecuperado = petRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
        return petRecuperado;
    }

    public ContatoDTO retornarDTO(ContatoEntity entity) {
        return objectMapper.convertValue(entity, ContatoDTO.class);
    }
}
