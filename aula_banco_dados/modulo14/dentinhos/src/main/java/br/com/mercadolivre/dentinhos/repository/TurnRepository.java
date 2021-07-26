package br.com.mercadolivre.dentinhos.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.mercadolivre.dentinhos.entities.Turn;

@Repository
public interface TurnRepository extends MongoRepository<Turn, String>{
    public List<Turn> findByDoctorFirstNameOrDoctorLastName(String firstName, String lastName);
    public List<Turn> findByStatus(String status);
}
