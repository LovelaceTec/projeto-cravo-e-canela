package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lovelacetech.apadrinhamento.dao.UsuarioDAO;
import lovelacetech.apadrinhamento.model.Usuarios;

@Service
public class UsuariosServiceImpl implements IUsuariosService{
    
    @Autowired
    private UsuarioDAO dao;

    @Override
    public Usuarios criarNovo(Usuarios novo) {
        // TODO Auto-generated method stub
        if(novo.getEmail_usuario() != null) {
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public Usuarios atualizarDados(Usuarios dados) {
        // TODO Auto-generated method stub
        if(dados.getId_usuario() != null && dados.getId_usuario() != null) {
            return dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<Usuarios> buscarTodos() {
        // TODO Auto-generated method stub
        return (ArrayList<Usuarios>)dao.findAll();
    }

    @Override
    public Usuarios buscarPeloId(Integer id) {
        // TODO Auto-generated method stub
        return dao.findById(id).orElse(null);
    }

    @Override
    public void excluirUsuario(Integer id) {
        // TODO Auto-generated method stub
        dao.deleteById(id);
    }


}   
