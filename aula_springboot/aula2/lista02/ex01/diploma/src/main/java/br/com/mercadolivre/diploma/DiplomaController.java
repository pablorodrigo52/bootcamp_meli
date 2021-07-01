package br.com.mercadolivre.diploma;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.diploma.dto.DiplomaDTO;
import br.com.mercadolivre.diploma.entities.Aluno;
import br.com.mercadolivre.diploma.service.DiplomaService;

@RestController
@RequestMapping(value="/diploma", produces="application/json")
public class DiplomaController {

    @PostMapping("/")
    public ResponseEntity<DiplomaDTO> postDiplomaAluno(@RequestBody Aluno student){
        return new ResponseEntity<>(new DiplomaDTO(DiplomaService.generateDiploma(student), "####"), HttpStatus.OK);
    }
}
