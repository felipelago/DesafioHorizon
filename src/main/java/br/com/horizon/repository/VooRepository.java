package br.com.horizon.repository;

import br.com.horizon.model.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VooRepository extends JpaRepository<Voo, Long> {

    @Transactional
    @Modifying
    @Query("update Voo e set e.cancelado = true where e.id = :id")
    int cancelById(@Param("id") Long id);

    List<Voo> findAllByAeroportoDestino_NomeContainsAndAeroportoOrigem_NomeContainsAndDataPartidaBetween(String nomeAeroportoDestino, String nomeAeroportoOrigem, LocalDateTime from, LocalDateTime to);

}
