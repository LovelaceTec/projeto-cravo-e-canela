package lovelacetech.apadrinhamento.dto;


import java.time.LocalDate;


import lovelacetech.apadrinhamento.model.Animais;
import lovelacetech.apadrinhamento.model.Apadrinhadores;


public class ApadrinhamentoPorOng {

	private Integer id_apadrinhamento;
	private Animais animal;
	private Apadrinhadores pessoa;
	private LocalDate data_apadrinhamento;
	private Double valor;
	private String status_transacao;
	public ApadrinhamentoPorOng(Integer id_apadrinhamento, Animais animal, Apadrinhadores pessoa,
			LocalDate data_apadrinhamento, Double valor, String status_transacao) {
		super();
		this.id_apadrinhamento = id_apadrinhamento;
		this.animal = animal;
		this.pessoa = pessoa;
		this.data_apadrinhamento = data_apadrinhamento;
		this.valor = valor;
		this.status_transacao = status_transacao;
	}
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
