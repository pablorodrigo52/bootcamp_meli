public class OrdenacaoVetor{


    /**
     * Exercício 1: Dado um vetor de 10 posições, sendo respectivamente ocupado pelos valores 52, 10, 85, 1324, 01, 13, 62, 30, 12 e 127.
     * @param args
     * 
     * O exercicio será resolvido com um bubblesort FINS DIDÁTICOS. O ideal seria resolver esse exercicio ou utilizando um algoritmo melhor para tempo de processamento
     * quicksort, mergesort, etc.. ou usando as proprias collections do java.
    */
    public static void main (String [] args){
        Integer [] numeros = {52,10,85,1324,1,13,62,30,12,127};

        bubbleSort(numeros, 'A');
        System.out.println("Crescente: ");
        for (int i=0; i < numeros.length; i++){
            if (i > 0) System.out.print(",");
            System.out.print(numeros[i]);
        }

        System.out.println("\nDecrescente: ");
        bubbleSort(numeros, 'D');
        for (int i=0; i < numeros.length; i++){
            if (i > 0) System.out.print(",");
            System.out.print(numeros[i]);
        }
    }

    public static void bubbleSort(Integer[] vector, char type){
        int sizeNumbers = vector.length;

        for(int i=sizeNumbers-1; i >= 0; i--){
            for (int j=0; j < i; j++) {
                if (type == 'A') {
                    if (vector[j+1] < vector[j]){
                        int temp = vector[j];
                        vector[j] = vector[j+1];
                        vector[j+1] = temp;
                    }
                } else if (type == 'D') {
                    if (vector[j+1] > vector[j]){
                        int temp = vector[j];
                        vector[j] = vector[j+1];
                        vector[j+1] = temp;
                    }
                } else {
                    System.out.println("You must select A - Ascendant or  D - Descendant");
                }
            }            
        }        
    }
}