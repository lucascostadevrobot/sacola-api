package me.dio.ifood.sacola.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "tab_restaurante")
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernanateLazyInitializer", "handler"}) //Evita e ignora erros no hibernate quando Lazyr
public class Restaurante {

    @Id
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

