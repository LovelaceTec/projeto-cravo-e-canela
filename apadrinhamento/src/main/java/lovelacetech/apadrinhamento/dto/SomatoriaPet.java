package lovelacetech.apadrinhamento.dto;

public class SomatoriaPet {
	public Double somatoria;
	public Double porcentagem_meta;
	public SomatoriaPet(Double somatoria, Double porcentagem_meta) {
		super();
		this.somatoria = somatoria;
		this.porcentagem_meta = porcentagem_meta;
	}
	public Double getSomatoria() {
		return somatoria;
	}
	public void setSomatoria(Double somatoria) {
		this.somatoria = somatoria;
	}
	public Double getPorcentagem_meta() {
		return porcentagem_meta;
	}
	public void setPorcentagem_meta(Double porcentagem_meta) {
		this.porcentagem_meta = porcentagem_meta;
	}
	
	

}
