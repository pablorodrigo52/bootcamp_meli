package br.com.mercadolivre.diploma.service;

import br.com.mercadolivre.diploma.entities.Aluno;

public class DiplomaService {
    
    protected static final String CONSTANT_NAME = "$NAME";
    protected static final String CONSTANT_MEDIA = "$MEDIA";

    protected static final String MSG_APROVADO = "$NAME você foi aprovado com média $MEDIA.";
    protected static final String MSG_APROVADO_PLUS = "$NAME você foi aprovado com média $MEDIA. PARABÉNS!!!";
    protected static final String MSG_REPROVADO = "$NAME você foi reprovado com média $MEDIA.";

    protected DiplomaService(){}

    protected static double getMedia(Aluno student){
        double sum = student.getCourse().stream().mapToDouble(d -> d.getGrade()).sum();        
        return sum / student.getCourse().size();
    }

    public static String generateDiploma(Aluno student){
        double media = DiplomaService.getMedia(student);

        if (media >= 9){
            return DiplomaService.MSG_APROVADO_PLUS.replace(DiplomaService.CONSTANT_NAME, student.getName()).replace(DiplomaService.CONSTANT_MEDIA, String.valueOf(media));
        } else if (media >= 6 && media < 9){
            return DiplomaService.MSG_APROVADO.replace(DiplomaService.CONSTANT_NAME, student.getName()).replace(DiplomaService.CONSTANT_MEDIA, String.valueOf(media));
        } else {
            return DiplomaService.MSG_REPROVADO.replace(DiplomaService.CONSTANT_NAME, student.getName()).replace(DiplomaService.CONSTANT_MEDIA, String.valueOf(media));
        }
    }
}
