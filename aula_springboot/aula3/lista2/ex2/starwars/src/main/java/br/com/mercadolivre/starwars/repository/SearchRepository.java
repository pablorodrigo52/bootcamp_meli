package br.com.mercadolivre.starwars.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mercadolivre.starwars.entities.Character;

@Repository
public class SearchRepository {
    private static final File FILE = new File("starwars.json");

    @Autowired
	private ObjectMapper mapper;

	public List<Character> search(String query){
        List<Character> characters = new ArrayList<>();
		try {
			FileInputStream is = new FileInputStream(FILE);
			TypeReference<List<Character>> typeReference = new TypeReference<List<Character>>() {};
			characters = mapper.readValue(is, typeReference);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Character> persons = new ArrayList<>();
		for(Character person:characters){
			if (person.getName().contains(query)){
				persons.add(person);
			}
		}
        return persons;
	}
}
