package lovelacetech.apadrinhamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="animais")
public class Animais {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_animal")
    private Integer id_animal;

    @Column(name="id_ong", nullable=false)
    private Integer id_ong;

    @Column(name="nome_pet", length=100, nullable=false)
    private String nome_pet;

    @Column(name="resumo_pet", columnDefinition = "TEXT")
    private String resumo_pet;

    @Column(name="foto_pet", length=255, nullable=true)
    private String foto_pet;

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
    public String getNome_pet() {
        return nome_pet;
    }
    public void setNome_pet(String nome_pet) {
        this.nome_pet = nome_pet;
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
    
}
