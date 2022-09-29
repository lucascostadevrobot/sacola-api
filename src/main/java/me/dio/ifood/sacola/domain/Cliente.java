package me.dio.ifood.sacola.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "tab_cliente")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    //Inicio dos atributos da classe Cliente
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Embedded
    private Endereco endereco;

    //Getters e Setters gerados pelo Lombok

}
