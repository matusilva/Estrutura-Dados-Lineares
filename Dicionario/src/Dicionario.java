
public class Dicionario implements IDicionario {

	private No[] heap;
	private int size;
	
	public Dicionario() {
		heap = new No[13];
		size = 0;
	}
	
	// Linear Probing
	// h(x) =x mod13
	private int h(int k) {
		return k % this.heap.length;
	}
	
	@Override
	public Object findElement(int k) {
		int i = h(k);
		// j = p no slide
		for (int j = 0; j < heap.length; j++) 
		{
			// node = c no slide
			No node =  heap[i];
			
			if (!(node == null)) 
			{
				if (!node.isAvailable() && k == node.getK()) 
				{
					return node.getO();
				}
				
				else 
				{
					i = (i + 1) % this.heap.length;
				}
			}
			else 
			{
				return null;
			}
		}
		return null;
	}

	@Override
	public void insertItem(int k, Object o) {
		if (this.size == this.heap.length) 
		{
			System.out.println("A Tabela Hash encontra-se cheia");
		}
		
		int j = 0;
		
		while (true) 
		{
			No node = new No();
			node.setO(o); 
			node.setK(k); 
			node.setAvailable(false);
			
			int i = j + h(k);
			// proximo
			j++;
			// j = p no slide
			if (this.heap[i] == null || this.heap[i].isAvailable()) 
			{
				this.heap[i] = node;
				this.size++;
				break;
			}
			// i = (i + 1) % heap.length;
		}
	}

	@Override
	public Object removeElement(int k) {
		int i = h(k);
		for (int j = 0; j < heap.length; j++) 
		{
			No node = this.heap[i];
			if (!(node == null)) 
			{
				if (!node.isAvailable() && k == node.getK()) 
				{
					node.setAvailable(true);
					this.size--;
					return node.getO();
				}
				else 
				{
					i = i + 1 % this.heap.length;
				}
			}
			else 
			{
				return null;
			}
		}
		return null;
	}
	
	public void print() {
		for (int i = 0; i < heap.length; i++) 
		{
			if (this.heap[i] == null) 
			{
				System.out.println("null");
			}
			// caso for removido
			else if (this.heap[i].isAvailable()) {
				System.out.println("null");
			}
			else 
			{
				System.out.println("| " + this.heap[i].getK()+" | " + this.heap[i].getO());
			}
		}
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

}
