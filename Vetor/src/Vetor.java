
public class Vetor {
	
	private Object[] vetor; // array vetor
	private int n;			// tamanho do vetor
	
	public Vetor() {
		this.vetor = new Object[2];
		this.n = 0;
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public Object elemAtRank(int rank) {
		return vetor[rank];
	}
	
	public void insertAtRank(int rank, Object o) {
		if (this.n == this.vetor.length) 
		{
			Object[] novoVetor = new Object[this.vetor.length * 2];
			for (int i = 0; i < n; i++) 
			{
				novoVetor[i] = this.vetor[i];
			}
			this.vetor = novoVetor;
		}
		
		for (int i = n-1; i >= rank; n--) 
		{
			this.vetor[i] = this.vetor[i+1];
		}
		
		this.vetor[rank] = o;
		this.n++;
	}
	
	public Object removeAtRank(int rank) {
		Object temp = vetor[rank];
		
		for (int i = rank; i < n-1; i++) {
			this.vetor[i] = this.vetor[i+1];
		}
		
		n--;
		return temp;
	}
	
	public Object replaceAtRank(int rank, Object o) {
		this.vetor[rank] = o;
		return o;
	}
	
	public String toString() {
		int size = size();
		String saida = "" + size + "\t ";
		
		for (int i = 0; i < size; i++) 
		{
			saida += vetor[i] + " ";
		}
		return saida;
	}
}
