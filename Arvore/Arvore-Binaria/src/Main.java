import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria ab = new ArvoreBinaria();
        System.out.println("----------- Inserindo Valores -------------");
        ab.inserir(4);
        ab.inserir(2);
        ab.inserir(7);
        ab.inserir(9);
        ab.inserir(11);
        ab.print();

        System.out.println("----------- Removendo o valor 7 -------------");
        No find = ab.buscar(2, ab.getRaiz());
        System.out.println(ab.remover(find));
        //ab.remover(find);
        ab.print();

    }
}
