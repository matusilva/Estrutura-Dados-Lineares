import java.util.Iterator;
import java.util.Vector;

public class ArvoreSimples implements ArvoreGenerica {
	// Atributos da arvore
	No raiz;
	int tamanho;
	
	// Construtor
	public ArvoreSimples(Object o) {
		raiz = new No(null, o);
		tamanho = 1;
	}

	// Retorna numero de nos na arvore
	@Override
	public int size() {
		return this.tamanho;
	}

	// Retorna se a arvore esta vazia, false pois sempre terá a raiz
	@Override
	public boolean isEmpty() {
		return false;
	}
	
	// Retorna a profundidade de um No
	@Override
	public int depth(No v) {
		int profundidade = profundidade(v);
		return profundidade;
	}

	private int profundidade(No v) {
		if (v == raiz) {
			return 0;
		}
		else {
			return 1 + profundidade(v.parent());
		}
	}
	
	// Retorna a altura da arvore
	@Override
	public int height() {
		int altura = altura(this.raiz);
		return altura;
	}
	
	private int altura(No v) {
		if (isExternal(v)) {
			return 0;
		}
		else {
			int h = 0;
			Iterator<No> it = v.children();
			while (it.hasNext()) {
				No no = (No) it.next();
				h = Math.max(h, altura(v));
				
			}
			return 1 + h;
		}
	}

	// Retorna um iterator com os elementos na arvore
	@Override
	public Iterator elements() {
		return null;
	}

	// Retorna um iterator com as posições nos na arvore
	@Override
	public Iterator nos() {
		return null;
	}

	// Retorna a raiz da arvore
	@Override
	public No root() {
		return raiz;
	}

	//Retorna o Pai de um No
	@Override
	public No parent(No v) {
		return (v.parent());
	}

	//Retorna os Filhos de um No Pai
	@Override
	public Iterator children(No v) {
		return (v.children());
	}

	// No interno = no com filhos
	@Override
	public boolean isInternal(No v) {
		return (v.childrenNumber() > 0);
	}

	// No externo = no sem filhos
	@Override
	public boolean isExternal(No v) {
		return (v.childrenNumber() == 0);
	}

	// No raiz
	@Override
	public boolean isRoot(No v) {
		return v == raiz;
	}

	@Override
	public Object replace(No v, Object o) {
		No no;
		Object ob;
		
		no = v;
		ob = no.element();
		no.setElement(o);
		return ob;
	}

	// Adicionar um filho a um No
	@Override
	public void addChildren(No v, Object o) {
		No novo = new No(v, o);
		v.addChild(novo);
		tamanho++;
	}
	
	// Remover No, somente os externos e que tenham pai
	@Override
	public Object remove(No v) throws InvalidNoException {
		No pai = v.parent();
		if (pai != null || isExternal(v)) {
			pai.removeChild(v);
		}
		else {
			throw new InvalidNoException("Não é possível remover Raiz");
		}
		
		Object o = v.element();
		tamanho--;
		return o;
	}
	
	// troca dois elementos de posicao
	public void swapElements(No v, No w) {
		Object ov = v.element();
		Object ow = w.element();
		v.setElement(ov);
		w.setElement(ow);
	}
	
	public void preOrder(No n, Vector v) {
		Iterator<No> w = n.children();
		
		while (w.hasNext()) {
			preOrder(w.next(), v);
		}
	}
}
