package br.com.horizon.repository;

import br.com.horizon.model.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {

    Aeroporto findByNome(String nome);
}
