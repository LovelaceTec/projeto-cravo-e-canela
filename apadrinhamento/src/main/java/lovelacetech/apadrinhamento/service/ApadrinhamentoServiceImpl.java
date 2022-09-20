package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lovelacetech.apadrinhamento.dao.ApadrinhamentoDAO;
import lovelacetech.apadrinhamento.model.Apadrinhamento;

@Service
public class ApadrinhamentoServiceImpl implements IApadrinhamentoService{
	
	@Autowired
	private ApadrinhamentoDAO dao;

	@Override
	public Apadrinhamento criarNovo(Apadrinhamento novo) {
		// TODO Auto-generated method stub
		if(novo.getId_ong() != null && novo.getId_animal() != null) {
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
		return null;
	}

	@Override
	public Apadrinhamento buscarPeloIdOng(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Apadrinhamento buscarPeloIdAnimal(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Apadrinhamento buscarPeloIdPessoa(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirApadrinhamento(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
