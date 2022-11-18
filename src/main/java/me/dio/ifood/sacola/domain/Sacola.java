package me.dio.ifood.sacola.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import me.dio.ifood.sacola.enumeracao.FormaPagamento;

import javax.persistence.*;
import java.util.List;

@Table(name = "tab_sacola")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernanateLazyInitializer", "handler"}) //Evita e ignora erros no hibernate quando Lazyr
public class Sacola {
    //Inicio dos atribudos da classe de modelo Sacola
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double valorTotalSacola;


    @ManyToOne //(fetch = FetchType.LAZY, optional = false) //Um cliente pode ter várias sacolas
    @JsonIgnore
    private Cliente cliente;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Item> itensSacola;
    @Enumerated
    private FormaPagamento formaPagamento;
    private boolean fechada = false;


    //Getters e Setters gerados pelo Lombok



}
