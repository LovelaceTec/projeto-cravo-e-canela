package lovelacetech.apadrinhamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="animais")
public class Animais {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_animal")
    private Integer id_animal;

    @ManyToOne
	@JoinColumn(name = "id_ong")
	@JsonIgnoreProperties("listaAnimais")
	private Ong id_ong;

    @Column(name="nome_pet", length=100, nullable=false)
    private String nome_pet;

    @Column(name="especie_pet", length=50, nullable = true)
    private String especie_pet;

    @Column(name="idade_pet", length=10, nullable = true)
    private String idade_pet;

    @Column(name="sexo_pet", length=1, nullable = true)
    private String sexo_pet;

    @Column(name="resumo_pet", columnDefinition = "TEXT")
    private String resumo_pet;

    @Column(name="foto_pet", length=255, nullable=true)
    private String foto_pet;
    
    //@DateTimeFormat(pattern="dd/MM/YYYY")
	//private LocalDate inicio_campanha = LocalDate.; inicio apadrinhamento

    //@DateTimeFormat(pattern="dd/MM/YYYY")
	//private LocalDate final_campanha = LocalDate.; final apadrinhamento

    @Column(name="meta", nullable=false)
    private Double meta;

    public Integer getId_animal() {
        return id_animal;
    }

    public void setId_animal(Integer id_animal) {
        this.id_animal = id_animal;
    }

    public Ong getId_ong() {
        return id_ong;
    }

    public void setId_ong(Ong id_ong) {
        this.id_ong = id_ong;
    }

    public String getNome_pet() {
        return nome_pet;
    }

    public void setNome_pet(String nome_pet) {
        this.nome_pet = nome_pet;
    }

    public String getEspecie_pet() {
        return especie_pet;
    }

    public void setEspecie_pet(String especie_pet) {
        this.especie_pet = especie_pet;
    }

    public String getIdade_pet() {
        return idade_pet;
    }

    public void setIdade_pet(String idade_pet) {
        this.idade_pet = idade_pet;
    }

    public String getSexo_pet() {
        return sexo_pet;
    }

    public void setSexo_pet(String sexo_pet) {
        this.sexo_pet = sexo_pet;
    }

    public String getResumo_pet() {
        return resumo_pet;
    }

    public void setResumo_pet(String resumo_pet) {
        this.resumo_pet = resumo_pet;
    }

    public String getFoto_pet() {
        return foto_pet;
    }

    public void setFoto_pet(String foto_pet) {
        this.foto_pet = foto_pet;
    }

    public Double getMeta() {
        return meta;
    }

    public void setMeta(Double meta) {
        this.meta = meta;
    }

    
    
}
