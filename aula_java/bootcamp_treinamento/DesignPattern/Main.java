public class Main{

    public static void main(String[] args) {
        /**
         * Também posso sobreescrever o metodo getInstance com um ENUM... que ai nao preciso ficar passando strings... ou por constantes
         */
        Pessoa aluno = Factory.getInstance("aluno", "Pablo");
        Pessoa professor = Factory.getInstance("professor", "Kenyo");


        System.out.println(aluno.getNome());
        System.out.println(professor.getNome());
    }
}