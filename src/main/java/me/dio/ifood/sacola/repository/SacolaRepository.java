package me.dio.ifood.sacola.repository;

import me.dio.ifood.sacola.domain.Sacola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SacolaRepository extends JpaRepository <Sacola, Long> {
}
