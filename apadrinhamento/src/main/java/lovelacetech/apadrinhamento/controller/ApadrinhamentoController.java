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
import lovelacetech.apadrinhamento.model.Apadrinhamento;
import lovelacetech.apadrinhamento.service.IApadrinhamentoService;

@RestController
public class ApadrinhamentoController {
	
	@Autowired
	private IApadrinhamentoService service;
	
	@GetMapping("/apadrinhamento")
	public ArrayList<Apadrinhamento> recuperTodos(){
		
		return service.buscarTodos();
		
	}
	
	@PostMapping("/apadrinhamento")
	public ResponseEntity<Apadrinhamento> incluirNovo(@RequestBody Apadrinhamento novo) {
		Apadrinhamento resultado = service.criarNovo(novo);
		if(resultado != null) {
			return ResponseEntity.ok(resultado);
		}
		return ResponseEntity.badRequest().build();
	}
	

    @PutMapping("/apadrinhamento")
    public ResponseEntity<Apadrinhamento> alterar(@RequestBody Apadrinhamento dados) {
    	Apadrinhamento resultado = service.atualizarDados(dados);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/apadrinhamento/{id}")
    public ResponseEntity<Apadrinhamento> excluirApadrinhamento(@PathVariable Integer id) {
        service.excluirApadrinhamento(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/apadrinhamento/{id}")
    public ResponseEntity<Apadrinhamento> buscarPeloId(@PathVariable Integer id) {
    	Apadrinhamento res = service.buscarPeloId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
	
}
