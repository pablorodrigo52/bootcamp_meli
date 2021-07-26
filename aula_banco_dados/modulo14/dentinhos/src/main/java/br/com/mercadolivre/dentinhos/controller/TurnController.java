package br.com.mercadolivre.dentinhos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.dentinhos.entities.Turn;
import br.com.mercadolivre.dentinhos.service.TurnService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/turn")
public class TurnController {
    
    private final TurnService service;

    @Autowired
    public TurnController(TurnService service) {
        this.service = service;
    }


    @PostMapping("/")
    public Turn save(@RequestBody Turn turn) {
        return service.save(turn);
    }

    @GetMapping("/")
    public List<Turn> getAll(){
        return service.getAll();
    }

    @GetMapping("/doctor/{name}")
    public List<Turn> getAllByDoctorName(@PathVariable String name){
        return service.getAllByDoctorName(name);
    }

    @GetMapping("/status/{status}")
    public List<Turn> getAllByStatus(@PathVariable String status){
        return service.getAllByStatus(status);
    }

}
