package org.dt2.cursos.controllers;
import org.dt2.cursos.entities.Turmas;

import org.dt2.cursos.repositories.TurmasRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmasController {
    private final TurmasRepository repository;
    public TurmasController(TurmasRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Turmas> mostrar(){
        return repository.findAll();
    }

    @PostMapping
    public String criarTurmas(@RequestBody Turmas tur){
        try {
            repository.save(tur);
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
    public void atualizar (@PathVariable int id, @RequestBody Turmas t){
        Turmas turmas = repository.getReferenceById(id);
        turmas.setNome(t.getNome());
        repository.save(turmas);
    }

}
