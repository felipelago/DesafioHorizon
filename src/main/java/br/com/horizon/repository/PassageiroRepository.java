package br.com.horizon.repository;

import br.com.horizon.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {

    Passageiro findByNome(String nome);
}
