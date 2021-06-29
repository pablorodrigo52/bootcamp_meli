public abstract class Funcionario{

    protected String nome;
    protected double salarioBase;
    protected double jornadaTrabalho; // em Horas
    protected double descansoTrabalho; // em Horas

    public Funcionario (String nome)
    {
        setNome(nome);
        // setSalarioBase(salarioBase);
        // setJornadaTrabalho(jornadaTrabalho);
        // setDescansoTrabalho(descansoTrabalho);
    }

    public abstract String pagarSalario();

    public String getNome(){
        return this.nome;
    }

    protected void setNome(String n){
        this.nome = n;
    }

    public double getSalarioBase(){
        return this.salarioBase;
    }

    protected void setSalarioBase(double s){
        this.salarioBase = s;
    }

    public double getJornadaTrabalho(){
        return this.jornadaTrabalho;
    }

    protected void setJornadaTrabalho(double j){
        this.jornadaTrabalho = j;
    }

    public double getDescansoTrabalho(){
        return this.jornadaTrabalho;
    }

    protected void setDescansoTrabalho(double d){
        this.jornadaTrabalho = d;
    }
}