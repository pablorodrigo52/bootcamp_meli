package br.com.mercadolivre.produtoscrud;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.produtoscrud.model.Produto;
import br.com.mercadolivre.produtoscrud.service.ProdutoCRUDControllerException;
import br.com.mercadolivre.produtoscrud.service.ProdutoService;

/**
 * ProdutoCRUDController
 */
@RestController
@RequestMapping(value="/crud", produces="application/json")
public class ProdutoCRUDController {

    private ProdutoService service = new ProdutoService();

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Produto product){
        if (service.addToProductList(product)){
            return new ResponseEntity<String>(product.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(ProdutoCRUDControllerException.errorProduct("product not OK"), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value="/index", produces="application/json")
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
    public ResponseEntity<String> index(@PathVariable int id){
        Produto productAux = service.getProductList().get(id);
        if (productAux != null){
            return new ResponseEntity<String>(productAux.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(ProdutoCRUDControllerException.errorProductNotExists("product not EXISTS"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Produto product, @PathVariable int id){
        if (service.isValidProduct(product)){
            Produto productAux = service.getProductList().get(id);
            if (productAux != null)
            {
                service.getProductList().remove(id);
                service.addToProductList(product, id);
                return new ResponseEntity<String>(product.toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<String>(ProdutoCRUDControllerException.errorProductNotExists("product not EXISTS"), HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<String>(ProdutoCRUDControllerException.errorProduct("product not OK"), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete (@PathVariable int id){
        Produto productAux = service.getProductList().get(id);
        if (productAux != null)
        {
            service.getProductList().remove(id);
            return new ResponseEntity<String>(productAux.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(ProdutoCRUDControllerException.errorProductNotExists("product not EXISTS"), HttpStatus.NOT_FOUND);
        }
    }

}