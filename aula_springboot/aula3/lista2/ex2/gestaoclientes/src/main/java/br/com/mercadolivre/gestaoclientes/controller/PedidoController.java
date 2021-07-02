package br.com.mercadolivre.gestaoclientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.gestaoclientes.dtos.PedidoDTO;
import br.com.mercadolivre.gestaoclientes.entities.Produto;
import br.com.mercadolivre.gestaoclientes.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;
    
    @PostMapping("/create")
    public PedidoDTO postPedido(@RequestParam String idcliente, @RequestBody List<Produto> produtos){
        return pedidoService.add(idcliente, produtos);
    }


    @GetMapping("/{idcliente}")
    public List<PedidoDTO> getPedidosCliente(@PathVariable String idcliente){
        return pedidoService.getPedidosList(idcliente);
    }


}
