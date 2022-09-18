package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import lovelacetech.apadrinhamento.model.Administrador;

public interface IAdministradorService {
	
	public Administrador criarNovo(Administrador novo);
	public Administrador atualizarDados(Administrador novo);
	public ArrayList<Administrador> buscarTodos(Administrador novo);
	public Administrador buscarPeloId(Integer id);
	public void excluirAdministrador(Integer id);

}
