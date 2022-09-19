package lovelacetech.apadrinhamento.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lovelacetech.apadrinhamento.model.Apadrinhadores;
import lovelacetech.apadrinhamento.service.IApadrinhadoresService;

@RestController
public class ApadrinhadoresController {

    @Autowired
    private IApadrinhadoresService service;

    @GetMapping("/apadrinhadores")
    public ArrayList<Apadrinhadores> recuperarTodos() {
        return service.buscarTodos();
    }

    @PostMapping("/apadrinhadores")
    public ResponseEntity<Apadrinhadores> incluirNovo(@RequestBody Apadrinhadores novo) {
        Apadrinhadores res = service.criarNovo(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/apadrinhadores")
    public ResponseEntity<Apadrinhadores> alterar(@RequestBody Apadrinhadores dados) {
        Apadrinhadores res = service.atualizarDados(dados);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/apadrinhadores/{id}")
    public ResponseEntity<Apadrinhadores> excluirApadrinhadores(@PathVariable Integer id) {
        service.excluirApadrinhadores(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/apadrinhadores/{id}")
    public ResponseEntity<Apadrinhadores> buscarPeloId(@PathVariable Integer id) {
        Apadrinhadores res = service.buscarPeloId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
}
