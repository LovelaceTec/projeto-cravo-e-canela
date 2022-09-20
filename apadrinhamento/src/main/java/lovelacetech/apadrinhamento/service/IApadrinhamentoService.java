package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import lovelacetech.apadrinhamento.model.Apadrinhamento;

public interface IApadrinhamentoService {
	public Apadrinhamento criarNovo(Apadrinhamento novo);
	public Apadrinhamento atualizarDados(Apadrinhamento dados);
	public ArrayList<Apadrinhamento> buscarTodos();
	public Apadrinhamento buscarPeloId(Integer id);
	
	// Criei 3 metodos de busca pela FK - ong, animal e pessoa
	public Apadrinhamento buscarPeloIdOng(Integer id);
	public Apadrinhamento buscarPeloIdAnimal(Integer id);
	public Apadrinhamento buscarPeloIdPessoa(Integer id);
	public void excluirApadrinhamento(Integer id);

}
