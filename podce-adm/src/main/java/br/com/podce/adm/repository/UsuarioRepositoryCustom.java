package br.com.podce.adm.repository;

import br.com.podce.adm.jpa.model.Usuario;

/**
 *
 * @author Victor Alexsander
 *
 */
public interface UsuarioRepositoryCustom {

    Usuario buscaUsuarioPorId(Long id);
}
