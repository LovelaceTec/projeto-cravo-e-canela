package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lovelacetech.apadrinhamento.dao.OngDAO;
import lovelacetech.apadrinhamento.model.Ong;

@Service
public class OngServiceImpl implements IOngService{

	@Autowired
	private OngDAO dao;
	
	@Override
	public Ong criarNovo(Ong novo) {
		// TODO Auto-generated method stub
		if(novo.getNome_ong() != null) {
			return dao.save(novo);
		}
		return null;
	}

	@Override
	public Ong atualizarDados(Ong dados) {
		// TODO Auto-generated method stub
		if(dados.getId_ong () != null && dados.getNome_ong() != null) {
			return dao.save(dados);
		}
		return null;
	}

	@Override
	public ArrayList<Ong> buscarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Ong>)dao.findAll();
	}

	@Override
	public Ong buscarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void excluirOng(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
