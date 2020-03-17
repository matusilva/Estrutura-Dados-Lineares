import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVL avl = new AVL();

        System.out.println("| ----- Inserindo Valores: 4, 2, 7, 9, 11");
        avl.inserir(4);
        avl.inserir(2);
        avl.inserir(7);
        avl.inserir(9);
        avl.inserir(11);

        avl.print();

        System.out.print("| ----- Removendo o valor: ");
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        NoAVL find = (NoAVL) avl.buscar(valor, avl.getRaiz());
        avl.remover(find);

        avl.print();
    }
}
