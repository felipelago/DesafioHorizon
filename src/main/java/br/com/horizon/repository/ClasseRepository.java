package br.com.horizon.repository;

import br.com.horizon.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {

    Classe findByNome(String nome);

}
