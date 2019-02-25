package br.com.podce.adm.service.suporte;

import br.com.podce.adm.repository.suporte.SimpleJpaRepositoryCuston;
import br.com.podce.exceptions.PodceException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Victor Alexsander
 *
 */
@Service
public abstract class ServiceSuporteImpl<E,K> implements ServiceSuporte<E,K> {

    private SimpleJpaRepositoryCuston<E,K> repository;

    public ServiceSuporteImpl(SimpleJpaRepositoryCuston<E,K> repository){
        this.repository = repository;
    }

    public ServiceSuporteImpl(){

    }

    @Override
    public List<E> buscaTodos(){
        return repository.findAll();
    }

    public E buscaPorId(K id){
        Optional<E> entidade = repository.findById(id);
        if(!entidade.isPresent()){
            new PodceException("Nenhum registro encontrado");
        }
        return entidade.get();
    }

    @Override
    @Transactional
    public E salvar(E entidade){
        return repository.save(entidade);
    }

    @Override
    @Transactional
    public List<E> salvarTodos(List<E> entidade){
        return repository.saveAll(entidade);
    }

    @Override
    @Transactional
    public void remover(E entidade){
        repository.delete(entidade);
    }
}
