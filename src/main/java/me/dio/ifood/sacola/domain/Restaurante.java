package me.dio.ifood.sacola.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Table(name = "tab_restaurante")
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernanateLazyInitializer", "handler"}) //Evita e ignora erros no hibernate quando Lazyr
public class Restaurante {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Produto> cardapio;
    @Embedded
    private Endereco endereco;


    //Getters e Setters gerados pelo Lombok
    


}

