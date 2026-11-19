package org.dt2.cursos.entities;

import jakarta.persistence.*;

@Entity
public class Turmas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Cursos curso;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professores professor;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Salas sala;

    public Turmas(long id, String nome, Cursos curso, Professores professor, Salas sala) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.professor = professor;
        this.sala = sala;
    }

    public Turmas(String nome, Cursos curso, Professores professor, Salas sala) {
        this.nome = nome;
        this.curso = curso;
        this.professor = professor;
        this.sala = sala;
    }
    public Turmas(){}

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public Professores getProfessor() {
        return professor;
    }

    public void setProfessor(Professores professor) {
        this.professor = professor;
    }

    public Salas getSala() {
        return sala;
    }

    public void setSala(Salas sala) {
        this.sala = sala;
    }
}