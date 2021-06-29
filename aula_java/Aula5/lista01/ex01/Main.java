import java.util.Arrays;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        Pessoa p1 = new Pessoa("Pablo", "2");
        Pessoa p2 = new Pessoa("Hugo", "1");
        Pessoa p3 = new Pessoa("Wincenty", "5");
        Pessoa p4 = new Pessoa("Mateus", "3");
        Pessoa p5 = new Pessoa("Lucas", "4");
        Pessoa p6= new Pessoa("Random", "0");


        Pessoa[] list = {p1, p2, p3, p4, p5, p6};
        System.out.println("Antes de ordenar: ");
        System.out.println(Arrays.asList(list));
        SortUtil.sort(list);
        System.out.println("DEpois de ordenar: ");
        System.out.println(Arrays.asList(list));


        Celular[] celulares = {
            new Celular("999999999", "Pablo"),
            new Celular("999999991", "Random")
        };

        SortUtil.sort(celulares);
        System.out.println(Arrays.asList(celulares));
    }
}