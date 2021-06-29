public class Empresa {


    private String name;
    private final String date = "01/01/2021";
    private double value;
    private double taxHigh;

    public Empresa (String name, double value, double taxHigh){
        setName(name);
        setValue(value);
        setTax(taxHigh);
    }
    
    public String getName(){
        return this.name;
    }

    public String getDate(){
        return this.date;
    }

    public double getValue(){
        return this.value;
    }

    public double getTax(){
        return this.taxHigh;
    }

    public void setName(String n){
        name = n;
    }

    // public void setDate(String d){
    //     date = d;
    // }

    public void setValue(double v){
        value = v;
    }

    public void setTax(double t){
        taxHigh = t/100;
    }


    @Override
    public String toString(){
        return name + " - " + date + " - Valor da empresa: " + Double.valueOf(value);
    }
}
