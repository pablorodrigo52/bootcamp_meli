import java.text.NumberFormat;

public class Gerente extends CLT {

    private final double BONUS = 0.125;
    private final double salarioBase = 6000.00;
    private final double jornadaTrabalho = 36.0; // em Horas
    private final double descansoTrabalho = 4.0; // em Horas

    public Gerente (String nome)
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