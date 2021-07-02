package br.com.mercadolivre.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.starwars.dto.CharacterDTO;
import br.com.mercadolivre.starwars.service.SearchService;

@RestController
@RequestMapping("/search")
public class SearchCharacterController {

    @Autowired
    SearchService searchService;

    @GetMapping
    public List<CharacterDTO> search (@RequestParam String query){
        return searchService.search(query);
    }
    
}
