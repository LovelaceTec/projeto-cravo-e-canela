package lovelacetech.apadrinhamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="apadrinhadores")
public class Apadrinhadores {

    @Column(name="id_pessoa")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_pessoa;

    @Column(name="nome_pessoa", length=250, nullable=false)
    private String nome_pessoa;

    @Column(name="cpf_pessoa", length=11, nullable=false)
    private String cpf_pessoa;

    public Integer getId_pessoa() {
        return id_pessoa;
    }
    public void setId_pessoa(Integer id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    public String getNome_pessoa() {
        return nome_pessoa;
    }
    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }
    public String getCpf_pessoa() {
        return cpf_pessoa;
    }
    public void setCpf_pessoa(String cpf_pessoa) {
        this.cpf_pessoa = cpf_pessoa;
    }
}
