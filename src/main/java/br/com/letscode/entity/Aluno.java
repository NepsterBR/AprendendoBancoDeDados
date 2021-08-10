package br.com.letscode.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
@Getter
@Setter
public class Aluno {

    @Id
    private int ra;
    private String nome;
    private String sobrenome;

    @Column(name = "data_nascimento")
    private Date dataNascimento;


    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso")
    private int codigoCurso;
}
