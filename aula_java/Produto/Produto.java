public class Produto{

    private int id;
    private String productName;
    private double cost;
    private int ammount;

    public Produto (int id, String productName, double cost, int ammount){
        this.id = id;
        this.productName = productName;
        this.cost = cost;
        this.ammount = ammount;
    }


    @Override
    public String toString(){
        return "Produto " + id + "\n" + productName + "\nR$ " + cost + "\nQuantidade: " + ammount; 
    }
}