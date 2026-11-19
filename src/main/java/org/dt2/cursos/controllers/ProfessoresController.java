package org.dt2.cursos.controllers;
import org.dt2.cursos.entities.Professores;
import org.dt2.cursos.repositories.ProfessoresRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class ProfessoresController {
    private final ProfessoresRepository repository;
    public ProfessoresController(ProfessoresRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Professores> mostrar(){
        return repository.findAll();
    }

    @PostMapping
    public String criarProfessores(@RequestBody Professores pro){
        try {
            repository.save(pro);
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
    public void atualizar (@PathVariable int id, @RequestBody Professores p){
        Professores professores = repository.getReferenceById(id);
        professores.setNome(p.getNome());
        professores.setEmail(p.getEmail());
        professores.setEspecialidade(p.getEspecialidade());
        repository.save(professores);
    }

}
