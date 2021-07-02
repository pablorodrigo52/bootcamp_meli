package br.com.mercadolivre.starwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.starwars.repository.SearchRepository;
import br.com.mercadolivre.starwars.dto.CharacterDTO;

@Service
public class SearchService {

    SearchRepository repository;

    @Autowired
    public SearchService (SearchRepository repository){
        this.repository = repository;
    }

    public CharacterDTO search(String query){
        if (query!=null && !query.equals("")){
            return CharacterDTO.convert(this.repository.search(query));
        } else {
            return new CharacterDTO();
        }
    }
}
