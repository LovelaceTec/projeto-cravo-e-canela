package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import lovelacetech.apadrinhamento.model.Apadrinhadores;

public interface IApadrinhadoresService {
    public Apadrinhadores criarNovo(Apadrinhadores novo);
    public Apadrinhadores atualizarDados(Apadrinhadores dados);
    public ArrayList<Apadrinhadores> buscarTodos();
    public Apadrinhadores buscarPeloId(Integer id);
    public void excluirApadrinhadores(Integer id);
}
