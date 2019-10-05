
public class No {
	
	private Object valor;
	private No proximo;
	
	public No(Object valor,No proximo) 
	{
		this.valor = valor;
		this.proximo = proximo;
	}
	
	public void setValor(Object valor) 
	{
		this.valor = valor;
	}
	
	public Object getValor() 
	{
		return valor;
	}
	
	public void setProximo(No proximo) 
	{
		this.proximo = proximo;
	}
	
	public No getProximo() 
	{
		return proximo;
	}
}
