package br.com.mercadolivre.diploma;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.diploma.dto.StudentDTO;
import br.com.mercadolivre.diploma.dto.SubjectDTO;
import br.com.mercadolivre.diploma.entities.Student;
import br.com.mercadolivre.diploma.service.DiplomaService;

@RestController
@RequestMapping(produces="application/json")
public class DiplomaController {

    @PostMapping("/diploma")
    public ResponseEntity<String> postDiplomaAluno(@RequestBody Student student){
        return new ResponseEntity<>(new SubjectDTO(DiplomaService.generateDiploma(student)).toString(), HttpStatus.OK);
    }

    @PostMapping("/analyzeNotes")
    public ResponseEntity<?> analyzeNotes(@Valid @RequestBody StudentDTO studentDTO){
        SubjectDTO subjectDTO = DiplomaService.generateDiploma(studentDTO);
        return new ResponseEntity<>(subjectDTO, HttpStatus.CREATED);
    }
}
