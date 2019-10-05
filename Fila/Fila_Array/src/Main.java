
public class Main {

	public static void main(String[] args) throws EFilaVazia {
		// TODO Auto-generated method stub
		
		FilaArray f = new FilaArray();
		f.inserir("a");
		System.out.println(f.tamanho());
		f.inserir("b");
		System.out.println(f.tamanho());
		f.inserir("c");
		System.out.println(f.tamanho());
		f.inserir("d");
		System.out.println(f.tamanho());
		f.toString();
		System.out.println("\n");
		f.retirar();
		f.retirar();
		f.retirar();
		f.retirar();
		f.toString();
		System.out.println("\n");
		System.out.println(f.tamanho());
	}

}
