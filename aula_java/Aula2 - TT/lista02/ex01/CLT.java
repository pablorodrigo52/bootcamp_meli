import java.text.NumberFormat;

public class CLT extends Funcionario{

    public CLT (String nome)
    {
        super(nome);
    }

    public String pagarSalario(){
        return NumberFormat.getCurrencyInstance().format(this.salarioBase);
    }


    @Override
    public String toString(){
        return this.getNome();
    }

}