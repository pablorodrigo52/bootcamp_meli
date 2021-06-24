import java.util.Scanner;

public class VerificaPrimo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Informe o número N: ");
        int n = scan.nextInt();

        System.out.println(primo(n));
    }  

    public static boolean primo(int n){
        for (int i=2; i < n-1; i++){
            if (n%i == 0) 
                return false; 
        } 
        return true;
    }
}
