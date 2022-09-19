package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import lovelacetech.apadrinhamento.model.Animais;

public interface IAnimaisService {
    public Animais criarNovo(Animais novo);
    public Animais atualizarDados(Animais dados);
    public ArrayList<Animais> buscarTodos();
    public Animais buscarPeloId(Integer id);
    public void excluirAnimais(Integer id);
}
