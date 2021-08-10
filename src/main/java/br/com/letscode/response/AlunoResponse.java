package br.com.letscode.response;

import br.com.letscode.entity.Aluno;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public class AlunoResponse {

    private int ra;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;

    public AlunoResponse(Aluno aluno) {
        this.ra = aluno.getRa();
        this.nome = aluno.getNome();
        this.sobrenome = aluno.getSobrenome();
        this.dataNascimento = aluno.getDataNascimento();
    }

    public static List<AlunoResponse> convert(List<Aluno> aluno){
        return aluno.stream().map(AlunoResponse::new).collect(Collectors.toList());
    }
}
