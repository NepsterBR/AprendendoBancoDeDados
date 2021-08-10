package br.com.letscode.request;

import br.com.letscode.entity.Aluno;
import br.com.letscode.repository.CursoRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AlunoRequest {

    private int ra;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private int codigoCurso;

    public Aluno convert(CursoRepository cursoRepository){
        var cursoOptional = cursoRepository.findById(codigoCurso);
        var curso = cursoOptional.get();

        return new Aluno(ra, nome, sobrenome, dataNascimento, curso.getCodigoCurso());
    }
}
