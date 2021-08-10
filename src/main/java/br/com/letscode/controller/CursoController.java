package br.com.letscode.controller;

import br.com.letscode.entity.Curso;
import br.com.letscode.repository.CursoRepository;
import br.com.letscode.request.CursoRequest;
import br.com.letscode.request.CursoRequestAtualizado;
import br.com.letscode.response.CursoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/curso")
public class CursoController {

    private final CursoRepository cursoRepository;

    @PostMapping("criar")
    public ResponseEntity<CursoResponse> criar(
            @RequestBody CursoRequest cursoRequest,
            UriComponentsBuilder uriComponentsBuilder) {
        var curso = cursoRequest.convert();
        cursoRepository.save(curso);
        URI uri = uriComponentsBuilder.path("/cursos/{codigoCurso}")
                .buildAndExpand(curso.getCodigoCurso()).toUri();
        return ResponseEntity.created(uri).body(new CursoResponse(curso));
    }

    @GetMapping("buscar_todos")
    public List<CursoResponse> findAll() {
        var cursos = cursoRepository.findAll();
        return CursoResponse.convert(cursos);
    }

    @GetMapping("/{codigoCurso}")
    public CursoResponse findById(@PathVariable int codigoCurso) {
        var curso = cursoRepository.getById(codigoCurso);
        return new CursoResponse(curso);
    }

    @PutMapping("/{codigoCurso}")
    public ResponseEntity<CursoResponse> update(
            @PathVariable int codigoCurso,
            @RequestBody CursoRequestAtualizado cursoRequestAtualizado) {
        var curso = cursoRequestAtualizado.convert(codigoCurso);
        cursoRepository.save(curso);
        return ResponseEntity.ok().body(new CursoResponse(curso));
    }

    @DeleteMapping("/{codigoCurso}")
    public ResponseEntity<?> deleteById(@PathVariable int codigoCurso) {
        cursoRepository.deleteById(codigoCurso);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("deletar_todos")
    public String deleteAll() {
        cursoRepository.deleteAll();
        return "Todos os cursos foram deletados com sucesso";
    }
}
