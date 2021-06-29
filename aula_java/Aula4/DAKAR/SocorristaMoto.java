/**
 * SocorristaMoto
 */
public class SocorristaMoto extends Socorrista<Moto>{

    @Override
    public void socorrer(Moto moto){
        System.out.println("Socorrendo moto ["+moto.getPlaca()+"]");
    }
}