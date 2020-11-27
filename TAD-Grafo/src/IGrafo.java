import java.util.ArrayList;

public interface IGrafo {
    public void inserirVertice(Vertices v);
    public void removerVertice(Vertices v);

    public Arestas insereAresta(Vertices v1, Vertices v2, Object valor, boolean isdirecionada);
    public void removeAresta(Arestas a);

    public Vertices[] finalVertices(Arestas a);
    public Vertices oposto(Vertices v, Arestas a);
    public boolean adjacente(Vertices v, Vertices w);

    public ArrayList<Vertices> vertices();
    public ArrayList<Arestas> arestas();
    public ArrayList<Arestas> arestasIncidentes(Vertices v);
}
