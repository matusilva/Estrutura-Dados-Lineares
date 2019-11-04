import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Heap heap = new Heap();
	
		int opcao;
		
		do {
			menu();
			Scanner sc = new Scanner(System.in);
			opcao = sc.nextInt();
			
			if (opcao == 1) {
				System.out.println("digite o numero que deseja inserir");
				Integer num = sc.nextInt();
				heap.insert(num);
			}
			
			if (opcao == 2) {
				heap.removeMin();
			}
			
			if (opcao == 3) {
				System.out.println(heap.min());
			}
			
			if (opcao == 4) {
				System.out.println(heap.size());
			}
			
			if (opcao == 5) {
				heap.print();
			}
			
		} while (opcao != 6);
	}
	
	public static void menu() {
		System.out.println("-- HEAP --");
		System.out.println("1 - insert");
		System.out.println("2 - removeMin");
		System.out.println("3 - min");
		System.out.println("4 - size");
		System.out.println("5 - print");
		System.out.println("6 - sair");
	}

}
