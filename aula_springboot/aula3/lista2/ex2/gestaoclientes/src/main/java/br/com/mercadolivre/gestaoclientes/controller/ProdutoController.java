package br.com.mercadolivre.gestaoclientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.gestaoclientes.dtos.ProdutoDTO;
import br.com.mercadolivre.gestaoclientes.entities.Produto;
import br.com.mercadolivre.gestaoclientes.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    ProdutoService produtoService;

    @GetMapping("/")
    public List<ProdutoDTO> getProdutos(){
        return produtoService.getProductList();
    }

    @PostMapping("/create")
    public ProdutoDTO postProduto(@RequestBody Produto produto){        
        return produtoService.add(produto);
    }

}
