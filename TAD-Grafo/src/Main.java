public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        /*
            Inserindo Vertices
        */
        Vertices v1 = new Vertices("RN");
        grafo.inserirVertice(v1);

        Vertices v2 = new Vertices("MG");
        grafo.inserirVertice(v2);

        Vertices v3 = new Vertices("SP");
        grafo.inserirVertice(v3);

        Vertices v4 = new Vertices("PB");
        grafo.inserirVertice(v4);

        /*
            Inserindo Arestas direcionada e não direcionada
         */
        Arestas a = grafo.insereAresta(v1, v2,1, true);
        Arestas a2 = grafo.insereAresta(v2, v3, 2, false);

        grafo.print();
        Vertices arr[] = grafo.finalVertices(a);
        System.out.println("Aresta Direcionada: "+ arr[0].getValor()+ " -> " + arr[1].getValor());

        grafo.removeAresta(a);
        grafo.removerVertice(v2);
        grafo.print();

    }
}
