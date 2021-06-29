import java.text.NumberFormat;

public class Tecnico extends CLT {

    private final double BONUS = 0.05;
    private final double salarioBase = 3200.00;
    private final double jornadaTrabalho = 40.0; // em Horas
    private final double descansoTrabalho = 0.0; // em Horas

    public Tecnico (String nome)
    {
        super(nome);
        setSalarioBase(salarioBase);
        setJornadaTrabalho(jornadaTrabalho);
        setDescansoTrabalho(descansoTrabalho);
    }

    @Override
    public String pagarSalario(){
        double salario = this.salarioBase + (this.salarioBase * BONUS);
        return NumberFormat.getCurrencyInstance().format(salario);
    }
}