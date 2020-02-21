import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreBinaria implements IArvoreBinaria
{
    private No raiz;
    private int tamanho;
    private ArrayList<No> nodes, preOrder = new ArrayList<No>(), posOrder = new ArrayList<No>();

    public ArvoreBinaria() { }

    public ArvoreBinaria(int o)
    {
        this.raiz = new No(o);
        tamanho++;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public int size() { return this.getTamanho(); }

    @Override
    public boolean isEmpty()
    {
        return this.getRaiz() == null;
    }

    @Override
    public int height() {
        if (this.root() == null)
        {
            return 0;
        }
        else {
            return altura(this.root());
        }
    }

    private int altura(No v)
    {
        if (v == null || isExternal(v)) {
            return 0;
        }
        else {
            ArrayList<No> filhos = new ArrayList<No>();
            filhos.add(v.getFilhoEsq());
            filhos.add(v.getFilhoDir());
            int h = 0;

            for (int i = 0; i < filhos.size(); i++) {
                h = Math.max(h, this.altura(filhos.get(i)));
            }
            return 1 + h;
        }
    }

    @Override
    public Iterator elements() {
        return null;
//        Iterator it;
//        if (root() == null) {
//            return null;
//        }
//        else {
//            //it = emOrdem(this.root());
//            ArrayList obj = new ArrayList();
//            while (it.hasNext()) {
//                No node = (No) it.next();
//                int o = node.getO();
//                obj.add(o);
//            }
//            it = obj.iterator();
//            return it;
//        }
    }

    @Override
    public Iterator nos() {
        return null;
//        if (this.root() == null) {
//            return null;
//        }
//        else {
//            return inOrder(this.root());
//        }
    }

    @Override
    public No root() {
        return getRaiz();
    }

    @Override
    public No parent(No v) {
        return v.getPai();
    }

    @Override
    public Iterator children(No v) {
        ArrayList<No> node = new ArrayList<No>();
        node.add(v.getFilhoEsq());
        node.add(v.getFilhoDir());
        Iterator it = node.iterator();
        return it;
    }

    @Override
    public boolean isInternal(No v) {
        if (v == null) {
            return false;
        }
        return v.getFilhoDir() != null || v.getFilhoEsq() != null;
    }

    @Override
    public boolean isExternal(No v) {
        if (v == null) {
            return true;
        }
        return v.getFilhoDir() == null && v.getFilhoEsq() == null;
    }

    @Override
    public boolean isRoot(No v) {
        return v == getRaiz();
    }

    @Override
    public int depth(No v) {
        if (this.raiz == v) {
            return 0;
        }

        return 1 + this.depth(v.getPai());

    }

    @Override
    public int replace(No v, int o) {
        int aux = v.getO();
        v.setO(o);
        return aux;
    }

    @Override
    public No filhoEsq(No v) {
        if (hasEsq(v)) {
            return v.getFilhoEsq();
        }
        else {
            return null;
        }
    }

    @Override
    public No filhoDir(No v) {
        if (hasDir(v)) {
            return v.getFilhoDir();
        }
        else {
            return null;
        }
    }

    @Override
    public boolean hasEsq(No v) {
        if (v.getFilhoEsq() != null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean hasDir(No v) {
        if (v.getFilhoDir() != null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public No buscar(int o, No raiz) {
        if (isExternal(raiz)) {
            return raiz;
        }

        if (o < raiz.getO()) {
            if (raiz.getFilhoEsq() != null) {
                return buscar(o, raiz.getFilhoEsq());
            }
        }

        else if (o == raiz.getO()) {
            return raiz;
        }

        else if (o > raiz.getO()) {
            if (raiz.getFilhoDir() != null) {
                return buscar(o, raiz.getFilhoDir());
            }
        }

        return raiz;
    }

    @Override
    public No remover(No v) {
        return remocao(v, v.getO());
    }

    private No remocao(No node, int o) {
        if (node != null) {
            // excluir folha
            if (isExternal(node)) {
                if (node.getPai().getO() <= 0 ) {
                    node.getPai().setFilhoEsq(null);
                }
                else {
                    node.getPai().setFilhoDir(null);
                }
                this.tamanho--;
                return node;
            }
            // excluir no com um filho
            if (node.getFilhoEsq() == null && node.getFilhoDir() != null) {
                if (node.getPai().getO() <= 0) {
                    node.getPai().setFilhoEsq(node.getFilhoDir());
                    node.getFilhoDir().setPai(node.getPai());
                }
                else {
                    node.getPai().setFilhoDir(node.getFilhoDir());
                    node.getFilhoDir().setPai(node.getPai());
                }
                this.tamanho--;
                return node;
            }

            if (node.getFilhoEsq() != null && node.getFilhoDir() == null) {
                if (node.getPai().getO() <= 0) {
                    node.getPai().setFilhoEsq(node.getFilhoEsq());
                    node.getFilhoEsq().setPai(node.getPai());
                }
                else {
                    node.getPai().setFilhoDir(node.getFilhoEsq());
                    node.getFilhoEsq().setPai(node.getPai());
                }
                this.tamanho--;
                return node;
            }
            // excluir com dois nós
            No aux = node.getFilhoDir();
            while (aux.getFilhoEsq() != null) {
                // pecorrer para pegar o menor elemento que obrigatoriamente é um filho esquerdo
                aux = aux.getFilhoEsq();
            }
            int menorEsquerdo = aux.getO();
            remocao(aux, menorEsquerdo);
            node.setO(menorEsquerdo);
            this.tamanho--;
            return node;
        }
        return null;
    }

    @Override
    public void inserir(int o) {
        No node = new No(o);
        if (this.raiz == null){
            setRaiz(node);
            this.tamanho++;
        }
        else {
            No nodePai = buscar(o, getRaiz());
            if (nodePai.getO() == node.getO()) {
                System.out.println("Elemento Já existe");
            }
            else if (node.getO() < nodePai.getO()) {
                nodePai.setFilhoEsq(node);
                node.setPai(nodePai);
            }
            else if (node.getO() > nodePai.getO()) {
                nodePai.setFilhoDir(node);
                node.setPai(nodePai);
            }

            this.tamanho++;
        }
    }

    public Iterator preOrder()
    {
        preOrder = new ArrayList();
        if (this.root() == null) {
            return null;
        }
        else {
            return preOrder(this.root());
        }
    }

    public Iterator preOrder(No v)
    {
        preOrder.add(v);

        if (isInternal(v))
        {
            if (filhoEsq(v) != null) {
                preOrder(filhoEsq(v));
            }

            if (filhoDir(v) != null) {
                preOrder(filhoDir(v));
            }
        }

        Iterator<No> it = preOrder.iterator();
        return it;
    }

    public void emOrdem(No v)
    {
        if (v.getFilhoEsq() != null)
        {
            emOrdem(v.getFilhoEsq());
        }

        this.nodes.add(v);

        if (v.getFilhoDir() != null) {
            emOrdem(v.getFilhoDir());
        }

    }

    public Iterator posOrder()
    {
        posOrder = new ArrayList();
        if (this.root() == null)
        {
            return null;
        }
        else {
            return posOrder(this.root());
        }
    }

    public Iterator posOrder(No v)
    {
        if (isInternal(v))
        {
            if (filhoEsq(v) != null) {
                posOrder(filhoEsq(v));
            }

            if (filhoDir(v) != null) {
                posOrder(filhoDir(v));
            }
        }

        posOrder.add(v);
        Iterator it = posOrder.iterator();
        return it;
    }

    public ArrayList<No> nodes() {
        this.nodes = new ArrayList<No>();
        this.emOrdem(this.root());
        return this.nodes;
    }
    @Override
    public void print() {
        int x = altura(this.raiz) +1, y = this.tamanho, z = 0;
        int matrix[][] = new int[x][y];
        ArrayList<No> nodesContidos = this.nodes();
        while (z < y){
            matrix[ this.depth(nodesContidos.get(z)) ][z] = nodesContidos.get(z).getO();
            z++;
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print(matrix[i][j] + "  ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }
    }
}
