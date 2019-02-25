package br.com.podce.adm.repository;

import br.com.podce.adm.jpa.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Victor Alexsander
 *
 */
@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>  {

}

