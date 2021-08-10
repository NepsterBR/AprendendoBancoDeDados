package br.com.letscode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
@Getter
@Setter
public class Curso {
    @Id
    @Column(name = "codigo_curso")
    private int codigoCurso;

    @Column(name = "nome_curso")
    private String nomeCurso;

    private int duracao;

    @Column(name = "numero_alunos")
    private int numeroAlunos;

    @Enumerated(EnumType.STRING)
    private Modalidade modalidade;
}
