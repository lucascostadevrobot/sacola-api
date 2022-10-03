package me.dio.ifood.sacola.resource.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Builder
@Embeddable //Essa classe não será uma tabela no Banco de Dados. Essa Entidade aparecerá dentro da tab_restaurante
@AllArgsConstructor
@RequiredArgsConstructor
public class ItemDto {
    /*
    * A ideia das Classe DTO Data Trasnfer Object é um padrão bastante utilizado em java para transferencia
    * de Dados entre diferentes componentes de um sistema.
    * Seria muito verboso ter que passar cada atributo INDIVIDUALMENTE. Da mesma forma seria verboso ou
    * até causaria erros passar uma ENTIDADE mais complexa.
    *
    * */
    private Long produtoId;
    private int quantidade;
    private Long sacolaId;
}
