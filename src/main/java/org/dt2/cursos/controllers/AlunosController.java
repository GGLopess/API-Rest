package org.dt2.cursos.controllers;


import org.dt2.cursos.entities.Alunos;
import org.dt2.cursos.repositories.AlunosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunosController {
    private final AlunosRepository repository;
    public AlunosController(AlunosRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Alunos> mostrar(){
        return repository.findAll();
    }

    @PostMapping
    public String criarAlunos(@RequestBody Alunos alu){
        try {
            repository.save(alu);
            return "Salvo com sucesso";
        }
        catch (Exception e){
            return "Dados incorretos";
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id){
        try {
            repository.deleteById(id);
            return "excluido com sucesso!";
        }
        catch (Exception e){
            return "Não foi possivel exluir!";
        }
    }

    @GetMapping("/{id}")
    public void buscarid(@PathVariable int id){
        repository.findById(id);
    }

    @PutMapping("/{id}")
    public void atualizar (@PathVariable int id, @RequestBody Alunos a){
        Alunos alunos = repository.getReferenceById(id);
        alunos.setNome(a.getNome());
        alunos.setEmail(a.getEmail());
        alunos.setMatricula(a.getMatricula());
        repository.save(alunos);
    }

}
