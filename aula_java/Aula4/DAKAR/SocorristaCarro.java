
/**
 * SocorristaCarro
 */
public class SocorristaCarro extends Socorrista<Carro>{

    @Override
    public void socorrer(Carro carro){
        System.out.println("Socorrendo carro ["+carro.getPlaca()+"]");
    }
}