package org.dt2.cursos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Escolas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private  String CNPJ;
    private String endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "escola")
    private List<Alunos> alunos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "escola")
    private List<Professores> professores = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "escola")
    private List<Cursos> cursos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "escola")
    private List<Salas> salas = new ArrayList<>();

    public Escolas(long id, String nome, String CNPJ, String endereco) {
        this.id = id;
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
    }

    public Escolas(String nome, String CNPJ, String endereco) {
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
    }

    public Escolas(){}

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
