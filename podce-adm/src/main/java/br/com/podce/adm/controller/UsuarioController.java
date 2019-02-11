package br.com.podce.adm.controller;

import br.com.podce.adm.controller.suporte.ControllerSuporte;
import br.com.podce.adm.dto.UsuarioDTO;
import br.com.podce.adm.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController implements ControllerSuporte<UsuarioDTO,Long> {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(name = "buscaTodos")
    public ResponseEntity<List<UsuarioDTO>> buscaTodos(){
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    @GetMapping(name = "buscaPorId")
    public ResponseEntity<UsuarioDTO> buscaPorId(@PathVariable("id") Long id){
        return new ResponseEntity<>(new UsuarioDTO(), HttpStatus.OK);
    }

    @PostMapping(name = "salvar")
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO){
        return new ResponseEntity<>(new UsuarioDTO(), HttpStatus.OK); // TODO: Precisa fazer as classes de parser
    }

    @PostMapping(name = "salvar")
    public ResponseEntity<List<UsuarioDTO>> salvarTodos(List<UsuarioDTO> usuarioDTO){
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK); // TODO: Precisa fazer as classes de parser
    }

    @DeleteMapping(name = "delete")
    public ResponseEntity<UsuarioDTO> remover(@PathVariable("id") Long id){
        return new ResponseEntity<>(new UsuarioDTO(), HttpStatus.OK);
    }
}
