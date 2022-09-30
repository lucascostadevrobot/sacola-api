package me.dio.ifood.sacola.repository;

import me.dio.ifood.sacola.domain.Sacola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SacolaRepository extends JpaRepository <Sacola, Long> {
}
