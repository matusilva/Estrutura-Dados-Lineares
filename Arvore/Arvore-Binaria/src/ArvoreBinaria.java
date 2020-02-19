import java.util.Iterator;

public class ArvoreBinaria implements IArvoreBinaria
{
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public Iterator elements() {
        return null;
    }

    @Override
    public Iterator nos() {
        return null;
    }

    @Override
    public No root() {
        return null;
    }

    @Override
    public No parent(No v) {
        return null;
    }

    @Override
    public Iterator children(No v) {
        return null;
    }

    @Override
    public boolean isInternal(No v) {
        return false;
    }

    @Override
    public boolean isExternal(No v) {
        return false;
    }

    @Override
    public boolean isRoot(No v) {
        return false;
    }

    @Override
    public int depth(No v) {
        return 0;
    }

    @Override
    public int replace(No v, int o) {
        return 0;
    }

    @Override
    public No filhoEsq(No v) {
        return null;
    }

    @Override
    public No filhoDir(No v) {
        return null;
    }

    @Override
    public boolean hasEsq(No v) {
        return false;
    }

    @Override
    public boolean hasDir(No v) {
        return false;
    }

    @Override
    public No buscar(int o, No raiz) {
        return null;
    }

    @Override
    public No remover(No v) {
        return null;
    }

    @Override
    public void inserir(int o) {

    }

    @Override
    public void print() {

    }
}
