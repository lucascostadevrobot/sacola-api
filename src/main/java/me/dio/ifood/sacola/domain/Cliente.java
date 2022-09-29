package me.dio.ifood.sacola.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@Table(name = "tab_cliente")
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernanateLazyInitializer", "handler"}) //Evita e ignora erros no hibernate quando Lazyr
public class Cliente {

    //Inicio dos atributos da classe Cliente
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Embedded
    private Endereco endereco;

    //Getters e Setters gerados pelo Lombok




    //Geração de repasse dos hashcodes e equals da anotação @Data
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cliente cliente = (Cliente) o;
        return id != null && Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
