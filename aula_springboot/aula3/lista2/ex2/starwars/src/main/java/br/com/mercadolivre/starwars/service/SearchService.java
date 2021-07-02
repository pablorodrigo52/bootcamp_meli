package br.com.mercadolivre.starwars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.starwars.repository.SearchRepository;
import br.com.mercadolivre.starwars.dto.CharacterDTO;
import br.com.mercadolivre.starwars.entities.Character;

@Service
public class SearchService {

    SearchRepository repository;

    @Autowired
    public SearchService (SearchRepository repository){
        this.repository = repository;
    }

    public List<CharacterDTO> search(String query){
        List<CharacterDTO> personsDTO = new ArrayList<>();            
        if (query!=null && !query.equals("")){
            List<Character> persons = this.repository.search(query);
            for(Character person:persons){
                personsDTO.add(CharacterDTO.convert(person));
            }
        }
        return personsDTO;
    }
}
