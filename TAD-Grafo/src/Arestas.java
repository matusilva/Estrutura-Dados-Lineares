public class Arestas implements IArestas {
    private Vertices verticeOrigem;
    private Vertices verticeDestino;
    private Object valor;
    private boolean isdirecionada;

    public Arestas(Vertices verticeOrigem, Vertices verticeDestino) {
        super();
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        isdirecionada = false;
    }
    public Arestas(Vertices verticeOrigem, Vertices verticeDestino, Object valor) {
        super();
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        this.valor = valor;
        isdirecionada = false;
    }
    public Arestas(Vertices verticeOrigem, Vertices verticeDestino, Object valor, boolean isdirecionada) {
        super();
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        this.valor = valor;
        this.isdirecionada = isdirecionada;
    }

    @Override
    public Vertices getVerticeDestino() {
        return verticeDestino;
    }

    @Override
    public void setVerticeDestino(Vertices verticeDestino) {
        this.verticeDestino = verticeDestino;
    }

    @Override
    public Vertices getVerticeOrigem() {
        return verticeOrigem;
    }

    @Override
    public void setVerticeOrigem(Vertices verticeOrigem) {
        this.verticeOrigem = verticeOrigem;
    }

    @Override
    public boolean isDirecionada() {
        return isdirecionada;
    }

    @Override
    public void setisDirecionada(boolean isdirecionada) {
        this.isdirecionada = isdirecionada;
    }

    @Override
    public Object getValor() {
        return valor;
    }

    @Override
    public void setValor(Object valor) {
        this.valor = valor;
    }
}
