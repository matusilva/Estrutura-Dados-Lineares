
public class Pilha_RubroNegra {
	public Object pilha[];
	public int posicaop;
	public int sizep;
	
	public int posicaov;
	public int sizev;
	
	public Object novoArray[];
	
	public Pilha_RubroNegra() 
	{
		this.pilha = new Object[1];
		this.posicaop = -1; //vazia
		this.posicaov = 1; //vazia
	}
	
	public boolean isEmpty() 
	{
		if (this.sizep == 0 && this.sizev == 0) 
		{
			return true;
		}
		return false;
	}
	
	public String ToString() {
		for (int i = 0; i < pilha.length; i++) {
			System.out.print(pilha[i]+ " ");
		}
		return "";
	}
	
	public int sizepreto() 
	{
		return this.sizep;
	}
	
	public int sizevermelho() 
	{
		return this.sizev;
	}
	
	public void pushp(Object valorp) 
	{
		if (this.posicaov - this.posicaop == 1) 
		{
			duplicar();
		}
		
		this.pilha[++posicaop] = valorp;
		this.sizep++;
	}
	
	public void pushv(Object valorv) 
	{
		if (this.posicaov - this.posicaop == 1) 
		{
			duplicar();
		}
		
		this.pilha[--posicaov] = valorv;
		this.sizev++;
	}
	
	public void duplicar() 
	{
		this.novoArray = new Object[this.pilha.length * 2];
		for (int i = 0; i < sizep; i++) 
		{
			this.novoArray[i] = this.pilha[i];
		}
		
		for (int i = 0; i < sizev; i++) 
		{
			this.novoArray[novoArray.length - sizev + i] = this.pilha[this.posicaov + i];
		}
		
		this.posicaov = this.novoArray.length - sizev; //novo topo
		this.pilha = this.novoArray;
	}
	
	public Object popp() throws EPilhaVazia 
	{
		if (isEmpty()) 
		{
			throw new EPilhaVazia("A pilha está Vazia!");
		}
		
		Object retornopop = this.pilha[this.posicaop--];
		this.sizep--;
		return retornopop;
	}
	
	public Object popv() throws EPilhaVazia 
	{
		if (isEmpty()) 
		{
			throw new EPilhaVazia("A pilha está Vazia");
		}
		
		Object retornopop = this.pilha[this.posicaov++];
		this.sizev--;
		return retornopop;
	}
	
	public Object topp() throws EPilhaVazia 
	{
		if (isEmpty()) 
		{
			throw new EPilhaVazia("A pilha está Vazia");
		}
		
		return this.pilha[this.posicaop];
	}
	
	public Object topv() throws EPilhaVazia 
	{
		if (isEmpty()) 
		{
			throw new EPilhaVazia("A pilha está Vazia");
		}
		
		return this.pilha[this.posicaov];
	}
}
