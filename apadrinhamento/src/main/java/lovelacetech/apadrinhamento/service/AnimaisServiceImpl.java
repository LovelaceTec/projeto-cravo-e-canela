package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lovelacetech.apadrinhamento.dao.AnimaisDAO;
import lovelacetech.apadrinhamento.model.Animais;


@Service
public class AnimaisServiceImpl implements IAnimaisService{
    
    @Autowired
    private AnimaisDAO dao;

    @Override
    public Animais criarNovo(Animais novo) {
        // TODO Auto-generated method stub
        if(novo.getNome_pet() != null) {
            dao.save(novo);
        }
        return null;
    }

    @Override
    public Animais atualizarDados(Animais dados) {
        // TODO Auto-generated method stub
        if(dados.getId_animal() != null && dados.getNome_pet() != null) {
            dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<Animais> buscarTodos() {
        // TODO Auto-generated method stub
        return (ArrayList<Animais>)dao.findAll();
    }

    @Override
    public Animais buscarPeloId(Integer id) {
        // TODO Auto-generated method stub
        return dao.findById(id).orElse(null);
    }

    @Override
    public void excluirAnimais(Integer id) {
        // TODO Auto-generated method stub
        dao.deleteById(id);
    }
   
}
