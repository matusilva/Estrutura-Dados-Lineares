
public interface IDicionario {
	public Object findElement(int k);
	public void insertItem(int k, Object o);
	public Object removeElement(int k);
	public int size();
	public boolean isEmpty();
}
