public class Main{
    public static void main(String[] args) {
        
        Funcionario f1 = new Tecnico("Felipe Araujo Silva");
        Funcionario f2 = new Analista("Pablo Rodrigo Lima dos Santos");
        Funcionario f3 = new Gerente("Hugo Rodrigo Lemos");
        Funcionario f4 = new Diretor("Yuri Nunes de Oliveira");




        System.out.println(f1 + " : " + f1.pagarSalario());
        System.out.println(f2 + " : " + f2.pagarSalario());
        System.out.println(f3 + " : " + f3.pagarSalario());
        System.out.println(f4 + " : " + f4.pagarSalario());

    }
}