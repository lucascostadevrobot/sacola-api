package me.dio.ifood.sacola.service.implementa;

import me.dio.ifood.sacola.domain.Item;
import me.dio.ifood.sacola.domain.Sacola;
import me.dio.ifood.sacola.resource.dto.ItemDto;

public interface SacolaService {
    /*
    * A classe que tiver um contrato com essa Interface terá que incluir os metodos de:
    * incluirItemNaSacola; verSacola; fecharSacola.
    *
    *
    * */
    Item incluirItemNaSacaola(ItemDto itemDto); //Metodo para incluir itens na sacola passando Classe ItemDto
    Sacola verSacola(Long id); //Metodo para visualizar sacola
    Sacola fecharSacola(Long id, int formaPagamento); //throws RuntimeException; //Metodo para fechar a sacola

}
