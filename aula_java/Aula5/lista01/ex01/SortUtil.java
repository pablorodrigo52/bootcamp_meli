/**
 * SortUtil
 */
public class SortUtil {

    public static <T> void sort (Precedente <T> arr[]){
        int tamanho = arr.length;
        for(int i = 0; i<(tamanho-1); i++){
			for(int j = 0; j<=(tamanho-2); j++){
				if(arr[j].precedeA((T)arr[j + 1]) > 0){
					Precedente<T> aux = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = aux;
				}
			}
		}
    }
}