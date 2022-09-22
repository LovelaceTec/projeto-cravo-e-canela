package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import lovelacetech.apadrinhamento.model.Usuarios;

public interface IUsuariosService {
    public Usuarios criarNovo(Usuarios novo);
    public Usuarios atualizarDados(Usuarios dados);
    public ArrayList<Usuarios> buscarTodos();
    public Usuarios buscarPeloId(Integer id);
    public void excluirUsuario(Integer id);
}
