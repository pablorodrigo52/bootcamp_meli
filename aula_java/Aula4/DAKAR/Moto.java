/*
 * Moto
 */
public class Moto extends Veiculo{

    private static final int RODAS = 2;
    private static final double PESO = 300.00; // KG
    
    public Moto(double velocidade, double aceleracao, double anguloDeGiro, String placa){
        super(2, 300.00, velocidade, aceleracao, anguloDeGiro, placa);
    }
}