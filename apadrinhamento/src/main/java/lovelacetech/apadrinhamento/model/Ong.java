package lovelacetech.apadrinhamento.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ongs")
public class Ong {
	
	@Column(name="id_ong")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ong;
	
	@Column(name="nome_ong", length = 100, nullable = false)
	private String nome_ong;
	
	@Column(name="cnpj_ong", length = 20, nullable = false)
	private String cnpj_ong;

	@OneToMany(mappedBy = "id_animal", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("animais")
	private List<Animais> listaAnimais;

	public Integer getId_ong() {
		return id_ong;
	}

	public void setId_ong(Integer id_ong) {
		this.id_ong = id_ong;
	}

	public String getNome_ong() {
		return nome_ong;
	}

	public void setNome_ong(String nome_ong) {
		this.nome_ong = nome_ong;
	}

	public String getCnpj_ong() {
		return cnpj_ong;
	}

	public void setCnpj_ong(String cnpj_ong) {
		this.cnpj_ong = cnpj_ong;
	}

	public List<Animais> getListaAnimais() {
		return listaAnimais;
	}

	public void setListaAnimais(List<Animais> listaAnimais) {
		this.listaAnimais = listaAnimais;
	}
	
}
