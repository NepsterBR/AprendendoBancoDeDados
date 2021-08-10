package br.com.letscode.controller;


import br.com.letscode.entity.CursoDisciplinaProfessor;
import br.com.letscode.repository.CursoDisciplinaProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/cursoDisciplina")
public class CursoDisciplinaProfessorController {

    private final CursoDisciplinaProfessorRepository cursoDisciplinaProfessor;

    @PostMapping("criar")
    public String create(@RequestBody CursoDisciplinaProfessor cdp) {
        this.cursoDisciplinaProfessor.save(cdp);
        return "Criado com sucesso.";
    }

    @GetMapping("buscar_todos")
    public Iterable<CursoDisciplinaProfessor> findAll() {
        return cursoDisciplinaProfessor.findAll();
    }

    @GetMapping("buscarid")
    public Optional<CursoDisciplinaProfessor> findById(@RequestBody int id) {
        return cursoDisciplinaProfessor.findById(id);
    }

    @PutMapping("atualizar")
    public CursoDisciplinaProfessor update(@RequestBody CursoDisciplinaProfessor cdp) {
        return cursoDisciplinaProfessor.save(cdp);
    }

    @DeleteMapping("deletarid")
    public String deleteById(@RequestBody int codigoCurso) {
        var curso = cursoDisciplinaProfessor.findById(codigoCurso);
        this.cursoDisciplinaProfessor.deleteById(codigoCurso);
        return curso.get().getId() + " deletado com sucesso.";
    }

    @DeleteMapping("deletar_todos")
    public String deleteAll() {
        cursoDisciplinaProfessor.deleteAll();
        return "Todos foram deletados com sucesso";
    }

}
