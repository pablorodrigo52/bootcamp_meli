package br.com.mercadolivre.diploma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.mercadolivre.diploma.dto.SimpleSubjectDTO;
import br.com.mercadolivre.diploma.dto.StudentDTO;
import br.com.mercadolivre.diploma.dto.SubjectDTO;
import br.com.mercadolivre.diploma.entities.Subject;
import br.com.mercadolivre.diploma.service.DiplomaService;

@SpringBootTest
class CertificateServiceImplTest {

	@Test
	public void shouldBeAnalyzeNotes() {
		StudentDTO studentDTO = createStudentDTO();
		SubjectDTO subjectDto = DiplomaService.generateDiploma(studentDTO);

		assertNotNull(studentDTO);
		assertTrue(subjectDto.getAverage() >= 0);
		assertTrue(subjectDto.getMessage().indexOf("NaN") == -1);
		assertNotEquals(0, subjectDto.getStudent().get(0).getSubjects().size());		
	}

	@Test
	public void shouldBeCalculateAverage() {
		StudentDTO studentDTO = createStudentDTO();
		
		double average = DiplomaService.getMedia(StudentDTO.convert(studentDTO));		
		double expected = 10.0;
		assertEquals(expected, average);
	}

	@Test
	public void shouldBeWriteDiploma(){
		StudentDTO studentDTO = createMiddleStudentDTO();

		SimpleSubjectDTO simpleSubjectDTO = DiplomaService.generateDiploma(StudentDTO.convert(studentDTO));
		String expected = "Pablo Rodrigo você foi aprovado com média 7.5.";

		assertEquals(expected, simpleSubjectDTO.getMessage());
	}

	@Test
	public void shouldBeWriteDiplomaWithHonors(){
		StudentDTO studentDTO = createStudentDTO();

		SimpleSubjectDTO simpleSubjectDTO = DiplomaService.generateDiploma(StudentDTO.convert(studentDTO));
		String expected = "Pablo Rodrigo você foi aprovado com média 10.0. PARABÉNS!!!";

		assertEquals(expected, simpleSubjectDTO.getMessage());
	}


	private StudentDTO createStudentDTO(){
		List<Subject> subjects = new ArrayList<>();		
		subjects.add(new Subject("Disciplina 1", 10));
		subjects.add(new Subject("Disciplina 2", 10));
		
		return new StudentDTO("Pablo Rodrigo", subjects);
	}

	private StudentDTO createMiddleStudentDTO(){
		List<Subject> subjects = new ArrayList<>();		
		subjects.add(new Subject("Disciplina 1", 10));
		subjects.add(new Subject("Disciplina 2", 5));
		
		return new StudentDTO("Pablo Rodrigo", subjects);
	}
}
