/**
 * Pessoa
 */
public class Pessoa implements Precedente<Pessoa>{

    private String nome, cpf;

    public Pessoa() throws Exception{
        throw new Exception("Cannot instanciate a void person.");
    }

    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public int precedeA(Pessoa p){
        return this.cpf.compareToIgnoreCase(p.getCpf());
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", cpf='" + getCpf() + "'" +
            "}";
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}