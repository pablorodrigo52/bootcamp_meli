import java.util.List;
import java.util.ArrayList;

public class Corrida{

    private double distancia;
    private double premioEmDolares;
    private String nome;
    private int quantidadeVeiculosPermitidos;
    private List<Veiculo> listaVeiculos = new ArrayList<>();

    private Socorrista socorristaCarro = new SocorristaCarro();
    private Socorrista socorristaMoto = new SocorristaMoto();

    public Corrida (String nome, double premioEmDolares, double distancia, int quantidadeVeiculosPermitidos){
        this.nome = nome;
        this.premioEmDolares = premioEmDolares;
        this.distancia = distancia;
        this.quantidadeVeiculosPermitidos = quantidadeVeiculosPermitidos;
    }

    public void registrarCarro(Veiculo carro){
        if (listaVeiculos.size() < quantidadeVeiculosPermitidos){
            listaVeiculos.add(carro);
            System.out.println("Carro adicionado a corrida com sucesso.");
        } else {
            System.err.println("Quantidade máxima de veiculos atingida para essa corrida.");
        }
    }

    public void registrarMoto(Veiculo moto){
        if (listaVeiculos.size() < quantidadeVeiculosPermitidos){
            listaVeiculos.add(moto);
            System.out.println("Moto adicionada a corrida com sucesso.");
        } else {
            System.err.println("Quantidade máxima de veiculos atingida para essa corrida.");
        }
    }

    public void removerVeiculo(Veiculo veiculo){
        int index = listaVeiculos.indexOf(veiculo);
        if (index > -1){
            listaVeiculos.remove(index);
            System.out.println("Veículo removido da corrida com sucesso.");
        } else {
            System.err.println("Veículo não existe nessa corrida.");
        }
    }

    public void removerVeiculoPorPlaca(String placa){
        if (placa!=null && !placa.trim().equals("")){
            for(Veiculo veiculo:listaVeiculos){
                if (veiculo.getPlaca().equals(placa)){
                    listaVeiculos.remove(veiculo);
                    break;
                }
            }
        }
    }

    public void terminarCorrida()
    {
        Veiculo vencedor = null;
        double resultadoFinal = 0.0;
        System.out.println(" ------------------------------------------------------- ");
        System.out.println("Pontuacao: ");
        for (Veiculo veiculo:listaVeiculos)
        {
            try
            {
                socorristaCarro.socorrer(veiculo);
            }
            catch(ClassCastException exception)
            {
                // System.out.println("\tNão pode socorrer um carro com moto :D ");
            }

            try
            {
                socorristaMoto.socorrer(veiculo);
            }
            catch(ClassCastException exception)
            {
                // System.out.println("\tNão pode socorrer um carro com moto :D ");
            }
            double resultadoParcial = (veiculo.getVelocidade() * veiculo.getAceleracao()) / (veiculo.getAnguloDeGiro() * (veiculo.getPeso() - veiculo.getRodas() * 100));
            if (resultadoParcial > resultadoFinal){
                resultadoFinal = resultadoParcial;
                vencedor = veiculo;
            }
            System.out.println("\t"+veiculo + " [" + resultadoParcial + "]");
        }
        System.out.println(" ------------------------------------------------------- ");
        System.out.println("O vencedor da corrida foi: " + vencedor);
    }



    public double getDistancia() {
        return this.distancia;
    }

    protected void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEmDolares() {
        return this.premioEmDolares;
    }

    protected void setPremioEmDolares(double premioEmDolares) {
        this.premioEmDolares = premioEmDolares;
    }

    public String getNome() {
        return this.nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeVeiculosPermitidos() {
        return this.quantidadeVeiculosPermitidos;
    }

    protected void setQuantidadeVeiculosPermitidos(int quantidadeVeiculosPermitidos) {
        this.quantidadeVeiculosPermitidos = quantidadeVeiculosPermitidos;
    }

    public List<Veiculo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    protected void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

}