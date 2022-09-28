package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import lovelacetech.apadrinhamento.dto.ApadrinhamentoPorOng;
import lovelacetech.apadrinhamento.dto.SomatoriaOng;
import lovelacetech.apadrinhamento.model.Apadrinhamento;

public interface IApadrinhamentoService {
	public Apadrinhamento criarNovo(Apadrinhamento novo);
	public Apadrinhamento atualizarDados(Apadrinhamento dados);
	public ArrayList<Apadrinhamento> buscarTodos();
	public Apadrinhamento buscarPeloId(Integer id);
	public void excluirApadrinhamento(Integer id);	
	public ArrayList<ApadrinhamentoPorOng> buscarPorIdOng(Integer id_ong);
	public ArrayList<SomatoriaOng> somatoriaPorIdOng(Integer id_ong);
}
