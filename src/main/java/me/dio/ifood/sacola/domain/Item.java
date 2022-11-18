package me.dio.ifood.sacola.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernanateLazyInitializer", "handler"}) //Evita e ignora erros no hibernate quando Lazyr
@Entity
public class Item {
    //Inicio dos atributos da classe Item
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantidade;


    @ManyToOne //(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;



    //Relacionamento da entidade onde uma sacola podem ter vários itens
    @ManyToOne(fetch = FetchType.LAZY)
    private Sacola sacola;
}
