package br.com.mercadolivre.dentinhos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.dentinhos.entities.Turn;
import br.com.mercadolivre.dentinhos.repository.TurnRepository;

@Service
public class TurnService {
        
    private final TurnRepository repository;

    @Autowired
    public TurnService(TurnRepository repository) {
        this.repository = repository;
    }

    public Turn save(Turn turn){
        return repository.save(turn);
    }

    public List<Turn> getAll() {
        return repository.findAll();
    }

    public Page<Turn> getAll(Pageable pagination){
        return repository.findAll(pagination);
    }

    public List<Turn> getAllByDoctorName(String name) {
        return repository.findByDoctorFirstNameOrDoctorLastName(name, name);
    }

    public List<Turn> getAllByStatus(String status){
        return repository.findByStatus(status);
    }
}
