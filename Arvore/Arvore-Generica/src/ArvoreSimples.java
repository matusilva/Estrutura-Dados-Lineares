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

	// Tamanho da arvore
	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int height() {
		int altura = 0;
		return altura;
	}

	@Override
	public Iterator elements() {
		return null;
	}

	@Override
	public Iterator nos() {
		return null;
	}

	// Raiz da arvore
	@Override
	public No root() {
		return raiz;
	}

	// Pai
	@Override
	public No parent(No v) {
		return (v.parent());
	}

	// Filho
	@Override
	public Iterator children(No v) {
		return (v.children());
	}

	// No interno
	@Override
	public boolean isInternal(No v) {
		return (v.childrenNumber() > 0);
	}

	// No externo
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
	public int depth(No v) {
		int profundidade = profundidade(v);
		return 0;
	}

	private int profundidade(No v) {
		if (v == raiz) {
			return 0;
		}
		else {
			return 1 + profundidade(v.parent());
		}
	}

	@Override
	public Object replace(No v, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addChildren(No v, Object o) {
		No novo = new No(v, o);
		v.addChild(novo);
		tamanho++;
	}

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
		/*fazer com que o objeto que estava na posicao v
		 * fique na posicao w 
		 * e fazer com que o objeto que 
		 * estava na posicao w 
		 * fique na v
		*/
	}
}
