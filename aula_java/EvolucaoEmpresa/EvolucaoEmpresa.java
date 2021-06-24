public class EvolucaoEmpresa{


    /**
     * Exercício 2:  Em 2021 uma startup de tecnologia, denominada de “Empresa X” é avaliada em 1,13 milhão e possui uma média de crescimento anual de 148%, uma concorrente do ramo, “Empresa Y”, é avaliada em 18,4 milhões e com sua média de crescimento anual em 32%.
     * @param args
     * 
     * A data não esta sendo incrementada.. 
     */
    public static void main (String[] args){

        Empresa empresaX = new Empresa ("Empresa X", 1.13, 148);
        Empresa empresaY = new Empresa ("Empresa Y", 18.4, 32);

        boolean stopLoop = false;
        while(!stopLoop){
            empresaX.setValue(
                empresaX.getValue() + 
                (empresaX.getValue() * empresaX.getTax())
            );
            
            empresaY.setValue(
                empresaY.getValue() + 
                (empresaY.getValue() * empresaY.getTax())
            );

            if (empresaX.getValue() > empresaY.getValue()){
                stopLoop = true;
            }
            System.out.println(empresaX);
            System.out.println(empresaY);
            System.out.println("------------------------------");
        }
    }
}