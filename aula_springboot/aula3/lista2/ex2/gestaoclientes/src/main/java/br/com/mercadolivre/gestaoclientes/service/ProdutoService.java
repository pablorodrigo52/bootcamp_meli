package br.com.mercadolivre.gestaoclientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.gestaoclientes.dtos.ProdutoDTO;
import br.com.mercadolivre.gestaoclientes.entities.Produto;
import br.com.mercadolivre.gestaoclientes.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository){
        this.repository = produtoRepository;
    }

    public List<ProdutoDTO> getProductList(){
        List<ProdutoDTO> productDTOList = new ArrayList<>();
        ProdutoDTO aux = new ProdutoDTO();

        for (Produto prod : repository.getList()) {
            productDTOList.add(aux.converte(prod));            
        }
        return productDTOList;
    }

    public ProdutoDTO add (Produto produto){
        ProdutoDTO aux = new ProdutoDTO();
        produto.setId(UUID.randomUUID().toString());
        repository.add(produto);
        return aux.converte(produto);
    }

}
