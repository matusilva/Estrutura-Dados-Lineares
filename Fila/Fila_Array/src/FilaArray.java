
public class FilaArray 
{
	private Object[] fila;
	private int inicio;
	private int fim;
	private int tamanho;
	private Object[] novoArray;
	
	public FilaArray() 
	{
		this.fila = new Object[1];
		this.inicio = 0;
		this.fim = 0;
		this.tamanho = 0;
	}
	
	public int tamanho() 
	{
		return (this.fila.length - this.inicio + this.fim) % this.fila.length;
	}
	
	public boolean isEmpty() 
	{
		return this.inicio == this.fim;
	}
	
	public boolean isFull() 
	{
		return this.tamanho() == this.fila.length - 1;
	}
	
	public void inserir(Object elemento) 
	{
		if (isFull()) 
		{
			duplicar();
		}
		
		this.fila[this.fim] = elemento;
		this.fim = (this.fim + 1) % this.fila.length;
	}
	
	public void duplicar() 
	{
		novoArray = new Object[this.fila.length * 2];
		
		for (int ii = 0, i = this.inicio; ii != fila.length; ii++, i++) 
		{
			novoArray[ii] = this.fila[i % fila.length];
		}
		
		this.fila = this.novoArray;
		this.inicio = 0; 
		this.fim = tamanho();
	}
	
	public Object retirar() throws EFilaVazia 
	{
		if (isEmpty()) 
		{
			throw new EFilaVazia("Fila Vazia");
		}
		
		Object elemento = this.fila[this.inicio];
		this.inicio = (this.inicio + 1) % this.fila.length;
		return elemento;
	}
	
	public String toString() 
	{
		for (int ii = 0, i = this.inicio; ii != fila.length; ii++, i++) 
		{
			System.out.print(" " + this.fila[i % this.fila.length] + " ");
		}
		
		return "";
	}
}
