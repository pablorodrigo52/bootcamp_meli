import java.util.Scanner;

public class NMultiplosM{
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Informe o número N: ");
        int n = scan.nextInt();
        System.out.print("Informe o número M: ");
        int m = scan.nextInt();

        int counterFlagMultiple = 0;
        System.out.print("Os N primeiros multiplos de M sao: [");
        while(n>0)
        {
            if (counterFlagMultiple%m==0){
                if (counterFlagMultiple > 0) System.out.print(",");
                System.out.print(counterFlagMultiple);
                n--;
            }
            counterFlagMultiple++;
        }        
        System.out.print("]");
    }
}