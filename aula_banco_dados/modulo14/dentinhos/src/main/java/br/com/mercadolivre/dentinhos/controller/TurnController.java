package br.com.mercadolivre.dentinhos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Sort.Direction;
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

    @GetMapping("")
    public List<Turn> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "99") int quantity){
        Pageable pagination = PageRequest.of(page, quantity, Direction.ASC, "indexPagination");
        Page<Turn> listTurn = service.getAll(pagination);
        return listTurn
            .stream()
            .map(turn -> new Turn(turn.getId(), turn.getPatient(), turn.getDoctor(), turn.getDate(), turn.getStatus())).collect(Collectors.toList());
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
