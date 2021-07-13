package br.com.mercadolivre.diploma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.mercadolivre.diploma.dto.StudentDTO;
import br.com.mercadolivre.diploma.dto.SubjectDTO;
import br.com.mercadolivre.diploma.entities.Subject;
import br.com.mercadolivre.diploma.service.DiplomaService;

@SpringBootTest
class CertificateServiceImplTest {

	@Test
	void shouldBeAnalyzeNotes() {
		List<Subject> subjects = new ArrayList<>();		
		subjects.add(new Subject("Disciplina 1", 10));
		subjects.add(new Subject("Disciplina 2", 5));
		subjects.add(new Subject("Disciplina 3", 8));
		subjects.add(new Subject("Disciplina 4", 9));

		StudentDTO studentDTO = new StudentDTO("Pablo Rodrigo", subjects);
		SubjectDTO subjectDto = DiplomaService.generateDiploma(studentDTO);

		assertNotNull(studentDTO);
		assertTrue(subjectDto.getAverage() >= 0);
		assertTrue(subjectDto.getMessage().indexOf("NaN") == -1);
		assertNotEquals(0, subjectDto.getStudent().get(0).getSubjects().size());		
	}

	@Test
	void shouldBeCalculateAverage() {
		List<Subject> subjects = new ArrayList<>();		
		subjects.add(new Subject("Disciplina 1", 10));
		subjects.add(new Subject("Disciplina 2", 5));
		
		StudentDTO studentDTO = new StudentDTO("Pablo Rodrigo", subjects);
		
		double average = DiplomaService.getMedia(StudentDTO.convert(studentDTO));		
		double expected = 7.5;
		assertEquals(expected, average);
	}

	@Test
	void shouldBeWriteDiploma(){
		List<Subject> subjects = new ArrayList<>();		
		subjects.add(new Subject("Disciplina 1", 10));
		subjects.add(new Subject("Disciplina 2", 5));
		
		StudentDTO studentDTO = new StudentDTO("Pablo Rodrigo", subjects);

		String diplomaString = DiplomaService.generateDiploma(StudentDTO.convert(studentDTO));
		String expected = "Pablo Rodrigo você foi aprovado com média 7.5.";

		assertEquals(expected, diplomaString);
	}


	@Test
	void shouldBeWriteDiplomaWithHonors(){
		List<Subject> subjects = new ArrayList<>();		
		subjects.add(new Subject("Disciplina 1", 10));
		subjects.add(new Subject("Disciplina 2", 10));
		
		StudentDTO studentDTO = new StudentDTO("Pablo Rodrigo", subjects);

		String diplomaString = DiplomaService.generateDiploma(StudentDTO.convert(studentDTO));
		String expected = "Pablo Rodrigo você foi aprovado com média 10.0. PARABÉNS!!!";

		assertEquals(expected, diplomaString);
	}
}
