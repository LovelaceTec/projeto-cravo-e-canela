package lovelacetech.apadrinhamento.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lovelacetech.apadrinhamento.model.Apadrinhamento;
import lovelacetech.apadrinhamento.dto.ApadrinhamentoPorOng;

public interface ApadrinhamentoDAO extends CrudRepository<Apadrinhamento, Integer> {
	
	@Query("SELECT new "
		 + "lovelacetech.apadrinhamento.dto.ApadrinhamentoPorOng(a.id_apadrinhamento,a.animal,a.pessoa,a.data_apadrinhamento,a.valor, a.status_transacao) "
		 + "FROM Apadrinhamento a "
		 + "WHERE id_ong_pet= :id_ong")
	public ArrayList<ApadrinhamentoPorOng> buscarPorIdOng(@Param("id_ong")Integer id_ong);

}
