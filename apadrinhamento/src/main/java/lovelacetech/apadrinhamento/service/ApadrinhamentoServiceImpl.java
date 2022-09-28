package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lovelacetech.apadrinhamento.dao.ApadrinhamentoDAO;
import lovelacetech.apadrinhamento.dto.ApadrinhamentoPorOng;
import lovelacetech.apadrinhamento.dto.SomatoriaApadrinhador;
import lovelacetech.apadrinhamento.dto.SomatoriaOng;
import lovelacetech.apadrinhamento.dto.SomatoriaPet;
import lovelacetech.apadrinhamento.model.Apadrinhamento;

@Service
public class ApadrinhamentoServiceImpl implements IApadrinhamentoService{
	
	@Autowired
	private ApadrinhamentoDAO dao;

	@Override
	public Apadrinhamento criarNovo(Apadrinhamento novo) {
		// TODO Auto-generated method stub
		if(novo.getOng() != null && novo.getAnimal() != null) {
			return dao.save(novo);
		}
		return null;
	}

	@Override
	public Apadrinhamento atualizarDados(Apadrinhamento dados) {
		// TODO Auto-generated method stub
		if(dados.getId_apadrinhamento() != null) {
			return dao.save(dados);
		}
		return null;
	}

	@Override
	public ArrayList<Apadrinhamento> buscarTodos() {
		// TODO Auto-generated method stub	
	
		return (ArrayList<Apadrinhamento>)dao.findAll();
	}

	@Override
	public Apadrinhamento buscarPeloId(Integer id) {
		// TODO Auto-generated method stub
		
		return dao.findById(id).orElse(null);
	}

	@Override
	public void excluirApadrinhamento(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<ApadrinhamentoPorOng> buscarPorIdOng(Integer id_ong){
		return dao.buscarPorIdOng(id_ong);
	}
	
	@Override
	public ArrayList<SomatoriaOng> somatoriaPorIdOng(Integer id_ong){
		return dao.somatoriaPorIdOng(id_ong);
	}
	
	
	@Override
	public ArrayList<SomatoriaApadrinhador> somatoriaPorIdApad(Integer id_pessoa){
		return dao.somatoriaPorIdApad(id_pessoa);
	}
	
	@Override
	public ArrayList<SomatoriaPet> somatoriaPorIdPet(Integer id_pet){
		return dao.somatoriaPorIdPet(id_pet);
	}

}
