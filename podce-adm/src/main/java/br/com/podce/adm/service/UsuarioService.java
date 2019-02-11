package br.com.podce.adm.service;

import br.com.podce.adm.jpa.model.Usuario;
import br.com.podce.adm.service.suporte.ServiceSuporte;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService extends ServiceSuporte<Usuario, Long> {

}
