import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class GuardaRoupa{

    private int counter = 0;
    private Map<Integer, List<Vestuario>> mapping = new HashMap<Integer, List<Vestuario>>();

    private void increment(){
        this.counter++;
    }

    public int guardarVestuario(List<Vestuario> listaDeVestuario){
        int identificador = this.counter;

        this.mapping.put(identificador, listaDeVestuario);
        increment();
        return identificador;
    }

    public void mostrarVestuarios(){
        this.mapping.entrySet().forEach(entry -> {
            int identificador = entry.getKey(); 
            List<Vestuario> vestuario = entry.getValue();

            System.out.println(identificador + ":");
            for(Vestuario item:vestuario)
            {
                System.out.println("\t"+item);
            }
            System.out.println("-----------------------------------------------------------------");
        });
    }

    public List<Vestuario> devolverVestuario(int identificador){
        return this.mapping.get(identificador);
    }



}