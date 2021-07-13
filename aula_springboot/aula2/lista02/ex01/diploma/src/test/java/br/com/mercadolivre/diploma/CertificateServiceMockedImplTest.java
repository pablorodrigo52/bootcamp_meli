package br.com.mercadolivre.diploma;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.mercadolivre.diploma.dto.StudentDTO;
import br.com.mercadolivre.diploma.dto.SubjectDTO;
import br.com.mercadolivre.diploma.entities.Subject;
import br.com.mercadolivre.diploma.service.DiplomaService;

@SpringBootTest
public class CertificateServiceMockedImplTest {

    @Mock
    private static DiplomaService service = new DiplomaService();

    @Test
	void shouldBeAnalyzeNotes() {
		List<Subject> subjects = new ArrayList<>();		
		subjects.add(new Subject("Disciplina 1", 10));
		subjects.add(new Subject("Disciplina 2", 5));
		subjects.add(new Subject("Disciplina 3", 8));
		subjects.add(new Subject("Disciplina 4", 9));
		StudentDTO studentDTO = new StudentDTO("Pablo Rodrigo", subjects);
		SubjectDTO subjectDto = DiplomaService.generateDiploma(studentDTO);

        when(DiplomaService.generateDiploma(studentDTO)).thenReturn(subjectDto);

		assertNotNull(studentDTO);
		assertTrue(subjectDto.getAverage() >= 0);
		assertTrue(subjectDto.getMessage().indexOf("NaN") == -1);
		assertNotEquals(0, subjectDto.getStudent().get(0).getSubjects().size());		
	}
    
}
