package lovelacetech.apadrinhamento.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@Column(name="email_ong", length = 50, nullable = true)
	private String email_ong;

	@Column(name="telefone_ong", length = 15, nullable = true)
	private String telefone_ong;

	@Column(name="pix_ong", length = 100, nullable = true)
	private String pix_ong;

	@Column(name="cadastro_validado", length = 1, nullable = true)
	private String cadastro_validado;

	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

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

	public String getEmail_ong() {
		return email_ong;
	}

	public void setEmail_ong(String email_ong) {
		this.email_ong = email_ong;
	}

	public String getTelefone_ong() {
		return telefone_ong;
	}

	public void setTelefone_ong(String telefone_ong) {
		this.telefone_ong = telefone_ong;
	}

	public String getPix_ong() {
		return pix_ong;
	}

	public void setPix_ong(String pix_ong) {
		this.pix_ong = pix_ong;
	}

	public String getCadastro_validado() {
		return cadastro_validado;
	}

	public void setCadastro_validado(String cadastro_validado) {
		this.cadastro_validado = cadastro_validado;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public List<Animais> getListaAnimais() {
		return listaAnimais;
	}

	public void setListaAnimais(List<Animais> listaAnimais) {
		this.listaAnimais = listaAnimais;
	}
}
