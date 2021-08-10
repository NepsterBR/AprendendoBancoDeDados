package br.com.letscode.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "disciplina")
@Getter
@Setter
public class Disciplina {

    @Id
    @Column(name = "codigo_disciplina")
    private int codigoDisciplina;

    @Column(name = "nome_diciplina")
    private String nomeDisciplina;

    @Column(name = "carga_horaria_pratica")
    private int cargaPratica;

    @Column(name = "carga_horaria_teorica")
    private int cargaTeorica;
}
