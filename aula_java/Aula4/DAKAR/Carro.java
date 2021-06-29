/**
 * Carro
 */
public class Carro extends Veiculo{

    private int rodas = 4;
    private double peso = 1000.00; // KG
 
    public Carro(double velocidade, double aceleracao, double anguloDeGiro, String placa){
        super(4, 1000.00, velocidade, aceleracao, anguloDeGiro, placa);
    }
}