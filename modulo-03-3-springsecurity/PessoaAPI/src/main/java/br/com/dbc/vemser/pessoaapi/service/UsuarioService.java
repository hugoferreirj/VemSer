package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.dbc.vemser.pessoaapi.entity.CargoEntity;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.CargoRepository;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final CargoRepository cargoRepository;
    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Integer getIdLoggedUser() {
        Integer findUserId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findUserId;
    }

    public UsuarioEntity getLoggedUser() throws RegraDeNegocioException {
        return findById(getIdLoggedUser());
    }

    public UsuarioEntity findById(Integer idUsuario) throws RegraDeNegocioException {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new RegraDeNegocioException("Usuário não encontrado!"));
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO create(UsuarioDTO usuarioDTO) throws RegraDeNegocioException {

        if(usuarioRepository.existsByLogin(usuarioDTO.getLogin())) {
            throw new RegraDeNegocioException("Nome de usuário já está em uso.");
        }

        String encodedPassword = passwordEncoder.encode(usuarioDTO.getSenha());
        usuarioDTO.setSenha(encodedPassword);
        UsuarioEntity usuarioEntity = objectMapper.convertValue(usuarioDTO, UsuarioEntity.class);

        Set<CargoEntity> cargos = new HashSet<>();
        if (usuarioDTO.getCargos() != null) {
            for (Integer cargoId : usuarioDTO.getCargos()) {
                CargoEntity cargo = cargoRepository.findById(cargoId)
                        .orElseThrow(() -> new RegraDeNegocioException("Cargo não encontrado: " + cargoId));
                cargos.add(cargo);
            }
            usuarioEntity.setCargos(cargos);
        }

        LoginDTO usuarioCreated = objectMapper.convertValue(usuarioRepository.save(usuarioEntity), LoginDTO.class);

        return usuarioCreated;
    }
}
