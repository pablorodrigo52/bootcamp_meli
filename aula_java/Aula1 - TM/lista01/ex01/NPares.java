import java.util.Scanner;

public class NPares{
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Informe o número N: ");
        int n = scan.nextInt();

        System.out.print("Os primeiros N pares sao: [");
        for (int i = 0; i <= n; i++){
            if (i%2 == 0){
                if (i>0){
                    System.out.print(",");                
                }
                System.out.print(i);
            }
        }
        System.out.print("]");
    }
}