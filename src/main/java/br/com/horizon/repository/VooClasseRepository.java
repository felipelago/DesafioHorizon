package br.com.horizon.repository;

import br.com.horizon.model.VooClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VooClasseRepository extends JpaRepository<VooClasse, Long> {

}
