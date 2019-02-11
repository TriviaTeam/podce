package br.com.podce.adm.controller.suporte;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ControllerSuporte<E,K> {

    ResponseEntity<List<E>> buscaTodos();
    ResponseEntity<E> buscaPorId(K id);
    ResponseEntity<E> salvar(E entidade);
    ResponseEntity<List<E>> salvarTodos(List<E> entidade);
    ResponseEntity remover(K id);

}
