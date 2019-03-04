package br.com.podce.adm.service;

import br.com.podce.adm.dto.ServicoDTO;
import br.com.podce.adm.jpa.model.Servico;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Alexsander
 *
 */
@Service
public interface ServicoService {

    ServicoDTO salvar(ServicoDTO salvar);
}
