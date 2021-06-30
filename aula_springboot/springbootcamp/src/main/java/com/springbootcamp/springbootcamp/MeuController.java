package com.springbootcamp.springbootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// @RestController /* this controller all responses is @ResponseBody */
// @RequestMapping("/controller") // route default for all endpoints in this controller
public class MeuController {

    @RequestMapping("/helloworld/{name}")
    @ResponseBody
    public String helloWorldString(@PathVariable String name){ // @RequesBody String paramBody to get body parameter
        return "Nosso primeiro endpoint. Bem vindo, " + name ;
    }


    @RequestMapping("/helloworld")
    @ResponseBody
    public String helloWorldString(){
        return "Nosso primeiro endpoint.";
    }

}
