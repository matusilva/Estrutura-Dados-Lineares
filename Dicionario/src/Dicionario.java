
public class Dicionario implements IDicionario {

	private No[] heap;
	private int size;
	
	public Dicionario() {
		heap = new No[20];
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
		for (int j = 0; j < heap.length; j++) {
			// node = c no slide
			No node =  heap[i];
			if (!(node == null)) {
				if (!node.isAvailable() && k == node.getK()) {
					return node.getO();
				}
				else {
					i = (i + 1) % this.heap.length;
				}
			}
			else {
				return null;
			}
		}
		return null;
	}

	@Override
	public void insertItem(int k, Object o) {
		if (this.size == this.heap.length) {
			System.out.println("Cheio");
		}
		
		No node = new No();
		node.setO(o); 
		node.setK(k); 
		node.setAvailable(false);
		
		int i = h(k);
		// j = p no slide
		for (int j = 0; j < heap.length; j++) {
			if (this.heap[i] == null || this.heap[i].isAvailable()) {
				this.heap[i] = node;
				this.size++;
			}
			i = (i + 1) % heap.length;
		}
		
	}

	@Override
	public Object removeElement(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
