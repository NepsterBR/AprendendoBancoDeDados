package br.com.letscode.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professor")
@Getter
@Setter
@ToString
public class Professor {
    @Id
    @Column(name = "registro_professor")
    private int registroProfessor;
    private String nome;
}

