import java.util.Scanner;

public class Main {

	public static void menu() 
	{
		System.out.println("Digite o comando que você deseja fazer na Pilha");
		System.out.println("- push\n- pop\n- top\n- size\n- sair");
		System.out.print("Comando: ");
	}
	
	public static void main(String[] args) throws EPilhaVazia {
		// TODO Auto-generated method stub
		Pilha p = new Pilha();
		String opcao;
		
		do {
			menu();
			Scanner sc = new Scanner(System.in);
			opcao = sc.next().toUpperCase().toLowerCase();
			
			if (opcao.equals("push")) 
			{
				System.out.println("O que você deseja empilhar?");
				p.push(sc.next());
			}
			
			if (opcao.equals("pop")) 
			{
				try {
					p.pop();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}
			
			if (opcao.equals("top")) 
			{
				try {
					System.out.println(p.top());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}
			
			if (opcao.equals("size")) 
			{
				System.out.println(p.size());
			}
			
		} while (!opcao.equals("sair"));
		
	}
}
