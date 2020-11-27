import java.util.ArrayList;

public class Grafo implements IGrafo {
    private Object[][] matriz;
    private ArrayList<Vertices> vertices;
    private ArrayList<Arestas> arestas;

    public Grafo() {
        this.matriz = new Object[0][0];
        this.arestas = new ArrayList<Arestas>();
        this.vertices = new ArrayList<Vertices>();
    }

    @Override
    public void inserirVertice(Vertices v) {
        vertices.add(v);
        Object newMatriz[][] = new Object[this.vertices.size()][this.vertices.size()];

        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz.length; j++) {
                newMatriz[i][j] = this.matriz[i][j];
            }
        }
        this.matriz = newMatriz;
    }

    @Override
    public void removerVertice(Vertices v) {
        Object valor = v.getValor();
        vertices.remove(v);
        ArrayList<Arestas> ai = arestasIncidentes(v);
        for (Arestas a : ai) {
            arestas.remove(a);
            a.setValor(null);
            a.setVerticeOrigem(null);
            a.setVerticeDestino(null);
        }
        v.setValor(null);

        Object newMatriz[][] = new Object[this.vertices.size()][this.vertices.size()];
        for (int i = 0; i < this.vertices.size(); i++) {
            for (int j = 0; j < this.vertices.size(); j++) {
                newMatriz[i][j] = this.matriz[i][j];
            }
        }
        this.matriz = newMatriz;
    }

    @Override
    public Arestas insereAresta(Vertices v1, Vertices v2, Object valor, boolean isdirecionada) {
        Arestas a = new Arestas(v1, v2, valor, isdirecionada);
        if (!a.isDirecionada()) {
            if (this.matriz[this.vertices.indexOf(v2)][this.vertices.indexOf(v1)] == null) {
                this.matriz[this.vertices.indexOf(v2)][this.vertices.indexOf(v1)] = new ArrayList<Arestas>();
            }
            ((ArrayList<Arestas>) this.matriz[this.vertices.indexOf(v2)][this.vertices.indexOf(v1)]).add(a);
        }
        if (this.matriz[this.vertices.indexOf(v1)][this.vertices.indexOf(v2)] == null) {
            this.matriz[this.vertices.indexOf(v1)][this.vertices.indexOf(v2)] = new ArrayList<Arestas>();
        }
        ((ArrayList<Arestas>) this.matriz[this.vertices.indexOf(v1)][this.vertices.indexOf(v2)]).add(a);

        this.arestas.add(a);

        return a;
    }

    @Override
    public void removeAresta(Arestas a) {
        int v1 = this.vertices.indexOf(a.getVerticeOrigem());
        int v2 = this.vertices.indexOf(a.getVerticeDestino());
        Object valor = a.getValor();
        if (!a.isDirecionada()) {
            ((ArrayList<Arestas>) (ArrayList<Arestas>) this.matriz[v2][v1]).remove(a);
        }
        ((ArrayList<Arestas>) (ArrayList<Arestas>) this.matriz[v1][v2]).remove(a);
        a.setVerticeOrigem(null);
        a.setVerticeDestino(null);
        a.setValor(null);

        this.arestas.remove(a);
    }

    @Override
    public Vertices[] finalVertices(Arestas a) {
        Vertices v[] = {a.getVerticeOrigem(), a.getVerticeDestino()};
        return v;
    }

    @Override
    public Vertices oposto(Vertices v, Arestas a) {
        if (a.getVerticeOrigem().getValor() == v.getValor()) {
            return a.getVerticeDestino();
        }
        else if (a.getVerticeDestino().getValor() == v.getValor()) {
            return a.getVerticeOrigem();
        }
        return null;
    }

    @Override
    public boolean adjacente(Vertices v, Vertices w) {
        for (Arestas a : arestas) {
            if ((a.getVerticeOrigem() == v && a.getVerticeDestino() == w) || (a.getVerticeOrigem() == w && a.getVerticeDestino() == v)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Vertices> vertices() {
        return this.vertices;
    }

    @Override
    public ArrayList<Arestas> arestas() {
        return this.arestas;
    }

    @Override
    public ArrayList<Arestas> arestasIncidentes(Vertices v) {
        ArrayList<Arestas> ai = new ArrayList<>();
        for (Arestas a : arestas) {
            if (a.getVerticeOrigem() == v || a.getVerticeDestino() == v) {
                ai.add(a);
            }
        }
        return ai;
    }

    public void substituirVertice(Vertices v, Object valor) {
        v.setValor(valor);
    }
    public void substituirAresta(Arestas a, Object valor) {
        a.setValor(valor);
    }

    public void print() {
        for (int i = 0; i < matriz.length; i++)  {
            System.out.print(vertices.get(i).getValor() + "|");
            for (int j = 0; j < matriz[0].length; j++) {
                if (this.matriz[i][j] == null) {
                    System.out.print("0|");
                }
                else {
                    System.out.print(((ArrayList<Arestas>) this.matriz[i][j]).size()+ "|"); //imprime caracter a caracter
                }
            }
            System.out.println(" "); //muda de linha
        }
        System.out.println("Quantidade de vertices:" + this.vertices.size());
    }
}
