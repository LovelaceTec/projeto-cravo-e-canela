package lovelacetech.apadrinhamento.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lovelacetech.apadrinhamento.dao.ApadrinhadoresDAO;
import lovelacetech.apadrinhamento.model.Apadrinhadores;

@Service
public class ApadrinhadoresServiceImpl implements IApadrinhadoresService{

    @Autowired
    private ApadrinhadoresDAO dao;

    @Override
    public Apadrinhadores criarNovo(Apadrinhadores novo) {
        // TODO Auto-generated method stub
        if(novo.getNome_pessoa() != null) {
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public Apadrinhadores atualizarDados(Apadrinhadores dados) {
        // TODO Auto-generated method stub
        if(dados.getId_pessoa() != null && dados.getNome_pessoa() != null) {
            return dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<Apadrinhadores> buscarTodos() {
        // TODO Auto-generated method stub
        return (ArrayList<Apadrinhadores>)dao.findAll();
    }

    @Override
    public Apadrinhadores buscarPeloId(Integer id) {
        // TODO Auto-generated method stub
        return dao.findById(id).orElse(null);
    }

    @Override
    public void excluirApadrinhadores(Integer id) {
        // TODO Auto-generated method stub
        dao.deleteById(id);
    }
}
