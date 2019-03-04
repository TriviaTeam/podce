package br.com.podce.adm.service;

import br.com.podce.adm.dto.ServicoDTO;
import br.com.podce.adm.jpa.model.Servico;
import br.com.podce.adm.parse.ServicoParser;
import br.com.podce.adm.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 *
 * @author Victor Alexsander
 *
 */
@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public ServicoDTO salvar(ServicoDTO servicoDTO) {
        Servico servico = ServicoParser.get().paraEntidade(servicoDTO);
        servico.setDataCadastro(LocalDate.now());
        servico = servicoRepository.save(servico);
        return ServicoParser.get().paraDTO(servico);
    }
}
