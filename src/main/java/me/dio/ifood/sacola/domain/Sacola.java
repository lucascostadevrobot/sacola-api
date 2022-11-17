package me.dio.ifood.sacola.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import me.dio.ifood.sacola.enumeracao.FormaPagamento;

import javax.persistence.*;
import java.util.List;

@Table(name = "tab_sacola")
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernanateLazyInitializer", "handler"}) //Evita e ignora erros no hibernate quando Lazyr
public class Sacola {
    //Inicio dos atribudos da classe de modelo Sacola
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) //Um cliente pode ter várias sacolas
    @JsonIgnore
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Item> itensSacola;
    private double valorTotalSacola;
    @Enumerated
    private FormaPagamento formaPagamento;
    private boolean fechada = false;


    //Getters e Setters gerados pelo Lombok



}
