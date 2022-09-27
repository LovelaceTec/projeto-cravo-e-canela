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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="animais")
public class Animais {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_pet")
    private Integer id_animal;

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
    
    @DateTimeFormat(pattern="dd/MM/YYYY")
	private LocalDate inicio_campanha = LocalDate.of(2022, 04, 25); //inicio apadrinhamento

    @DateTimeFormat(pattern="dd/MM/YYYY")
	private LocalDate fim_campanha = LocalDate.of(2022, 06, 01); //final apadrinhamento

    @Column(name="meta", nullable=false)
    private Double meta;

    @ManyToOne
	@JoinColumn(name = "id_ong_pet")
	@JsonIgnoreProperties("listaAnimais")
	private Ong id_ong;

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

    public LocalDate getInicio_campanha() {
        return inicio_campanha;
    }

    public void setInicio_campanha(LocalDate inicio_campanha) {
        this.inicio_campanha = inicio_campanha;
    }

    public LocalDate getFim_campanha() {
        return fim_campanha;
    }

    public void setFim_campanha(LocalDate fim_campanha) {
        this.fim_campanha = fim_campanha;
    }

    public Double getMeta() {
        return meta;
    }

    public void setMeta(Double meta) {
        this.meta = meta;
    }
}
