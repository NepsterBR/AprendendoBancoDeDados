package br.com.letscode.response;

import br.com.letscode.entity.Aluno;
import br.com.letscode.entity.Professor;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public class ProfessorResponse {

    private int registroProfessor;
    private String nome;

    public ProfessorResponse(Professor professor) {
        this.registroProfessor = professor.getRegistroProfessor();
        this.nome = professor.getNome();
    }

    public static List<ProfessorResponse> convert(List<Professor> professors){
        return professors.stream().map(ProfessorResponse::new).collect(Collectors.toList());
    }
}
