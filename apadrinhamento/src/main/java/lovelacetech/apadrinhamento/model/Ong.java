package lovelacetech.apadrinhamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name="email_ong", length = 50, nullable = false)
	private String email_ong;
	
	@Column(name="senha_ong", length = 30, nullable = true)
	private String senha_ong;
	
	@Column(name="codigo_banco_ong", length = 4, nullable = true)
	private String codigo_banco_ong;
	
	@Column(name="agencia_ong", length = 6, nullable = true)
	private String agencia_ong;
	
	@Column(name="conta_corrente_ong", length = 10, nullable = true)
	private String conta_corrente_ong;

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

	public String getSenha_ong() {
		return senha_ong;
	}

	public void setSenha_ong(String senha_ong) {
		this.senha_ong = senha_ong;
	}

	public String getCodigo_banco_ong() {
		return codigo_banco_ong;
	}

	public void setCodigo_banco_ong(String codigo_banco_ong) {
		this.codigo_banco_ong = codigo_banco_ong;
	}

	public String getAgencia_ong() {
		return agencia_ong;
	}

	public void setAgencia_ong(String agencia_ong) {
		this.agencia_ong = agencia_ong;
	}

	public String getConta_corrente_ong() {
		return conta_corrente_ong;
	}

	public void setConta_corrente_ong(String conta_corrente_ong) {
		this.conta_corrente_ong = conta_corrente_ong;
	}
	
	
}
