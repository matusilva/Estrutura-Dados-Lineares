import java.util.Scanner;

public class Main {

	public static void menu() {
		System.out.println("==== MENU ====");
		System.out.println("| 1 | - Inserir\n| 2 | - Remover\n| 3 | - Buscar\n| 4 | - Size\n| 5 | - Sair");
	}
	public static void main(String[] args) {
		Dicionario hash = new Dicionario();
		int opcao;
		do {
			menu();
			Scanner sc = new Scanner(System.in);
			opcao = sc.nextInt();
			
			if (opcao == 1) {
				System.out.println("Digite a Chave que deseja inserir");
				int k = sc.nextInt();
				System.out.println("Digite o Elemento que deseja inserir");
				Object o = sc.next();
				hash.insertItem(k, o);
			}
			
			if (opcao == 2) {
				System.out.println("Digite a Chave que deseja remover");
				int k = sc.nextInt();
				hash.removeElement(k);
			}
			
			if (opcao == 3) {
				System.out.println("Digite a Chave que deseja buscar");
				int k = sc.nextInt();
				System.out.println(hash.findElement(k));
			}
			
			if (opcao == 4) {
				System.out.println(hash.size());
			}
			
		} while (opcao != 5);
	}

}
