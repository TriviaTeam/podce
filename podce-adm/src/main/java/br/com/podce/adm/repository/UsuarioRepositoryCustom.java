package br.com.podce.adm.repository;

import br.com.podce.adm.jpa.model.Usuario;

public interface UsuarioRepositoryCustom {

    Usuario buscaUsuarioPorId(Long id);
}
