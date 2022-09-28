package lovelacetech.apadrinhamento.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lovelacetech.apadrinhamento.model.Apadrinhamento;
import lovelacetech.apadrinhamento.dto.ApadrinhamentoPorOng;
import lovelacetech.apadrinhamento.dto.SomatoriaApadrinhador;
import lovelacetech.apadrinhamento.dto.SomatoriaOng;
import lovelacetech.apadrinhamento.dto.SomatoriaPet;

public interface ApadrinhamentoDAO extends CrudRepository<Apadrinhamento, Integer> {
	
	@Query("SELECT new "
		 + "lovelacetech.apadrinhamento.dto.ApadrinhamentoPorOng(a.id_apadrinhamento,a.animal,a.pessoa,a.data_apadrinhamento,a.valor, a.status_transacao) "
		 + "FROM Apadrinhamento a "
		 + "WHERE id_ong_pet= :id_ong")
	public ArrayList<ApadrinhamentoPorOng> buscarPorIdOng(@Param("id_ong")Integer id_ong);
	
	
	@Query("SELECT new "
			 + "lovelacetech.apadrinhamento.dto.SomatoriaOng(sum(a.valor)) "
			 + "FROM Apadrinhamento a "
			 + "WHERE id_ong_ap= :id_ong")
	public ArrayList<SomatoriaOng> somatoriaPorIdOng(@Param("id_ong")Integer id_ong);
	
	@Query("SELECT new "
			 + "lovelacetech.apadrinhamento.dto.SomatoriaApadrinhador(sum(a.valor)) "
			 + "FROM Apadrinhamento a "
			 + "WHERE id_pessoa_ap= :id_pessoa")
	public ArrayList<SomatoriaApadrinhador> somatoriaPorIdApad(@Param("id_pessoa")Integer id_pessoa);

	@Query("SELECT new "
			 + "lovelacetech.apadrinhamento.dto.SomatoriaPet(sum(a.valor), ROUND(sum(a.valor)*100/(select meta from Animais where id_pet = :id_pet), 2)) "
			 + "FROM Apadrinhamento a "
			 + "WHERE id_pet_ap= :id_pet")
	public ArrayList<SomatoriaPet> somatoriaPorIdPet(@Param("id_pet")Integer id_pet);
	

}  
