public class Factory{

    public static Pessoa getInstance(String itemClass, String nome){
        if(itemClass.toLowerCase().equals("aluno")){
            return new Aluno(nome);
        }

        if(itemClass.toLowerCase().equals("professor")){
            return new Professor(nome);
        }

        return null;
        // throw new RuntineException("Especifique o tipo de instancia.");
    }
}