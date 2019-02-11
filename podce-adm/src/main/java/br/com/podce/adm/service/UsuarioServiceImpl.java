package br.com.podce.adm.service;

import br.com.podce.adm.jpa.model.Usuario;
import br.com.podce.adm.service.suporte.ServiceSuporteImpl;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends ServiceSuporteImpl<Usuario, Long> implements UsuarioService {



}
