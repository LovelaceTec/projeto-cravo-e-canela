package lovelacetech.apadrinhamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

    @Column(name="email_apadrinhador", length=50, nullable=false)
    private String email_apadrinhador;

    @OneToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

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

    public String getEmail_apadrinhador() {
        return email_apadrinhador;
    }

    public void setEmail_apadrinhador(String email_apadrinhador) {
        this.email_apadrinhador = email_apadrinhador;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    
}
