
public interface IHeap {
	public void insert(Integer num);
	public void removeMin();
	public Integer min();
	public void upHeap();
	public void downHeap();
	public Integer size();
	public boolean isEmpty();
}
