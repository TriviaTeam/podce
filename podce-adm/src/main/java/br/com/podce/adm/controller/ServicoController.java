package br.com.podce.adm.controller;

import br.com.podce.adm.dto.ServicoDTO;
import br.com.podce.adm.jpa.model.Servico;
import br.com.podce.adm.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Victor Alexsander
 *
 */
@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping(path = "salvar")
    public ResponseEntity<ServicoDTO> salvar(@RequestBody ServicoDTO servicoDTO) {
        Servico servico = new Servico(servicoDTO);
        servicoService.salvar(servico);
        return new ResponseEntity<>(servicoDTO, HttpStatus.OK);
    }
}
