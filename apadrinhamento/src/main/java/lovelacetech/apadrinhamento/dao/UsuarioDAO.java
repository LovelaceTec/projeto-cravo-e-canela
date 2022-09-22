package lovelacetech.apadrinhamento.dao;

import org.springframework.data.repository.CrudRepository;

import lovelacetech.apadrinhamento.model.Usuarios;

public interface UsuarioDAO extends CrudRepository<Usuarios, Integer>{
    
}
