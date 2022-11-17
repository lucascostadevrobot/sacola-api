package me.dio.ifood.sacola.service.implementa;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.sacola.domain.Item;
import me.dio.ifood.sacola.domain.Restaurante;
import me.dio.ifood.sacola.domain.Sacola;
import me.dio.ifood.sacola.enumeracao.FormaPagamento;
import me.dio.ifood.sacola.repository.ItemRepository;
import me.dio.ifood.sacola.repository.ProdutoRepository;
import me.dio.ifood.sacola.repository.SacolaRepository;
import me.dio.ifood.sacola.resource.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private final SacolaRepository sacolaRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemRepository itemRepository;

    /*
    * incluirItemNaSacola: Metodo que contém a lógica que incluiem Item na Sacola de acordo com a classe ItemDTO e seu dados
    * 49º.produto(produtoRepository: Vai no Banco de Dados e buscar por ID o produto da nossa classe ItemDTO
    * 51ºE realizamos o tratamento orElseThrow se existe no BD ou não
    * Se o produto existir ele vai colocar dentro da Sacola e incluir
    * */
    @Override
    public Item incluirItemNaSacaola(ItemDto itemDto) {
        Sacola sacola = verSacola(itemDto.getSacolaId());
        if (sacola.isFechada()){
            throw new RuntimeException("Esta sacola está fechado.");
        }else {
             Item itemParaSerInserido = Item.builder()
                    .quantidade(itemDto.getQuantidade())
                    .sacola(sacola)
                    .produto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow(
                            () -> {
                                throw new RuntimeException("Esse produto não existe");
                            }
                    ))
                    .build();

            /*
             ---Regra de Negócio: Os items que serão adicionados precisam ser do mesmo Restaurante--
            *If:
            *1ºVerifica se existem item na sacola ou não
            *2º Se existem não existem adicionamos o um novo itemParaSerInserido
            *
            * Else:
            * 1º Ao adicionarmos outro item precisamos verificar identificar de qual restaurante é o produto
            * 2º Precisamos verificar se o produto no qual iremos adicionar novamente é do mesmo resutaurante do produto que já existe na sacola
            * 70º a partir da linha 70º  fazemos a lógica que verifica se o Restaurante Atual que tem os items
                  É o mesmo restaurante que possue o item da sacola
                  Uma vez que os tems precisam ser do mesmo restaurante
            * */
            List<Item> itemsDaSacola = sacola.getItensSacola();
            if (itemsDaSacola.isEmpty()){
                itemsDaSacola.add(itemParaSerInserido);
            }else {
               Restaurante restauranteAtual =  itemsDaSacola.get(0).getProduto().getRestaurante(); //Verificamos se o primeiro item da sacola existe e se é do mesmo restaurante
               Restaurante restauranteDoItemParaAdicionar =  itemParaSerInserido.getProduto().getRestaurante();
               if (restauranteAtual.equals(restauranteDoItemParaAdicionar)){
                   itemsDaSacola.add(itemParaSerInserido); //Adicionamos o itemParaSerInserido como item da sacola do Restaurante
               }else {
                   throw new RuntimeException("Não é possível adicionar produtos de restaurantes diferentes.Feche a sacola ou esvazie");
               }
            }
            List<Double> valorDosItens = new ArrayList<>();
            for (Item itemDaSacola: itemsDaSacola) {
                double valorTotalItem =
                        itemDaSacola.getProduto().getValorUnitario() * itemDaSacola.getQuantidade();
                valorDosItens.add(valorTotalItem);
            }

            double valorTotalSacola = valorDosItens.stream()
                    .mapToDouble(valorTotalDeCadaItem -> valorTotalDeCadaItem)
                    .sum();
            sacolaRepository.save(sacola);
            return itemRepository.save(itemParaSerInserido);
        }
    }

    /*
    * verSacola: Metodo que contém a lógica para buscar a sacola através do parametro ID
    *Necessário orElseThrow fazer Make Option para tratar: Option é uma classe do Java que ajuda no tratamente, caso não exista o ID por exemplo
    *
    **/
    @Override
    public Sacola verSacola(Long id) {
        return sacolaRepository.findById(id).orElseThrow(
                () ->{
                    throw new RuntimeException("Essa sacola não existe.");
                }
        );
    }

    /*
    * fecharSacola: Metodo que contém a lógica que fechará a sacola de acordo com seus parametros
    *
    * Variavel local sacola:
    * 102º Pegamos a sacola através do verSacola(id) pelo id.
    * 103º Verificamos se existem itens na sacola, pois só fecha se tiver items
    * 104º Fazemos o tratamento de excessão
    * if: 103º pegamos a sacola pegamos o ItemsSacola e verificamos se é vazio
    *
    * 108º Criamos uma variavel local e utilizamos if ternário para identificar qual forma de pagamento
    * 109º pegamos a sacola e setamos uma forma de pagamento
    * Por ultimo utilizamos sacolaRepository e salvamos a sacola no BD
    * */
    @Override
    public Sacola fecharSacola(Long id, int numeroformaPagamento) throws RuntimeException {
        Sacola sacola = verSacola(id);
        if(sacola.getItensSacola().isEmpty()){
          throw new RuntimeException("Inclua itens na sacola! Para poder fechar.");
        }

        //Instanciando e add dentro da nossa variavel local
        FormaPagamento formaPagamento = numeroformaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;
        sacola.setFormaPagamento(formaPagamento);
        sacola.setFechada(true);
        return sacolaRepository.save(sacola); //retorna e Salva sacola no banco de dados
    }


}
