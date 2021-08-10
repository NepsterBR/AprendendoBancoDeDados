package br.com.letscode.repository;

import br.com.letscode.entity.CursoDisciplinaProfessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDisciplinaProfessorRepository extends JpaRepository<CursoDisciplinaProfessor, Integer> {


}
