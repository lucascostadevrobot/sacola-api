package me.dio.ifood.sacola.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private int quantidade;

    //Relacionamento da entidade onde uma sacola podem ter vários itens
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Sacola sacola;
}
