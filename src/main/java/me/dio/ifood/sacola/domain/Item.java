package me.dio.ifood.sacola.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    //Inicio dos atributos da classe Item
    private Long id;
    @Embedded
    private Produto produto;
    private int quantidade;

    //Relacionamento da entidade onde uma sacola podem ter vários itens
    @ManyToOne
    @JoinColumn(name = "sacola_id")
    private Sacola sacola;
}
