
public class Fila {
	
	No primeiro;
	No ultimo;
	int qtd = 0;
	
	public Fila() 
	{
		this.primeiro = null;
		this.ultimo = null;
	}
	
	public boolean isEmpty() 
	{
		if (qtd == 0) 
		{
			return true;
		}
		return false;
	}
	
	public void enfileirar(Object valor) 
	{
		No novoNo = new No(valor);
		
		if (isEmpty()) 
		{
			this.primeiro = novoNo;
			this.ultimo = novoNo;
		}
		else 
		{
			ultimo.setProximo(novoNo);
			ultimo = novoNo;
		}
		qtd++;
	}
	
	public void desenfileirar() throws EFilaVazia 
	{
		if (isEmpty()) 
		{
			throw new EFilaVazia("Fila Vazia");
		}
		else if (ultimo == primeiro) { //apenas um objeto na fila
			primeiro = null; //apontar para nada
			qtd--;
		}
		else 
		{
			No auxiliar = primeiro;
			auxiliar = primeiro.getProximo();
			primeiro = auxiliar;
			qtd--;
		}
	}
	
	public Object size() 
	{
		return qtd;
	}

}
