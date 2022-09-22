package lovelacetech.apadrinhamento.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="apadrinhamento")
public class Apadrinhamento {
	
	@Column(name="id_apadrinhamento")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_apadrinhamento;
	
	@ManyToOne
	@JoinColumn(name="id_animal")
	private Animais animal;
	
	@ManyToOne
	@JoinColumn(name="id_ong")
	private Ong ong;
	
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Apadrinhadores pessoa;
	
	@DateTimeFormat(pattern="dd/MM/YYYY")
	private LocalDate data_apadrinhamento = LocalDate.now();
	
	@Column(name="valor", nullable=true)
	private Double valor;
	
	@Column(name="status_transacao", length = 1, nullable = true)
	private String status_transacao;

	public Integer getId_apadrinhamento() {
		return id_apadrinhamento;
	}

	public void setId_apadrinhamento(Integer id_apadrinhamento) {
		this.id_apadrinhamento = id_apadrinhamento;
	}

	public Animais getAnimal() {
		return animal;
	}

	public void setAnimal(Animais animal) {
		this.animal = animal;
	}

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	public Apadrinhadores getPessoa() {
		return pessoa;
	}

	public void setPessoa(Apadrinhadores pessoa) {
		this.pessoa = pessoa;
	}

	public LocalDate getData_apadrinhamento() {
		return data_apadrinhamento;
	}

	public void setData_apadrinhamento(LocalDate data_apadrinhamento) {
		this.data_apadrinhamento = data_apadrinhamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getStatus_transacao() {
		return status_transacao;
	}

	public void setStatus_transacao(String status_transacao) {
		this.status_transacao = status_transacao;
	}
}
