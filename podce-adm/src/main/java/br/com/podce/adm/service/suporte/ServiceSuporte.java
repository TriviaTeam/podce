package br.com.podce.adm.service.suporte;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceSuporte<E,K> {

    List<E> buscaTodos();
    E buscaPorId(K id);
    E salvar(E entidade);
    List<E> salvarTodos(List<E> entidade);
    void remover(E entidade);

}
