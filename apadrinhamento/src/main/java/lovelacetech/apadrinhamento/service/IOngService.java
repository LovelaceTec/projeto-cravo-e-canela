package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import lovelacetech.apadrinhamento.model.Ong;

public interface IOngService {
	
	public Ong criarNovo(Ong novo);
	public Ong atualizarDados(Ong dados);
	public ArrayList<Ong> buscarTodos();
	public Ong buscarPeloId(Integer id);
	public void excluirOng(Integer id);

}
