
public class Heap implements IHeap {

	private Integer size;
	private Integer heap[];
	
	public Heap() {
		this.size = 0;
		this.heap = new Integer[10];
	}
	
	@Override
	public void insert(Integer num) {
		this.heap[++this.size] = num;
		upHeap();
	}

	@Override
	public void removeMin() {
		this.troca(1, this.size);
		this.heap[this.size] = null;
		this.size--;
		downHeap();
	}
	
	private void troca(Integer valor1, Integer valor2) {
		Integer raiz = this.heap[valor1];
		this.heap[valor1] = heap[valor2];
		this.heap[valor2] = raiz;
	}

	@Override
	public Integer min() {
		return this.heap[1];
	}

	@Override
	public void upHeap() {
		int aux = size; //pego o ultimo valor
		// upHeap termina quando aux encontra a raiz ou quando o pai for menor ou igual ao filho
		while (!(aux == 1 || this.heap[aux / 2] <= this.heap[aux])) {
			Integer paicopia = this.heap[aux / 2];
			this.heap[aux / 2] = this.heap[aux];
			this.heap[aux] = paicopia;
			
			aux = aux / 2;
		}
	}

	@Override
	public void downHeap() {
		Integer aux = 1;
		//int filhoEsquerdo = 2 * aux; 
		//int filhoDireito =  2 * aux + 1;
		
		// comparar o pai com os dois filhos, esquerdo e direito ou encontra folha null
		// while(true)
		Integer filhoEsquerdo;
		Integer filhoDireito;
		Integer k;
		
		while (true) {
			
			filhoEsquerdo = 2 * aux; 
			filhoDireito =  2 * aux + 1;
			boolean analisaFilhos = true;
			
			if (aux > this.size ) {
				break;
			}
			
			else {
				if (filhoEsquerdo <= this.size) {
					if (this.heap[aux] > this.heap[filhoEsquerdo] ) {
						analisaFilhos = false;
					}
				}
				if (filhoDireito <= this.size) {
					if (this.heap[aux] > this.heap[filhoDireito] ) {
						analisaFilhos = false;
					}
				}
				if(analisaFilhos) break;
			}

			if (!(this.heap[filhoEsquerdo] == null) ) {
				if (!(this.heap[filhoDireito] == null)) {
					if (this.heap[filhoDireito] < this.heap[filhoEsquerdo]) {
						k = filhoDireito;
					}
					else {
						k = filhoEsquerdo;
					}
				}
				else {
					k = filhoEsquerdo;
				}
				
				if (this.heap[k] < this.heap[aux]) {
					troca(k, aux);
					aux = k;
				}
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < heap.length; i++) {
			System.out.println(heap[i] + " ");
		}
		
		System.out.println("\n");
	}

	@Override
	public Integer size() {
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
