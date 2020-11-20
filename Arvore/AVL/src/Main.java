import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("| 1 | - Inserir\n| 2 | - Remover\n| 3 | - Buscar\n| 4 | - SAIR");
        System.out.println("| --- Selecione a Opção que deseja realizar:");
    }
    public static void main(String[] args) {
        AVL avl = new AVL();
        Scanner sc = new Scanner(System.in);

        int op;
        do {
            menu();
            op = sc.nextInt();

            if (op == 1) {
                System.out.print("Digite o valor que deseja inserir: ");
                int valor = sc.nextInt();
                avl.inserir(valor);
                System.out.println(" --- AVL --- ");
                avl.print();
            }

            if (op == 2) {
                avl.print();
                System.out.print("Digite o valor que deseja remover: ");
                int valor = sc.nextInt();
                NoAVL find = (NoAVL) avl.buscar(valor, avl.getRaiz());
                avl.remover(find);
                avl.print();
            }

            if (op == 3) {
                avl.print();
                System.out.print("Digite o valor que deseja buscar ");
                int valor = sc.nextInt();
                NoAVL find = (NoAVL) avl.buscar(valor, avl.getRaiz());
                System.out.println(find.getO());
            }

        } while (op != 4);{
            sc.close();
            System.exit(0);
        }


        int valor = sc.nextInt();
        NoAVL find = (NoAVL) avl.buscar(valor, avl.getRaiz());
        avl.remover(find);

        avl.print();
    }
}
