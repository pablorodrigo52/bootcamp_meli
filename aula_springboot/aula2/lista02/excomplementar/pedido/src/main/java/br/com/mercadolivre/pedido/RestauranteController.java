package br.com.mercadolivre.pedido;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.pedido.dto.MesaDTO;
import br.com.mercadolivre.pedido.entities.Caixa;
import br.com.mercadolivre.pedido.entities.Mesa;
import br.com.mercadolivre.pedido.entities.Pedido;
import br.com.mercadolivre.pedido.service.MesaService;

@RestController
@RequestMapping(value="/", produces="application/json")
public class RestauranteController {
    
    Caixa caixa = new Caixa();
    UUID uuid = UUID.randomUUID();


    @GetMapping("/index")
    public String getMesas (){
        StringBuilder mesas = new StringBuilder("[");
        int aux = 0;
        for (Mesa mesa:caixa.getMesas()){
            if (aux > 0) mesas.append(",");
            mesas.append("{\"id\":\"");
            mesas.append(mesa.getId());
            mesas.append("\"}");
            aux++;
        }
        mesas.append("]");
        return mesas.toString();
    }

    @GetMapping("/mesa")
    public ResponseEntity<String> getMesa(@RequestParam String id){

        for(Mesa mesa:caixa.getMesas()){
            if (mesa.getId().equals(id)){
                return new ResponseEntity<>(mesa.toString(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Mesa [" + id + "] does not exists.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/mesa")
    public MesaDTO criarMesa(@RequestBody Mesa mesa){

        uuid = UUID.randomUUID();
        mesa.setId(uuid.toString());
        caixa.getMesas().add(mesa);
        System.out.println(mesa.getPedidos());

        return new MesaDTO(mesa);
    }


    @PostMapping("/mesa/pedido")
    public ResponseEntity<String> addPedido(@RequestBody Pedido pedido, @RequestParam String id){
        uuid = UUID.randomUUID();
        pedido.setId(uuid.toString());
        
        Optional<Mesa> mesa = caixa.getMesas().stream()
            .filter(m -> m.getId().equals(id))
            .reduce( (a, b) -> {
                throw new IllegalStateException("Multiple elements: " + a + ", " + b);
            });
        if (mesa.isPresent()){
            uuid = UUID.randomUUID();
            pedido.setId(uuid.toString());
            mesa.get().getPedidos().add(pedido);
            
            return new ResponseEntity<>(pedido.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Mesa [" + id + "] does not exists.", HttpStatus.BAD_REQUEST);
        }
    }

}
