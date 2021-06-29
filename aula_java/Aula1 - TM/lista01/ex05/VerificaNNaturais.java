import java.util.Scanner;

public class VerificaNNaturais {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Informe N: ");
        int n = in.nextInt();

        System.out.print("Informe M: ");
        int m = in.nextInt();

        System.out.print("Informe D: ");
        int d = in.nextInt();

        boolean flagNaturalDigit = true;
        int counter = 0;

        String aaa = "333";
        System.out.println(aaa);
        System.out.println(aaa.indexOf("3"));

        while (n!=0){
            int indexOf = String.valueOf(counter).indexOf(String.valueOf(d));

            if (indexOf != -1){
                String substring = String.valueOf(counter).substring(indexOf);

            }
        }


        // while (n!=0){
        //     if (String.valueOf(counter).split(String.valueOf(d)).length >= (m+1))
        //     {
        //         System.out.println(String.valueOf(counter).split(String.valueOf(d)).length);
        //         System.out.println(counter);
        //         n--;
        //     }
        //     counter++;
        // }
    }
}
