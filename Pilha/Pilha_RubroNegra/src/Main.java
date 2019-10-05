
public class Main {

	public static void main(String[] args) throws EPilhaVazia {
		// TODO Auto-generated method stub
		Pilha_RubroNegra p = new Pilha_RubroNegra();
		p.pushp("preto");
		p.pushv("vermelho");
		p.pushv("vermelho");
		p.pushv("vermelho");
		p.pushp("preto");
		System.out.println(p.ToString());
	}
}
