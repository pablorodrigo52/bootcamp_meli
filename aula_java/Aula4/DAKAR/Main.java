
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Corrida marioCup = new Corrida("Mario Kart CUP", 1000.99, 7000, 3);

        Veiculo mario = new Carro(101.56, 0.05, 3.7, "mario kart");
        Veiculo luigi = new Moto(125.00, 0.02, 5.5, "luigi moto");
        Veiculo bowser = new Moto(97.00, 0.08, 2.15, "bowser moto");
        Veiculo peach = new Carro(115.53, 0.04, 4.1, "peach carro");


        marioCup.registrarCarro(mario);
        marioCup.registrarCarro(peach);

        marioCup.registrarMoto(bowser);
        marioCup.registrarMoto(luigi);

        marioCup.removerVeiculo(bowser);
        marioCup.registrarMoto(luigi);


        marioCup.terminarCorrida();
     }
}