package me.dio.ifood.sacola.repository;

import me.dio.ifood.sacola.domain.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository <Restaurante, Long> {

}
