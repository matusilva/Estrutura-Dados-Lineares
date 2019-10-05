
public class No {
	
	private Object valor;
	No proximo;
	
	public No(Object valor) 
	{
		this.valor = valor;
		this.proximo = null;
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
