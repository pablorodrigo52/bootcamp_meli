import java.util.Scanner;

public class NPrimeirosPrimos {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Informe o número N: ");
        int n = scan.nextInt();

        System.out.print("[");
        for(int i = 2; i < n+2; i++)
        {
            if (primo(i)){
                if (i > 2)
                    System.out.print(",");
                System.out.print(i);
            }
        }
        System.out.print("]");
    }  

    public static boolean primo(int n){
        for (int i=2; i < (n-1)/2; i++){
            if (n%i == 0) 
                return false;
        } 
        return true;
    }
}
