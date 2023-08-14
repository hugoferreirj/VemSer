package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.PessoaContatosDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaEnderecosDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaPetDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

//    @Query("Select p From PESSOA p where (:idPessoa is null or p.idPessoa = :idPessoa)")
//    List<PessoaEntity> findAllComOptional(@Param("idPessoa") Integer idPessoa);


    @Query("Select p From PESSOA p join fetch p.pet pt where (:idPessoa is null or p.idPessoa = :idPessoa)")
    List<PessoaEntity> findAllWithPetsOrByIdPessoa(@Param("idPessoa") Integer idPessoa);

    @Query("Select p From PESSOA p join fetch p.contatos c where (:idPessoa is null or p.idPessoa = :idPessoa)")
    List<PessoaEntity> findAllWithContatosOrByIdPessoa(@Param("idPessoa") Integer idPessoa);

    @Query("Select DISTINCT p From PESSOA p join fetch p.enderecos ep where (:idPessoa is null or p.idPessoa = :idPessoa)")
    List<PessoaEntity> findAllWithEnderecosOrByIdPessoa(@Param("idPessoa") Integer idPessoa);

    @Query("SELECT p FROM PESSOA p WHERE p.dataNascimento BETWEEN :dataInicial AND :dataFinal")
    List<PessoaEntity> findAllWithDataNascimentoBetween(@Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal);
    @Query("Select DISTINCT p From PESSOA p join fetch p.enderecos ep")
    List<PessoaEntity> findAllWithEnderecos();

    @Query(value = "SELECT * FROM Pessoa pe WHERE pe.id_pessoa NOT IN (SELECT DISTINCT p.id_pessoa FROM PESSOA p JOIN Pessoa_X_Pessoa_Endereco pxpe ON p.id_pessoa = pxpe.id_pessoa JOIN ENDERECO_PESSOA ep on ep.id_endereco = pxpe.id_endereco)", nativeQuery = true)
    List<PessoaEntity> findAllWithoutEnderecos();


//    public Optional<PessoaEntity> findByIdPessoaAndPetIsNotNull(Integer id);
//
//    public Optional<PessoaEntity> findByIdPessoaAndContatosIsNotNull(Integer id);
//
//    public Optional<PessoaEntity> findByIdPessoaAndEnderecosIsNotNull(Integer id);

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