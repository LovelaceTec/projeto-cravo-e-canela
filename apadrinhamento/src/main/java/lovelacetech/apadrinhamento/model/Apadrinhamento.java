package lovelacetech.apadrinhamento.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="apadrinhamento")
public class Apadrinhamento {
	
	@Column(name="id_apadrinhamento")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_apadrinhamento;
	
	
	private Integer id_animal;
	
	
	private Integer id_ong;
	
	
	private Integer id_pessoa;
	
	@DateTimeFormat(pattern="dd/MM/YYYY")
	private LocalDate data_apadrinhamento = LocalDate.now();
	
	@Column(name="valor", nullable=true)
	private Double valor;
	
	@Column(name="forma_apagamento", length = 20 , nullable=false)
	private String forma_apagamento;
	
	@Column(name="tipo_transacao", length = 1, nullable=true)
	private String tipo_transacao;
	
	@Column(name="status_transacao", length = 1, nullable = true)
	private String status_transacao;

	public Integer getId_apadrinhamento() {
		return id_apadrinhamento;
	}

	public void setId_apadrinhamento(Integer id_apadrinhamento) {
		this.id_apadrinhamento = id_apadrinhamento;
	}

	public Integer getId_animal() {
		return id_animal;
	}

	public void setId_animal(Integer id_animal) {
		this.id_animal = id_animal;
	}

	public Integer getId_ong() {
		return id_ong;
	}

	public void setId_ong(Integer id_ong) {
		this.id_ong = id_ong;
	}

	public Integer getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Integer id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public Date getData_apadrinhamento() {
		return data_apadrinhamento;
	}

	public void setData_apadrinhamento(Date data_apadrinhamento) {
		this.data_apadrinhamento = data_apadrinhamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getForma_apagamento() {
		return forma_apagamento;
	}

	public void setForma_apagamento(String forma_apagamento) {
		this.forma_apagamento = forma_apagamento;
	}

	public String getTipo_transacao() {
		return tipo_transacao;
	}

	public void setTipo_transacao(String tipo_transacao) {
		this.tipo_transacao = tipo_transacao;
	}

	public String getStatus_transacao() {
		return status_transacao;
	}

	public void setStatus_transacao(String status_transacao) {
		this.status_transacao = status_transacao;
	}


}
