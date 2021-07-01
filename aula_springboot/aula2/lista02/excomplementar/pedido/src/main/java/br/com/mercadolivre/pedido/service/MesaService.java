package br.com.mercadolivre.pedido.service;

import java.util.UUID;

import br.com.mercadolivre.pedido.dto.MesaDTO;
import br.com.mercadolivre.pedido.entities.Caixa;
import br.com.mercadolivre.pedido.entities.Mesa;
import br.com.mercadolivre.pedido.entities.Pedido;

/**
 * MesaService
 */
public class MesaService {

    private MesaService() {}

    public static void addPedidoMesa(Pedido pedido, Mesa mesa){
        if (pedido!=null){
            UUID uuid = UUID.randomUUID();
            pedido.setId(uuid.toString());
            mesa.getPedidos().add(pedido);
        }
    }

    public static MesaDTO fechaMesa(Mesa mesa, Caixa caixa){
        if (mesa!=null){
            MesaDTO mesaDTO = new MesaDTO(mesa);
            caixa.setTotal(caixa.getTotal() + mesaDTO.getTotalConsumido());
            return new MesaDTO(mesa);
        } else {
            return new MesaDTO();
        }
    }

}