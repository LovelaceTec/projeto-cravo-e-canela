package lovelacetech.apadrinhamento.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lovelacetech.apadrinhamento.model.Usuarios;
import lovelacetech.apadrinhamento.service.IUsuariosService;

@RestController
public class UsuariosController {
    
    @Autowired
    private IUsuariosService service;
    
    @CrossOrigin
    @GetMapping("/usuarios")
    public ArrayList<Usuarios> recuperarTodos() {
        return service.buscarTodos();
    }
    @CrossOrigin
    @PostMapping("/usuarios")
    public ResponseEntity<Usuarios> incluirNovo(@RequestBody Usuarios novo) {
        Usuarios res = service.criarNovo(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/usuarios")
    public ResponseEntity<Usuarios> alterar(@RequestBody Usuarios dados) {
        Usuarios res = service.atualizarDados(dados);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Usuarios> excluirUsuarios(@PathVariable Integer id) {
        service.excluirUsuario(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuarios> buscarPeloId(@PathVariable Integer id) {
        Usuarios res= service.buscarPeloId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
}
