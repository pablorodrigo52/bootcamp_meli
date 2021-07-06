package br.com.mercadolivre.linktracer.repositories;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mercadolivre.linktracer.entities.Link;

@Repository
public class LinkRepository {

    @Autowired
    private ObjectMapper mapper;

    private static File FILE = new File("links.json");

    public boolean add(Link link){
        List<Link> links = getLinksFromFile();
        if (links != null){
            links.add(link);
            return putLinksToFile(links);
        }
        return false;
    }

    public boolean save(Link link){
        List<Link> links = getLinksFromFile();
        if (links!=null){
            Link actual = links.stream().filter(l -> l.getId().equals(link.getId())).findFirst().orElse(null);
            if (actual!=null){
                links.set(links.indexOf(actual), link);
                return putLinksToFile(links);
            }
        }
        return false;
    }

    public List<Link> getLinksFromFile(){
        List<Link> links = new ArrayList<>();

        try{
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Link>> typeReference = new TypeReference<List<Link>>() {};
            links = mapper.readValue(is, typeReference);
            is.close();
            return links;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    private boolean putLinksToFile (List<Link> links){
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, links);
            out.close();
            return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
    }
}
