package lovelacetech.apadrinhamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                       // indica que a classe e armazenada no banco de dados
@Table(name="administrador")  // torno explicito o nome da table
public class Administrador {
	
	@Column(name="id_adm")	  // explicito o nome da coluna
	@Id						  // indico que este atributo corresponde a PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // esse atributo é auto-increment
	private Integer id_adm;
	
	@Column(name="nome_adm", length = 150, nullable = true)
	private String nome_adm; 
	
	@Column(name="email_adm", length = 50, nullable = true)
	private String email_adm;
	
	@Column(name="tipo_acesso", length = 15, nullable = true)
	private String tipo_acesso;

	@Column(name="senha_adm", length = 30, nullable = true)
	private String senha_adm;

	public Integer getId_adm() {
		return id_adm;
	}

	public void setId_adm(Integer id_adm) {
		this.id_adm = id_adm;
	}

	public String getNome_adm() {
		return nome_adm;
	}

	public void setNome_adm(String nome_adm) {
		this.nome_adm = nome_adm;
	}

	public String getEmail_adm() {
		return email_adm;
	}

	public void setEmail_adm(String email_adm) {
		this.email_adm = email_adm;
	}

	public String getTipo_acesso() {
		return tipo_acesso;
	}

	public void setTipo_acesso(String tipo_acesso) {
		this.tipo_acesso = tipo_acesso;
	}

	public String getSenha_adm() {
		return senha_adm;
	}

	public void setSenha_adm(String senha_adm) {
		this.senha_adm = senha_adm;
	}

	
		
}
