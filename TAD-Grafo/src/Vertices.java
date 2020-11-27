public class Vertices implements IVertices {
    private Object valor;

    public Vertices(Object valor) {
        this.valor = valor;
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