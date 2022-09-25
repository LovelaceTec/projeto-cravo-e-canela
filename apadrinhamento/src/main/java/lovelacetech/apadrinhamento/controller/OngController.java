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

import lovelacetech.apadrinhamento.model.Ong;
import lovelacetech.apadrinhamento.service.IOngService;

@RestController
public class OngController {
	
	@Autowired
	private IOngService service;

	 @CrossOrigin
	@GetMapping("/ong")
	public ArrayList<Ong> recuperarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping("/ong/{id}")
	public ResponseEntity<Ong> buscarPeloId(@PathVariable Integer id){
		Ong resultado = service.buscarPeloId(id);
		if(resultado != null) {
			return ResponseEntity.ok(resultado);
		}
		return ResponseEntity.notFound().build();
	}
	
	 @CrossOrigin
	@PostMapping("/ong")
	public ResponseEntity<Ong> incluirNovo(@RequestBody Ong novo) {
		Ong resultado = service.criarNovo(novo);
		if(resultado != null) {
			return ResponseEntity.ok(resultado);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/ong")
	public ResponseEntity<Ong> alterar(@RequestBody Ong dados){
		Ong resultado = service.atualizarDados(dados);
		if (dados != null) {
			return ResponseEntity.ok(resultado);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/ong/{id}")
	public ResponseEntity<Ong> excluirOng(@PathVariable Integer id){
		service.excluirOng(id);
		return ResponseEntity.ok(null);
	
	}

}
