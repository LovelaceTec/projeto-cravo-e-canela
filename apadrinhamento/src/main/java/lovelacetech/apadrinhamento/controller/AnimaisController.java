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

import lovelacetech.apadrinhamento.model.Animais;
import lovelacetech.apadrinhamento.service.IAnimaisService;

@RestController
public class AnimaisController {
    
    @Autowired
    private IAnimaisService service;

    @CrossOrigin
    @GetMapping("/animais")
    public ArrayList<Animais> recuperarTodos() {
        return service.buscarTodos();
    }

    @CrossOrigin
    @PostMapping("/animais")
    public ResponseEntity<Animais> incluirNovo(@RequestBody Animais novo) {
        Animais res = service.criarNovo(novo);
        if(res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @CrossOrigin
    @PutMapping("/animais")
    public ResponseEntity<Animais> alterar(@RequestBody Animais dados) {
        Animais res = service.atualizarDados(dados);
        if(res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @CrossOrigin
    @DeleteMapping("/animais/{id}")
    public ResponseEntity<Animais> excluirAnimais(@PathVariable Integer id) {
        service.excluirAnimais(id);
        return ResponseEntity.ok(null);
    }

    @CrossOrigin
    @GetMapping("/animais/{id}")
    public ResponseEntity<Animais> buscarPeloId(@PathVariable Integer id) {
        Animais res = service.buscarPeloId(id);
        if(res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
}
