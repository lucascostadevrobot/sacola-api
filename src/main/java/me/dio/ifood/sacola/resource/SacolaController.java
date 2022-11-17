package me.dio.ifood.sacola.resource;

import lombok.Data;
import me.dio.ifood.sacola.domain.Item;
import me.dio.ifood.sacola.domain.Sacola;
import me.dio.ifood.sacola.resource.dto.ItemDto;
import me.dio.ifood.sacola.service.implementa.SacolaService;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/ifood/sacolas")
@Data
public class SacolaController {

    private final SacolaService sacolaService;

    //Metodo para incluir item na sacola  e expõe rota controller
    @PostMapping
    public Item  incluirItemNaSacola(@RequestBody ItemDto itemDto){
        return sacolaService.incluirItemNaSacaola(itemDto);
    }

    //Metodo para visualizar através do id a sacola e expoe rota controller
    @GetMapping("/{id}")
    public Sacola verSacola(@PathVariable("id") Long id){
        return sacolaService.verSacola(id);
    }

    //Metodo para fechar sacola e expoe rota controller
    @PatchMapping("/fecharSacola/{sacolaId}")
    public Sacola fecharSacola(@PathVariable("sacolaId")Long sacolaId,
                               @RequestParam("formaPagamento") int formaPagamento){
        return sacolaService.fecharSacola(sacolaId, formaPagamento);
    }

}
