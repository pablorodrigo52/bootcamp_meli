import java.text.NumberFormat;

public class Diretor extends CLT {

    private final double BONUS = 0.0;
    private final double PARTICIPACAO_LUCRO = 0.03;
    private final double salarioBase = 15000.00;
    private final double jornadaTrabalho = 0.0; // em Horas
    private final double descansoTrabalho = 0.0; // em Horas

    public Diretor (String nome)
    {
        super(nome);
        setSalarioBase(salarioBase);
        setJornadaTrabalho(jornadaTrabalho);
        setDescansoTrabalho(descansoTrabalho);
    }

    @Override
    public String pagarSalario(){
        double salario = this.salarioBase + (this.salarioBase * this.PARTICIPACAO_LUCRO);
        return NumberFormat.getCurrencyInstance().format(salario);
    }
}