package org.dt2.cursos.controllers;


import org.dt2.cursos.entities.Cursos;
import org.dt2.cursos.repositories.CursosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursosController {
    private final CursosRepository repository;
    public CursosController(CursosRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Cursos> mostrar(){
        return repository.findAll();
    }

    @PostMapping
    public String criarCursos(@RequestBody Cursos cur){
        try {
            repository.save(cur);
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
    public void atualizar (@PathVariable int id, @RequestBody Cursos c){
        Cursos cursos = repository.getReferenceById(id);
        cursos.setNome(c.getNome());
        cursos.setDescricao(c.getDescricao());
        cursos.setCargaHoraria(c.getCargaHoraria());
        repository.save(cursos);
    }

}
