package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lovelacetech.apadrinhamento.dao.AdministradorDAO;
import lovelacetech.apadrinhamento.model.Administrador;

@Service
public class AdministradorServiceImpl implements IAdministradorService{
	
	@Autowired
	private AdministradorDAO dao;

	@Override
	public Administrador criarNovo(Administrador novo) {
		// TODO Auto-generated method stub
		if(novo.getNome_adm() != null) {
			dao.save(novo);
		}
		return null;
	}

	@Override
	public Administrador atualizarDados(Administrador dados) {
		// TODO Auto-generated method stub
		
		if(dados.getId_adm() != null && dados.getNome_adm() != null) {
			dao.save(dados);
		}
		return null;
	}

	@Override
	public ArrayList<Administrador> buscarTodos(Administrador novo) {
		// TODO Auto-generated method stub
		
		return (ArrayList<Administrador>)dao.findAll();
	}

	@Override
	public Administrador buscarPeloId(Integer id) {
		// TODO Auto-generated method stub
		
		return dao.findById(id).orElse(null);
	}

	@Override
	public void excluirAdministrador(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}
		
}
