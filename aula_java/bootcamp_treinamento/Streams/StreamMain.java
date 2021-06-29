import java.util.List;
import java.util.ArrayList;

public class StreamMain{

    public static void main(String[] args) {
        
        List<String> strings = new ArrayList<String>();

        strings.add("Pablo");
        strings.add("Rodrigo");
        strings.add("Lima");
        strings.add("Santos");

        strings.stream()
            .filter(el -> el.indexOf("a") > 0)
            .forEach(System.out::println); // lambda function como a anterior


        strings.parallelStream() // a VM vai utilizar automaticamente as threads para performar em collections muito grandes..
            .filter(el -> el.indexOf("a") > 0)
            .forEach(System.out::println); // lambda function como a anterior


    }
}