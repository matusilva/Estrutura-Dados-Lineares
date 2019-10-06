import java.util.Iterator;

public interface Arvore
{
	// Metodos genericos
	public int size();
	
	public boolean isEmpty();

	public int height();

	public Iterator elements();

	public Iterator nos();

	// Metodos de acesso
	public No root();

	public No parent(No v);

	public Iterator children(No v);

	// Metodos de consulta
	public boolean isInternal(No v);

	public boolean isExternal(No v);

	public boolean isRoot(No v);

	public int depth(No v);

	// Metodos de atualizacao
	public Object replace(No v, Object o);
}