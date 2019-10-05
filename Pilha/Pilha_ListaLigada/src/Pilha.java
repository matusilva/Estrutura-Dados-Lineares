
public class Pilha {
	No topo;
	int qtd = 0;
	
	
	public boolean isEmpty() 
	{
		return qtd == 0;
	}
	
	public void push(Object valor) 
	{
		No novoNo = new No(valor, topo);
		topo = novoNo;
		qtd++;
	}
	
	public Object pop() throws EPilhaVazia 
	{
		if (!isEmpty()) 
		{
			Object temp = topo.getValor();
			topo = topo.getProximo();
			qtd--;
			return temp;
		}
		
		throw new EPilhaVazia("Pilha Vazia");
	}
	
	public Object top() throws EPilhaVazia 
	{
		if (!isEmpty()) 
		{
			return topo.getValor();
		}
		
		throw new EPilhaVazia("Pilha Vazia");
	}
	
	public int size() 
	{
		return qtd;
	}
}
