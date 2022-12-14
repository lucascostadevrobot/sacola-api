package me.dio.ifood.sacola.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "tab_produto")
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernanateLazyInitializer", "handler"}) //Evita e ignora erros no hibernate quando Lazyr
public class Produto {

    //Inicio dos atributos da classe Produto
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private double valorUnitario;
    private boolean disponivel = true;

    //ManyToOne relacionamento da entidade onde em um restaurante podem ter muitos produtos
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;


    //Getters e Setters gerados pelo Lombok

}
