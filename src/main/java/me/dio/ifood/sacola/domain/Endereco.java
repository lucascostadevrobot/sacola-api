package me.dio.ifood.sacola.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Endereco {
    //Inicio dos atributos da classe endereco
    /* 1º Essa classe tem relacionamento com Cliente e Restaurante
       2º Essa classe não virará uma Entidade no Banco de Dados
     */
    private String cep;
    private String complemento;

    //Getters e Setters gerados pelo Lombok

}
