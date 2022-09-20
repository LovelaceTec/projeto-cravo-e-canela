package lovelacetech.apadrinhamento.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
