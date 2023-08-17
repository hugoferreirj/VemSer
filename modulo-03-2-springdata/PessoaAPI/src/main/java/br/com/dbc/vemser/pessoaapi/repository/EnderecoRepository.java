package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

//    @Query("Select p From PESSOA p join fetch p.pet pt where (:idPessoa is null or p.idPessoa = :idPessoa)")
//    List<PessoaEntity> findAllWithPetsOrByIdPessoa(@Param("idPessoa") Integer idPessoa);

    @Query("Select e From ENDERECO_PESSOA e where UPPER(e.pais) = UPPER(:pais)")
    List<EnderecoEntity> findAllByPais(@Param("pais") String pais);

    @Query("Select e From PESSOA p join p.enderecos e where p.idPessoa = :idPessoa")
    List<EnderecoEntity> findAllByIdPessoa(@Param("idPessoa") Integer idPessoa);

    @Query(value = "SELECT * FROM ENDERECO_PESSOA ep WHERE UPPER(ep.cidade) = UPPER(:nome) OR UPPER(ep.pais) = UPPER(:nome)", nativeQuery = true)
    List<EnderecoEntity> findAllByPaisOrCidade(@Param("nome") String nome);

    @Query(value = "SELECT * FROM ENDERECO_PESSOA ep WHERE ep.complemento is null", nativeQuery = true)
    List<EnderecoEntity> findAllWhereComplementoIsNull();

    @Query("Select e From ENDERECO_PESSOA e")
    Page<EnderecoEntity> findAllUsingPages(Pageable pageable);

    @Query("Select e From ENDERECO_PESSOA e where UPPER(e.pais) = UPPER(:pais)")
    Page<EnderecoEntity> findbyPaisUsingPages(Pageable pageable, String pais);
}
