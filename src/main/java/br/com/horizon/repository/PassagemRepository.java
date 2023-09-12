package br.com.horizon.repository;

import br.com.horizon.model.Classe;
import br.com.horizon.model.Passagem;
import br.com.horizon.model.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long> {

    long countByVooAndClasse(Voo voo, Classe classe);
}
