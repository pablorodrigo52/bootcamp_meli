import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        //criando vestuario...
        Vestuario roupa1 = new Vestuario("POLO", "Camisa Polo Rosa M");
        Vestuario roupa2 = new Vestuario("APPLE", "Bermuda APPLE Cinza Magnata");
        Vestuario roupa3 = new Vestuario("OAKLEY", "Boné Oakley Mandraka 07/2021");

        List<Vestuario> vest1 = new ArrayList<>();
        vest1.add(roupa1);
        vest1.add(roupa2);
        vest1.add(roupa3);


        Vestuario roupa4 = new Vestuario("DELUC", "Lingerie PRETA Body - M");
        Vestuario roupa5 = new Vestuario("PLAYBOY", "Lingerie ROSA Body - M");

        List<Vestuario> vest2 = new ArrayList<>();
        vest2.add(roupa4);
        vest2.add(roupa5);

        // ADICIONANDO AO GUARDA ROUPA

        GuardaRoupa saveTheRopa = new GuardaRoupa();

        int idvest1 = saveTheRopa.guardarVestuario(vest1);
        int idvest2 = saveTheRopa.guardarVestuario(vest2);

        System.out.println(idvest1);
        System.out.println(idvest2);

        System.out.println("Recuperando vestuario ["+idvest1+"]...");
        List<Vestuario> recovered = saveTheRopa.devolverVestuario(idvest1);
        System.out.println(Arrays.asList(recovered));

        System.out.println("\n\nMostrando vestuario completo: ");
        saveTheRopa.mostrarVestuarios();

    }
}