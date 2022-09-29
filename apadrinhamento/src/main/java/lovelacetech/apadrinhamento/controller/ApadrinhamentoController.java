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

import lovelacetech.apadrinhamento.dto.ApadrinhamentoPorOng;
import lovelacetech.apadrinhamento.dto.SomatoriaApadrinhador;
import lovelacetech.apadrinhamento.dto.SomatoriaOng;
import lovelacetech.apadrinhamento.dto.SomatoriaPet;
import lovelacetech.apadrinhamento.model.Apadrinhamento;
import lovelacetech.apadrinhamento.service.IApadrinhamentoService;

@RestController
public class ApadrinhamentoController {
	
	@Autowired
	private IApadrinhamentoService service;
	
	@CrossOrigin
	@GetMapping("/apadrinhamento")
	public ArrayList<Apadrinhamento> recuperTodos(){
		return service.buscarTodos();
	}
	
	@CrossOrigin
	@PostMapping("/apadrinhamento")
	public ResponseEntity<Apadrinhamento> incluirNovo(@RequestBody Apadrinhamento novo) {
		Apadrinhamento resultado = service.criarNovo(novo);
		if(resultado != null) {
			return ResponseEntity.ok(resultado);
		}
		return ResponseEntity.badRequest().build();
	}
	

	@CrossOrigin
    @PutMapping("/apadrinhamento")
    public ResponseEntity<Apadrinhamento> alterar(@RequestBody Apadrinhamento dados) {
    	Apadrinhamento resultado = service.atualizarDados(dados);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.badRequest().build();
    }
	
	
	@CrossOrigin
    @DeleteMapping("/apadrinhamento/{id}")
    public ResponseEntity<Apadrinhamento> excluirApadrinhamento(@PathVariable Integer id) {
        service.excluirApadrinhamento(id);
        return ResponseEntity.ok(null);
    }

	@CrossOrigin
    @GetMapping("/apadrinhamento/{id}")
    public ResponseEntity<Apadrinhamento> buscarPeloId(@PathVariable Integer id) {
    	Apadrinhamento res = service.buscarPeloId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
	
	@CrossOrigin
    @GetMapping("/apadrinhamento/idong/{id_ong}")
    public ArrayList<ApadrinhamentoPorOng> buscarPorIdOng(@PathVariable Integer id_ong) {
    	return service.buscarPorIdOng(id_ong);
    }
	
	@CrossOrigin
    @GetMapping("/somatoria/idong/{id_ong}")
    public ArrayList<SomatoriaOng> somatoriaPorIdOng(@PathVariable Integer id_ong) {
    	return service.somatoriaPorIdOng(id_ong);
    }
	
	@CrossOrigin
    @GetMapping("/somatoria/idpessoa/{id_pessoa}")
    public ArrayList<SomatoriaApadrinhador> somatoriaPorIdApad(@PathVariable Integer id_pessoa) {
    	return service.somatoriaPorIdApad(id_pessoa);
    }
	
	
	@CrossOrigin
    @GetMapping("/somatoria/idpet/{id_pet}")
    public ArrayList<SomatoriaPet> somatoriaPorIdPet(@PathVariable Integer id_pet) {
    	return service.somatoriaPorIdPet(id_pet);
    }
    
}
