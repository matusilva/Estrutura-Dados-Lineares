
public interface ArvoreGenerica extends Arvore {
	
	public void addChildren(No v, Object o);
	
	public Object remove(No v) throws InvalidNoException;

}
