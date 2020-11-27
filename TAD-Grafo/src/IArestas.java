public interface IArestas {
    public Vertices getVerticeDestino();
    public void setVerticeDestino(Vertices verticeDestino);

    public Vertices getVerticeOrigem();
    public void setVerticeOrigem(Vertices verticeOrigem);

    public boolean isDirecionada();
    public void setisDirecionada(boolean isdirecionada);

    public Object getValor();
    public void setValor(Object valor);
}
