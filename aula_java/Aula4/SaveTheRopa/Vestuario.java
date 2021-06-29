public class Vestuario{
    
    private String marca;
    private String modelo;

    public Vestuario() throws Exception{
        throw new Exception("É necessario marca e modelo.");
    }

    public Vestuario(String marca, String modelo){
        setMarca(marca);
        setModelo(modelo);
    }

    public String getMarca(){
        return this.marca;
    }
    public String getModelo(){
        return this.modelo;
    }

    public void setMarca(String m){
        this.marca = m;
    }
    public void setModelo(String m){
        this.modelo = m;
    }

    @Override
    public String toString(){
        return "(" + this.marca + " - " + this.modelo + ")"; 
    }
}