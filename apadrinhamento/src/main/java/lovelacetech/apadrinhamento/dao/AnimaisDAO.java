package lovelacetech.apadrinhamento.dao;

import org.springframework.data.repository.CrudRepository;

import lovelacetech.apadrinhamento.model.Animais;

public interface AnimaisDAO extends CrudRepository<Animais, Integer>{
    
}
