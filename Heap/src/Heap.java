
public class Heap implements IHeap {

	private int size;
	private int heap[];
	
	public Heap() {
		this.size = 0;
		this.heap = new int[10];
	}
	
	@Override
	public void insert(int num) {
		this.heap[++this.size] = num;
		upHeap();
	}

	@Override
	public void removeMin() {
		this.troca(1, this.size);
		this.size--;
		//downHeap();
	}
	
	private void troca(int valor1, int valor2) {
		int raiz = this.heap[valor1];
		this.heap[valor1] = heap[valor2];
		this.heap[valor2] = raiz;
	}

	@Override
	public int min() {
		return this.heap[1];
	}

	@Override
	public void upHeap() {
		int aux = size;
		while (!(aux == 1 || this.heap[aux / 2] <= this.heap[aux])) {
			int paicopia = this.heap[aux / 2];
			this.heap[aux / 2] = this.heap[aux];
			this.heap[aux] = paicopia;
			
			aux = aux / 2;
		}
	}

	@Override
	public void downHeap() {
		int aux = 1;
		int filhoEsquerdo = 2 * aux; 
		int filhoDireito =  2 * aux + 1;
		
		while (aux <= size) {
			if (this.heap[filhoEsquerdo] < this.heap[aux]) {
				troca(filhoEsquerdo, aux);
				aux = filhoEsquerdo;
			}
			else if (this.heap[filhoDireito] < this.heap[aux]) {
				troca(filhoDireito, aux);
				aux = filhoDireito;
			}
			else {
				aux = size + 1;
			}
			
			filhoEsquerdo = 2 * aux;
			filhoDireito =  2 * aux + 1;
		}
	}
	
	public void print() {
		for (int i = 0; i < heap.length; i++) {
			System.out.println(heap[i] + " ");
		}
		
		System.out.println("\n");
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	
}
