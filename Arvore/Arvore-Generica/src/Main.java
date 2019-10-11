import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		ArvoreSimples arvore = new ArvoreSimples("Raiz");
		
		arvore.addChildren(arvore.root(), "1");
		arvore.addChildren(arvore.root(), "2");
		Iterator it = arvore.children(arvore.root());
		System.out.println(arvore);
	}

}
