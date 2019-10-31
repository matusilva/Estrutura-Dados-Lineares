
public interface IHeap {
	public void insert(int num);
	public void removeMin();
	public int min();
	public void upHeap();
	public void downHeap();
	public int size();
	public boolean isEmpty();
}
