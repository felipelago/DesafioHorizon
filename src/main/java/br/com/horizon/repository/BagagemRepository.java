package br.com.horizon.repository;

import br.com.horizon.model.Bagagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagagemRepository extends JpaRepository<Bagagem, Long> {

}
