import java.text.NumberFormat;

public class Analista extends CLT {

    private final double BONUS = 0.08;
    private final double salarioBase = 4000.00;
    private final double jornadaTrabalho = 40.0; // em Horas
    private final double descansoTrabalho = 4.0; // em Horas

    public Analista (String nome)
    {
        super(nome);
        setSalarioBase(salarioBase);
        setJornadaTrabalho(jornadaTrabalho);
        setDescansoTrabalho(descansoTrabalho);
    }

    @Override
    public String pagarSalario(){
        double descansoRemunerado = (this.salarioBase / this.jornadaTrabalho) * this.descansoTrabalho;
        double salario = this.salarioBase + (this.salarioBase * BONUS) + descansoRemunerado;
        return NumberFormat.getCurrencyInstance().format(salario);
    }
}