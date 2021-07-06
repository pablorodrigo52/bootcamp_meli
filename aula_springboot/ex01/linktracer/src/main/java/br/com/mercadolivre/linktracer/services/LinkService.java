package br.com.mercadolivre.linktracer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.linktracer.dtos.LinkDTO;
import br.com.mercadolivre.linktracer.entities.Link;
import br.com.mercadolivre.linktracer.repositories.LinkRepository;

@Service
public class LinkService {
    
    private LinkRepository repository;

    @Autowired
    public LinkService (LinkRepository repository){
        this.repository = repository;
    }
    
    public List<Link> index (){
        return repository.getLinksFromFile();
    }

    public boolean create (Link link){
        return repository.add(link);
    }

    public LinkDTO redirect (String linkId){
        Link link = repository.getLinksFromFile().stream().filter(l -> l.getId().equals(linkId)).findFirst().orElse(null);
        if (link!=null){
            incrementAccess(link);
            if (repository.save(link)){
                return LinkDTO.convert(link);
            }
        }
        return null;
    }

    public LinkDTO metrics (String linkId){
        Link link = repository.getLinksFromFile().stream().filter(l -> l.getId().equals(linkId)).findFirst().orElse(null);
        if (link!=null){
            return LinkDTO.convert(link);
        }
        return null;
    }


    public void invalidate (String linkId){
        // TODO
    }

    private void incrementAccess(Link link){
        link.setAccess(link.getAccess()+1);
    }
}
