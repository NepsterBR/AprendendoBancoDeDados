package br.com.letscode.controller;

import br.com.letscode.entity.Aluno;
import br.com.letscode.repository.AlunoRepository;
import br.com.letscode.repository.CursoRepository;
import br.com.letscode.request.AlunoRequest;
import br.com.letscode.request.AlunoRequestAtualizado;
import br.com.letscode.response.AlunoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    @PostMapping("criar")
    public ResponseEntity<AlunoResponse> create(
            @RequestBody AlunoRequest alunoRequest,
            UriComponentsBuilder uriComponentsBuilder) {
        var aluno = alunoRequest.convert(cursoRepository);
        alunoRepository.save(aluno);
        URI uri = uriComponentsBuilder.path("/alunos/{ra}").buildAndExpand(aluno.getRa()).toUri();
        return ResponseEntity.created(uri).body(new AlunoResponse(aluno));
    }

    @GetMapping("buscar_todos")
    public List<AlunoResponse> findAll(String nome, String nomeCurso, String sobrenome, Integer duracao, Integer ano) {
        if (nome != null) {
            List<Aluno> alunos = alunoRepository.findByNome(nome);
            return AlunoResponse.convert(alunos);
        } else if (nomeCurso != null && sobrenome != null) {
            List<Aluno> alunos = alunoRepository.findByCodigoCursoAndSobrenome(nomeCurso, sobrenome);
            return AlunoResponse.convert(alunos);
        } else if (nomeCurso != null) {
            List<Aluno> alunos = alunoRepository.findByCodigoCursoNomeCurso(nomeCurso);
            return AlunoResponse.convert(alunos);
        } else if (duracao != null) {
            List<Aluno> alunos = alunoRepository.findByCodigoCursoDuracaoEquals(duracao);
            return AlunoResponse.convert(alunos);
        } else if (ano != null) {
            List<Aluno> alunos = alunoRepository.findByAnoNascimento(ano);
            return AlunoResponse.convert(alunos);
        } else {
            List<Aluno> alunos = alunoRepository.findAll();
            return AlunoResponse.convert(alunos);
        }
    }

    @GetMapping("/{ra}")
    public AlunoResponse findById(@PathVariable int ra) {
        var aluno = alunoRepository.getById(ra);
        return new AlunoResponse(aluno);
    }

    @PutMapping("/{ra}")
    public ResponseEntity<AlunoResponse> update(
            @PathVariable int ra,
            @RequestBody AlunoRequestAtualizado alunoRequesalunoRequestAtualizado) {
        var aluno = alunoRequesalunoRequestAtualizado.convert(cursoRepository, ra);
        alunoRepository.save(aluno);
        return ResponseEntity.ok(new AlunoResponse(aluno));
    }

    @DeleteMapping("/{ra}")
    public ResponseEntity<?> deleteById(@PathVariable int ra) {
        alunoRepository.deleteById(ra);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("deletar_todos")
    public String deleteAll() {
        alunoRepository.deleteAll();
        return "Todos os alunos foram deletados com sucesso";
    }

}
