package br.com.letscode.request;

import br.com.letscode.entity.Aluno;
import br.com.letscode.entity.Curso;
import br.com.letscode.entity.Modalidade;
import br.com.letscode.repository.CursoRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CursoRequest {

    private int codigoCurso;
    private String nomeCurso;
    private int duracao;
    private int numeroAlunos;

    public Curso convert(){
        return new Curso(codigoCurso, nomeCurso, duracao, numeroAlunos, Modalidade.PRESENCIAL);
    }
}
