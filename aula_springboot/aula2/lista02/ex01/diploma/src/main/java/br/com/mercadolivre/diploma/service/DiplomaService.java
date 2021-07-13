package br.com.mercadolivre.diploma.service;

import java.util.ArrayList;
import java.util.List;

import br.com.mercadolivre.diploma.dto.StudentDTO;
import br.com.mercadolivre.diploma.dto.SubjectDTO;
import br.com.mercadolivre.diploma.entities.Student;

public class DiplomaService {
    
    protected static final String CONSTANT_NAME = "$NAME";
    protected static final String CONSTANT_MEDIA = "$MEDIA";

    protected static final String MSG_APROVADO = "$NAME você foi aprovado com média $MEDIA.";
    protected static final String MSG_APROVADO_PLUS = "$NAME você foi aprovado com média $MEDIA. PARABÉNS!!!";
    protected static final String MSG_REPROVADO = "$NAME você foi reprovado com média $MEDIA.";

    protected DiplomaService(){}

    protected static double getMedia(Student student){
        double sum = student.getCourse().stream().mapToDouble(d -> d.getNote()).sum();        
        return sum / student.getCourse().size();
    }

    public static String generateDiploma(Student student){
        double average = DiplomaService.getMedia(student);
        return createMessage(average, student.getName());
    }

    public static SubjectDTO generateDiploma(StudentDTO dto){
        double average = DiplomaService.getMedia(StudentDTO.convert(dto));
        String message = createMessage(average, dto.getName());
        List<StudentDTO> studentList = new ArrayList<>();
        studentList.add(dto);

        return new SubjectDTO(average, message, studentList);
    }


    private static String createMessage(double average, String studentName){
        if (average >= 9){
            return DiplomaService.MSG_APROVADO_PLUS
                .replace(DiplomaService.CONSTANT_NAME, studentName)
                .replace(DiplomaService.CONSTANT_MEDIA, String.valueOf(average));
        } else if (average >= 6 && average < 9){
            return DiplomaService.MSG_APROVADO
                .replace(DiplomaService.CONSTANT_NAME, studentName)
                .replace(DiplomaService.CONSTANT_MEDIA, String.valueOf(average));
        } else {
            return DiplomaService.MSG_REPROVADO
                .replace(DiplomaService.CONSTANT_NAME, studentName)
                .replace(DiplomaService.CONSTANT_MEDIA, String.valueOf(average));
        }
    }
}
