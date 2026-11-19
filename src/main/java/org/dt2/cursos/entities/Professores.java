package org.dt2.cursos.entities;

import jakarta.persistence.*;

@Entity
public class Professores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String especialidade;
    @ManyToOne
    @JoinColumn(name = "escola_id")
    private Escolas escola;

    public Professores(long id, String nome, String email, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.especialidade = especialidade;
    }

    public Professores(String nome, String email, String especialidade) {
        this.nome = nome;
        this.email = email;
        this.especialidade = especialidade;
    }
    public Professores(){}

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
