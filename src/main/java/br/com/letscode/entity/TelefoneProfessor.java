package br.com.letscode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "telefone_professor")
public class TelefoneProfessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numero;

    @ManyToOne
    @JoinColumn(name = "registro_professor", referencedColumnName = "registro_professor")
    private Professor registroProfessor;


}
