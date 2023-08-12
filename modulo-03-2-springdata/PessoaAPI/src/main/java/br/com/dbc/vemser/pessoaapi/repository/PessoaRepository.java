package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {


    public List<PessoaEntity> findByPetIsNotNull();

    public Optional<PessoaEntity> findByIdPessoaAndPetIsNotNull(Integer id);

    public List<PessoaEntity> findByContatosIsNotNull();

    public Optional<PessoaEntity> findByIdPessoaAndContatosIsNotNull(Integer id);

    public List<PessoaEntity> findByEnderecosIsNotNull();

    public Optional<PessoaEntity> findByIdPessoaAndEnderecosIsNotNull(Integer id);

    public List<PessoaEntity> findAllByNomeContains(String nome);

    public List<PessoaEntity> findByCpf(String cpf);

    @Query(" select p " +
            "  from PESSOA p" +
            " where p.cpf = ?1")
    List<PessoaEntity> listPessoasByCpf(String cpf);

    @Query(value = " select p.* " +
            "         from PESSOA p" +
            "        where p.cpf = :cpf", nativeQuery = true)
    List<PessoaEntity> listPessoasByCpfNative(@Param("cpf") String cpf);

}