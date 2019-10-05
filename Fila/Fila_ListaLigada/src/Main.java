import java.util.Scanner;

public class Main {
	
	public static void menu() 
	{
		System.out.println("Digite oq deseja fazer na pilha");
		System.out.println("| 1 | - enfileirar\n| 2 | - desinfileirar\n| 3 | - size\n| 4 | - sair");
	}

	public static void main(String[] args) throws EFilaVazia {
		// TODO Auto-generated method stub
		Fila f = new Fila();
		
		Scanner sc = new Scanner(System.in);
		
		int opcao;
		
		do {
			menu();
			opcao = sc.nextInt();
			
			if (opcao == 1) 
			{
				System.out.println("Digite oq deseja enfileirar:");
				f.enfileirar(sc.next());
			}
			if (opcao == 2) 
			{
				try {
					f.desenfileirar();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}
			if (opcao == 3) 
			{
				System.out.println(f.size());
			}
			
		} while (opcao != 4);
		
		}
	}

