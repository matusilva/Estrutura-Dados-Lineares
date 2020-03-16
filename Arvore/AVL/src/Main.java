public class Main {
    public static void main(String[] args) {
        AVL avl = new AVL();
        System.out.println("----------- Inserindo Valores -------------");
        avl.inserir(4);
        avl.inserir(2);
        avl.inserir(7);
        avl.inserir(9);
        avl.inserir(11);
        avl.print();
    }
}
