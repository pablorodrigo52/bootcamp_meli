import java.util.Scanner;

public class ProdutoMain {
    

    /**
     * Exercício 3:  Para um protótipo de supermercado, crie um programa que leia 3 produtos e imprima no console: nome, preço, quantidade e o valor total da compra.
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Produto [] produtos = new Produto[3];
        double total = 0;

        for (int i=0; i < 3; i++)
        {
            System.out.print("Informe o nome: ");
            String productName = in.next();
            
            System.out.print("Informe o preço: ");
            double cost = in.nextDouble();
            
            System.out.print("Informe a quantidade: ");
            int ammount = in.nextInt();

            produtos[i] = new Produto(i, productName, cost, ammount);

            total += cost*ammount; 
        }
        
        for (int i=0; i < produtos.length; i++){
            System.out.println(produtos[i] + "\n");
        }

        System.out.println("Valor total: R$" + Double.valueOf(total));
    }
}
