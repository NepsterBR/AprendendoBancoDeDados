package br.com.letscode.request;

import br.com.letscode.entity.Curso;
import br.com.letscode.entity.Disciplina;
import br.com.letscode.entity.Modalidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplinaRequest {

    private int codigoDisciplina;
    private String nomeDisciplina;
    private int cargaPratica;
    private int cargaTeorica;

    public Disciplina convert(){
        return new Disciplina(codigoDisciplina, nomeDisciplina, cargaPratica, cargaTeorica);
    }
}
