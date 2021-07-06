package br.com.mercadolivre.linktracer.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.mercadolivre.linktracer.dtos.LinkDTO;
import br.com.mercadolivre.linktracer.entities.Link;
import br.com.mercadolivre.linktracer.exceptions.CannotRedirectException;
import br.com.mercadolivre.linktracer.exceptions.URLIndisponivelException;
import br.com.mercadolivre.linktracer.services.LinkService;

@RestController
@RequestMapping(value="/link", produces = "application/json")
public class LinkController {
    
    private LinkService service;

    @Autowired
    public LinkController(LinkService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LinkDTO>> index(){
        return new ResponseEntity<>(LinkDTO.convert(service.index()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody LinkDTO linkDto){
        Link link = LinkDTO.convert(linkDto);
        if (service.create(link)){
            return new ResponseEntity<>(LinkDTO.convert(link).toString(), HttpStatus.OK);
        }
        return new ResponseEntity<>("CANNOT CREATE THIS LINK", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{linkId}")
    public void redirect (@PathVariable String linkId, HttpServletResponse response){
        LinkDTO linkDTO = service.redirect(linkId);
        if(linkDTO!=null){
            try {
                response.sendRedirect(linkDTO.getUrl());
            } catch (IOException e) {
                throw new CannotRedirectException("Cannot redirect to [" +linkDTO.getUrl()+"]");
            }
        }
        throw new URLIndisponivelException("LINK ID: ["+linkId+"] not recognized.");
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<String> metrics (@PathVariable String linkId){
        LinkDTO linkDTO = service.metrics(linkId);
        if (linkDTO!=null){
            return new ResponseEntity<>(linkDTO.toString(), HttpStatus.OK);
        }
        throw new URLIndisponivelException("URL not found.");
    }

    @PostMapping("/invalidate/{linkId}")
    public void invalidate(@PathVariable String linkId) {
        //TODO: process POST request
        service.invalidate(linkId);
    }
    
}
