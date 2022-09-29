package me.dio.ifood.sacola.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Embeddable;


@Data
@Builder
@Embeddable //Essa classe não será uma tabela no Banco de Dados. Essa Entidade aparecerá dentro da tab_restaurante
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernanateLazyInitializer", "handler"}) //Evita e ignora erros no hibernate quando Lazyr
public class Endereco {
    //Inicio dos atributos da classe endereco
    /* 1º Essa classe tem relacionamento com Cliente e Restaurante
       2º Essa classe não virará uma Entidade no Banco de Dados
     */
    private String cep;
    private String complemento;

    //Getters e Setters gerados pelo Lombok

}
