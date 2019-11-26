import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		insertSort();
	}
	
	public static void insertSort() {
		Scanner sc = new Scanner(System.in);
		int[] array = {5, 4, 2, 3, 1};
		
		for (int i = 1; i < array.length; i++) 
		{
			int aux = array[i];
			int j = i - 1;
			while (j >= 0 && aux < array[j]) 
			{
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = aux;
		}
		
		// Mostrar a ordenação
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
