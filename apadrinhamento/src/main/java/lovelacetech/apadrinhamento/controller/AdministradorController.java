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

import lovelacetech.apadrinhamento.model.Administrador;
import lovelacetech.apadrinhamento.service.IAdministradorService;

@RestController
public class AdministradorController {
	
	@Autowired
	private IAdministradorService service;
	
	@GetMapping("/administrador")
	public ArrayList<Administrador> recuperarTodos(){
		return service.buscarTodos(null);
	
	}

	@PostMapping("/administrador")
	public ResponseEntity <Administrador> incluirNovo(@RequestBody Administrador novo) {
		Administrador resultado = service.criarNovo(novo);
		if(resultado != null) {
			return ResponseEntity.ok(resultado);
		}
		return ResponseEntity.badRequest().build();	
	}
	@PutMapping("/administrador")
	public ResponseEntity<Administrador> alterar(@RequestBody Administrador dados){
		Administrador resultado = service.atualizarDados(dados);
		if(dados != null) {
			return ResponseEntity.ok(resultado);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/administrador/{id}")
	public ResponseEntity<Administrador> excluirAdministrador(@PathVariable Integer id){
		service.excluirAdministrador(id);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/administrador/{id_adm}")
	public ResponseEntity<Administrador> buscarPeloId(@PathVariable Integer id_adm){
		Administrador resultado = service.buscarPeloId(id_adm);
		if(resultado != null) {
			return ResponseEntity.ok(resultado);
		}
		return ResponseEntity.notFound().build();
	}
}
