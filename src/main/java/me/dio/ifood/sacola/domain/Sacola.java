package me.dio.ifood.sacola.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import me.dio.ifood.sacola.enumeracao.FormaPagamento;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false) //Um cliente pode ter várias sacolas
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itensSacola;
    private double valorTotalSacola;
    @Enumerated
    private FormaPagamento formaPagamento;
    private boolean fechada = false;


    //Getters e Setters gerados pelo Lombok



    //Geração de repasse dos hashcodes e equals da anotação @Data
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sacola sacola = (Sacola) o;
        return id != null && Objects.equals(id, sacola.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
