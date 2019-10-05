
public class Pilha {
	
	public Object pilha[];
	public int posicao;
	public Object novoArray[];
	
	public Pilha() 
	{
		this.pilha = new Object[2]; //tamanho da pilha inicia com 2
		this.posicao = -1; //-1 significa vazia
	}
	
	public boolean isEmpty() 
	{
		if (this.posicao == -1) 
		{
			return true;
		}
		
		return false;
	}
	
	public Object pop() throws EPilhaVazia 
	{
		if (isEmpty()) 
		{
			throw new EPilhaVazia("Pilha está Vazia!");
		}
		else {
			return this.pilha[this.posicao--];
		}
	}
	
	public void push(Object valor) 
	{
		if (this.posicao == this.pilha.length - 1) 
		{
			novoArray = new Object[this.pilha.length * 2];
			for (int i = 0; i < pilha.length; i++) 
			{
				this.novoArray[i] = this.pilha[i];
			}
			
			this.pilha = this.novoArray;
		}
		
		this.pilha[++posicao] = valor;
	}
	
	public Object top() throws EPilhaVazia 
	{
		if (isEmpty()) 
		{
			throw new EPilhaVazia("Pilha está Vazia!");
		}
		return this.pilha[this.posicao];
	}
	
	public int size() 
	{
		if (isEmpty()) 
		{
			return 0;
		}
		return this.posicao + 1;
	}
}
