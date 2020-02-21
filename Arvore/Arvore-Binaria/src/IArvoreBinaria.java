import java.util.ArrayList;
import java.util.Iterator;

public interface IArvoreBinaria
{
    // Metodos Genericos
    public int size();
    public boolean isEmpty();
    public int height();

    public Iterator elements();
    public ArrayList nos();

    // Metodos de Acesso
    public No root();
    public No parent(No v);
    public Iterator children(No v);

    // Metodos de Consulta
    public boolean isInternal(No v);
    public boolean isExternal(No v);
    public boolean isRoot(No v);
    public int depth(No v);

    // Metodos de Atualizacao
    public int replace(No v, int o);

    // Arvore Binaria
    public No filhoEsq(No v);
    public No filhoDir(No v);
    public boolean hasEsq(No v);
    public boolean hasDir(No v);

    // Metodos de Implementacao
    public No buscar(int o, No raiz);
    public No remover(No v);
    public void inserir(int o);
    public void print();
}
