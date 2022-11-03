package me.dio.ifood.sacola.service.implementa;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.sacola.domain.Item;
import me.dio.ifood.sacola.domain.Sacola;
import me.dio.ifood.sacola.enumeracao.FormaPagamento;
import me.dio.ifood.sacola.repository.SacolaRepository;
import me.dio.ifood.sacola.resource.dto.ItemDto;
import org.springframework.stereotype.Service;

/*
* Essa classe é a classe que vai implementar todos os metodos que definirmos no SacolaService
* do mesmo pacote e por isso precisamos implementar os metódos
* Esses metodos são obrigados a serem implementados, pois esta obtendo um contrato com a SacolaService
* que é uma interface.
*Como essa classe é uma classe de serviço precisamos adicionar a dependência @Service
*
*
* */

@Service
@RequiredArgsConstructor
public class SacolaServiceImplementa implements SacolaService{

    private final SacolaRepository sacolaRepository;


    //Metodo contém a lógica que inluiem Item na Sacola de acordo com a classe ItemDTO e seus dados
    @Override
    public Item incluirItemNaSacaola(ItemDto itemDto) {
        return null;
    }

    //Metodo contém a lógica para buscar verSacola através do parametro ID
    //Necessário orElseThrow fazer Make Option para tratar: Option é uma classe do Java que ajuda no tratamente, caso não exista o ID por exemplo
    @Override
    public Sacola verSacola(Long id) {
        return sacolaRepository.findById(id).orElseThrow(
                () ->{
                    throw new RuntimeException("Essa sacola não existe.");
                }
        );
    }

    //Metodo que contém a lógica que fechará a sacola de acordo com seus parametros
    //Se sacola for vazia exibe a mensagem que precisamos add itens
    //Se não for, cairemos na lógica da escolha da forma de pagamento
    @Override
    public Sacola fecharSacola(Long id, int numeroformaPagamento) {
        Sacola sacola = verSacola(id);
        if(sacola.getItensSacola().isEmpty()){
          throw new RuntimeException("Inclua itens na sacola! Para poder fechar.");
        }

        //Instanciando e add dentro da nossa variavel local
        FormaPagamento formaPagamento = numeroformaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;
        sacola.setFormaPagamento(formaPagamento);
        sacola.setFechada(true);
        return sacolaRepository.save(sacola); //retorna e Salva sacola no banco de dados;
    }
}
