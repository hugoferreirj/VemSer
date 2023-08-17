package br.com.dbc.vemser.pessoaapi.repository;


import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {
    public List<ContatoEntity> findByPessoaEntity(PessoaEntity pessoa);

    @Query("Select c From CONTATO c where c.tipoContato = :tipoContato")
    List<ContatoEntity> findAllWithTipoContato(@Param("tipoContato") TipoContato tipoContato);

    @Query(value = "SELECT * FROM CONTATO C WHERE c.id_pessoa = :idPessoa", nativeQuery = true)
    List<ContatoEntity> findAllByIdPessoa(@Param("idPessoa") Integer idPessoa);

    @Query("select c from CONTATO c")
    Page<ContatoEntity> findAllUsingPages(Pageable pageable);

}
