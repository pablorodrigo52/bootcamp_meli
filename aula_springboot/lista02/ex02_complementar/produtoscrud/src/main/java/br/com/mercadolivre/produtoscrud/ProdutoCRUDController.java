package br.com.mercadolivre.produtoscrud;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.produtoscrud.model.Produto;
import br.com.mercadolivre.produtoscrud.service.ProdutoService;

/**
 * ProdutoCRUDController
 */
@RestController
@RequestMapping(value="/crud", produces="application/json")
public class ProdutoCRUDController {

    private ProdutoService service = new ProdutoService();

    @PostMapping("/create")
    public String create(@RequestBody Produto product){
        if (service.addToProductList(product)){
            return product.toString();
        } else {
            return "ERROR on CREATE";
        }
    }

    @GetMapping("/index")
    public String index(){
        int counter = 0;
        StringBuilder index = new StringBuilder("[");
        for(Map.Entry<Integer, Produto> entry:service.getProductList().entrySet()){
            if (counter > 0){
                index.append(",");
            }
            index.append(entry.getValue());
            counter++;
        }
        index.append("]");
        return index.toString();
    }

    @GetMapping("/index/{id}")
    public String index(@PathVariable int id){
        return service.getProductList().get(id).toString();
    }

    @PostMapping("/update/{id}")
    public String update(@RequestBody Produto product, @PathVariable int id){
        if (service.isValidProduct(product)){
            Produto productAux = service.getProductList().get(id);
            if (productAux != null)
            {
                service.getProductList().remove(id);
                service.addToProductList(product, id);
                return product.toString();
            } else {
                return "ID does not exist";
            }
        }else{
            return "Product attributes is not valid";
        }
    }

    @DeleteMapping("delete/{id}")
    public String delete (@PathVariable int id){
        Produto productAux = service.getProductList().get(id);
        if (productAux != null)
        {
            service.getProductList().remove(id);
            return productAux.toString();
        } else {
            return "ID does not exist";
        }
    }

}