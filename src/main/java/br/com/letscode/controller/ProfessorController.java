package br.com.letscode.controller;

import br.com.letscode.entity.Professor;
import br.com.letscode.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorRepository professorRepository;

    @PostMapping("criar")
    public String create(@RequestBody Professor professor) {
        this.professorRepository.save(professor);
        return "Professor criado com sucesso.";
    }

    @GetMapping("buscar_todos")
    public Iterable<Professor> findAll() {
        return professorRepository.findAll();
    }

    @GetMapping("buscarid")
    public Optional<Professor> findById(@RequestBody int id) {
        return professorRepository.findById(id);
    }

    @PutMapping("atualizar")
    public Professor update(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @DeleteMapping("deletarid")
    public String deleteById(@RequestBody int i) {
        var professor = professorRepository.findById(i);
        this.professorRepository.deleteById(i);
        return professor.get().getNome() + " deletado com sucesso.";
    }

    @DeleteMapping("deletar_todos")
    public String deleteAll() {
        professorRepository.deleteAll();
        return "Todos os professores foram deletados com sucesso";
    }

}
