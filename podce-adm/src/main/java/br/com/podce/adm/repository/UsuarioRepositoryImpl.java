package br.com.podce.adm.repository;

import br.com.podce.adm.jpa.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Victor Alexsander
 *
 */
public class UsuarioRepositoryImpl  implements UsuarioRepositoryCustom {

    @Autowired
    EntityManager entityManager;


    @Override
    public Usuario buscaUsuarioPorId(Long id) {
        String querySQL = "SELECT u FROM Usuario u WHERE u.id = :identificador ";
        TypedQuery<Usuario> query = entityManager.createQuery(querySQL,Usuario.class);
        query.setParameter("identificador",id);
        return query.getSingleResult();
    }
}
