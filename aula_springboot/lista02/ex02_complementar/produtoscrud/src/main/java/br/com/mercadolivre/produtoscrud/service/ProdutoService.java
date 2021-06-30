package br.com.mercadolivre.produtoscrud.service;

import java.util.HashMap;
import java.util.Map;

import br.com.mercadolivre.produtoscrud.model.Produto;


public class ProdutoService extends Produto{

    private Map<Integer, Produto> productList = new HashMap<Integer, Produto>();
    

    public Map<Integer, Produto> getProductList(){
        return this.productList;
    }

    protected void setProductList(Map<Integer, Produto> p){
        this.productList = p; 
    }

    public boolean addToProductList(Produto product){
        if (isValidProduct(product)){
            int generated_id = this.productList.size()+1;
            product.setId(generated_id);
            this.productList.put(generated_id, product);
            return true;
        }else{
            return false;
        }
    }

    public boolean addToProductList(Produto product, int id){
        if (isValidProduct(product)){
            int generated_id = id;
            product.setId(generated_id);
            this.productList.put(generated_id, product);
            return true;
        }else{
            return false;
        }
    }

    public boolean isValidProduct(Produto product){
        if (
            (product!=null)&&
            (!product.getName().equals(""))&&
            (product.getValue()!=0)
            )
        {
            return true;
        } else {
            return false;
        }
    }

}
