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

    @Column(name="cpf_pessoa", length=11, nullable=false, unique = true)
    private String cpf_pessoa;

    @Column(name="email_pessoa", length=50, nullable=true)
    private String email_pessoa;

    @Column(name="senha_pessoa", length=30, nullable=true)
    private String senha_pessoa;

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

    public String getEmail_pessoa() {
        return email_pessoa;
    }

    public void setEmail_pessoa(String email_pessoa) {
        this.email_pessoa = email_pessoa;
    }

    public String getSenha_pessoa() {
        return senha_pessoa;
    }

    public void setSenha_pessoa(String senha_pessoa) {
        this.senha_pessoa = senha_pessoa;
    }

    
    
}
