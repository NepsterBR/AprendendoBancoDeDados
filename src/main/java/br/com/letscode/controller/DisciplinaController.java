package br.com.letscode.controller;

import br.com.letscode.entity.Disciplina;
import br.com.letscode.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaRepository disciplinaRepository;

    @PostMapping("criar")
    public String create(@RequestBody Disciplina cdp) {
        this.disciplinaRepository.save(cdp);
        return "Disciplina criada com sucesso.";
    }

    @GetMapping("buscar_todos")
    public Iterable<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    @GetMapping("buscarid")
    public Optional<Disciplina> findById(@RequestBody int id) {
        return disciplinaRepository.findById(id);
    }

    @PutMapping("atualizar")
    public Disciplina update(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @DeleteMapping("deletarid")
    public String deleteById(@RequestBody int i) {
        var disciplina = disciplinaRepository.findById(i);
        this.disciplinaRepository.deleteById(i);
        return disciplina.get().getNomeDisciplina() + " deletado com sucesso.";
    }

    @DeleteMapping("deletar_todos")
    public String deleteAll() {
        disciplinaRepository.deleteAll();
        return "Todas as disciplinas foram deletadas com sucesso";
    }

}
