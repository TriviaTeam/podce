package br.com.podce.adm.repository;

import br.com.podce.adm.jpa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Victor Alexsander
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryCustom  {

    @Query("select u from Usuario u")
    List<Usuario> buscarTodos();
}

