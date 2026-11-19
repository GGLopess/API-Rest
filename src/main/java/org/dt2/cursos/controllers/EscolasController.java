package org.dt2.cursos.controllers;
import org.dt2.cursos.entities.Escolas;
import org.dt2.cursos.repositories.EscolasRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escolas")
public class EscolasController {
    private final EscolasRepository repository;
    public EscolasController(EscolasRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Escolas> mostrar(){
        return repository.findAll();
    }

    @PostMapping
    public String criarEscolas(@RequestBody Escolas esc){
        try {
            repository.save(esc);
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
    public void atualizar (@PathVariable int id, @RequestBody Escolas e){
        Escolas escolas = repository.getReferenceById(id);
        escolas.setNome(e.getNome());
        escolas.setCNPJ(e.getCNPJ());
        escolas.setEndereco(e.getEndereco());
        repository.save(escolas);
    }

}
