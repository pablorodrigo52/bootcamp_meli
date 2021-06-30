package br.com.mercadolivre.codigomorse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {
    

    @RequestMapping("/morse/{input}")
    @ResponseBody
    public String morse(@PathVariable String input){
        return CodigoMorse.toMorse(input);
    }

    
}
