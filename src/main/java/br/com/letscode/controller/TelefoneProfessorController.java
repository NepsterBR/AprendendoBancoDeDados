package br.com.letscode.controller;

import br.com.letscode.entity.TelefoneProfessor;
import br.com.letscode.repository.TelefoneProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/telefone")
public class TelefoneProfessorController {

    private final TelefoneProfessorRepository telefoneProfessorRepository;

    @PostMapping("criar")
    public String create(@RequestBody TelefoneProfessor professor) {
        this.telefoneProfessorRepository.save(professor);
        return "Telefone adicionado com sucesso.";
    }

    @GetMapping("buscar_todos")
    public Iterable<TelefoneProfessor> findAll() {
        return telefoneProfessorRepository.findAll();
    }

    @GetMapping("buscarid")
    public Optional<TelefoneProfessor> findById(@RequestBody int id) {
        return telefoneProfessorRepository.findById(id);
    }

    @PutMapping("atualizar")
    public TelefoneProfessor update(@RequestBody TelefoneProfessor professor) {
        return telefoneProfessorRepository.save(professor);
    }

    @DeleteMapping("deletarid")
    public String deleteById(@RequestBody int i) {
        var professor = telefoneProfessorRepository.findById(i);
        this.telefoneProfessorRepository.deleteById(i);
        return "Telefone com id " + professor.get().getId() + " deletado com sucesso.";
    }

    @DeleteMapping("deletar_todos")
    public String deleteAll() {
        telefoneProfessorRepository.deleteAll();
        return "Todos os telefones foram deletados com sucesso";
    }

}
