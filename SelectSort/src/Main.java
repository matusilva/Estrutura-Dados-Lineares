import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		selectSort();
	}
	
	public static void selectSort() {
		Scanner sc = new Scanner(System.in);
		int[] array = {5, 4, 2, 3, 1};
		
		for (int i = 0; i < array.length; i++) 
		{
			for (int j = i + 1; j < array.length; j++) 
			{
				if (array[j] < array[i]) 
				{
					int aux = array[j];
					array[j] = array[i];
					array[i] = aux;
				}
			}
		}
		
		// Mostrando a ordenação
		for (int i = 0; i < array.length; i++) 
		{
			System.out.println(array[i]);
		}
	}

}
