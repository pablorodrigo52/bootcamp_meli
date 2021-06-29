
/**
 * Veiculo
 */
public class Veiculo {

    private double velocidade;
    private double aceleracao;
    private double anguloDeGiro;
    private double peso;
    private String placa;
    private int rodas;

    public Veiculo (int rodas, double peso, double velocidade, double aceleracao, double anguloDeGiro, String placa)
    {
        this.rodas = rodas;
        this.peso = peso;
        this.velocidade = velocidade;
        this.aceleracao = aceleracao;
        this.anguloDeGiro = anguloDeGiro;
        this.placa = placa;
    }


    @Override
    public String toString(){
        return this.placa.toUpperCase() + " - " + this.rodas + " rodas - Vel. Máx: " + this.velocidade  ;
    }

    public double getVelocidade() {
        return this.velocidade;
    }

    protected void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getAceleracao() {
        return this.aceleracao;
    }

    protected void setAceleracao(double aceleracao) {
        this.aceleracao = aceleracao;
    }

    public double getAnguloDeGiro() {
        return this.anguloDeGiro;
    }

    protected void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public double getPeso() {
        return this.peso;
    }

    protected void setPeso(double peso) {
        this.peso = peso;
    }

    public String getPlaca() {
        return this.placa;
    }

    protected void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getRodas() {
        return this.rodas;
    }

    protected void setRodas(int rodas) {
        this.rodas = rodas;
    }
    

}