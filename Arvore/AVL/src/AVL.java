import java.util.ArrayList;

public class AVL extends ArvoreBinaria implements IAVL {

    public NoAVL filhoEsq(NoAVL v) {
        return this.hasEsq(v) ? (NoAVL) v.getFilhoEsq() : null;
    }

    public NoAVL filhoDir(NoAVL v) {
        return this.hasDir(v) ? (NoAVL) v.getFilhoDir() : null;
    }

    @Override
    public void rotacaoSimplesEsq(NoAVL no) {
        if (hasDir(no)) {
            NoAVL aux = filhoDir(no);

            // filho esquerdo do filho direito do no
            if (hasEsq(filhoDir(no))) {
                NoAVL netoesq = filhoEsq(aux);
                netoesq.setPai(no);
                no.setFilhoDir(netoesq);
            }
            else {
                no.setFilhoDir(null);
            }
            // pai do no
            if (isRoot(no)) {
                setRaiz(aux);
                aux.setPai(null);
            }
            else {
                NoAVL nodepai = (NoAVL) no.getPai();
                if (no.getO() < nodepai.getO()) {
                    nodepai.setFilhoEsq(aux);
                }
                else {
                    nodepai.setFilhoDir(aux);
                }
                aux.setPai(nodepai);
            }
            aux.setFilhoEsq(no);
            no.setPai(aux);

            // atualizando fator de balanceamento A & B
            int fbA = 0, fbB = 0;
            fbB = (no.getFb() + 1) - Math.min(aux.getFb(), 0);
            fbA = (aux.getFb() + 1) + Math.max(fbB, 0);
            aux.setFb(fbA);
            no.setFb(fbB);

        }
    }

    @Override
    public void rotacaoSimplesDir(NoAVL no) {
        if (hasEsq(no)) {
            NoAVL aux = filhoEsq(no);

            // filho direito do filho esquerdo do no
            if (hasDir(filhoEsq(no))) {
                NoAVL netodir = filhoDir(aux);
                netodir.setPai(no);
                no.setFilhoEsq(netodir);
            }
            else {
                no.setFilhoEsq(null);
            }

            // pai do no
            if (isRoot(no)) {
                setRaiz(aux);
            }
            else {
                NoAVL nodepai = (NoAVL) no.getPai();
                if (no.getO() < nodepai.getO()) {
                    nodepai.setFilhoEsq(aux);
                }
                else {
                    nodepai.setFilhoDir(aux);
                }
                aux.setPai(nodepai);
            }
            aux.setFilhoDir(no);
            no.setPai(aux);

            int fbA = 0, fbB = 0;
            fbB = (no.getFb() - 1) - Math.max(aux.getFb(), 0);
            fbA = (aux.getFb() - 1) + Math.max(no.getFb(), 0);
            no.setFb(fbB);
            aux.setFb(fbA);
        }
    }

    @Override
    public void atualizaFB(NoAVL no, int op, int nodefb) {
        no.setFb(no.getFb() + nodefb);
        int fb = no.getFb();

        if (fb == 2) {
            if (hasEsq(no) && filhoEsq(no).getFb() >= 0) {
                rotacaoSimplesDir(no);
            }
        }
        else if (fb == -2) {
            if (hasDir(no) && filhoDir(no).getFb() <= 0) {
                rotacaoSimplesEsq(no);
            }
        }

        if (op == 1) {
            // opcao 1 = inserir
            if (no.getPai() != null && no.getFb() != 0) {
                if (no.getO() < no.getPai().getO()) {
                    atualizaFB((NoAVL) no.getPai(), op, 1);
                }
                else {
                    atualizaFB((NoAVL) no.getPai(), op, -1);
                }
            }
        }
        else if (op == 2) {
            // opcao 2 = remover
            if (no.getPai() != null && no.getFb() == 0) {
                if (no.getO() < no.getPai().getO()) {
                    atualizaFB((NoAVL) no.getPai(), op, -1);
                }
                else {
                    atualizaFB((NoAVL) no.getPai(), op, 1);
                }
            }
        }
    }

    public void inserir(int o) {
        NoAVL node = new NoAVL(o);
        int result;
        if (isEmpty()) {
            this.setRaiz(node);
            this.tamanho++;
            System.out.println(node + "Inserido como a RAIZ");
        }
        else {
            NoAVL novo = (NoAVL) buscar(o, getRaiz());
            result = novo.getO() - node.getO();
            if (result > 0) {
                novo.setFilhoEsq(node);
                node.setPai(novo);
                this.tamanho++;
                // node inserido a esquerda do pai novo
                atualizaFB(novo, 1, 1);
            }
            else if (result < 0) {
                novo.setFilhoDir(node);
                node.setPai(novo);
                this.tamanho++;
                // node inserido a direita de novo
                atualizaFB(novo, 1, -1);
            }
            else if (result == 0) {
                System.out.println("No Já Existe");
            }
        }
    }

    public NoAVL remover(NoAVL no) {
        return remocao(no, no.getO());
    }

    private NoAVL remocao(NoAVL node, int o) {
        if (node != null) {
            // excluir folha
            if (isExternal(node)) {
                if (node.getO() - node.getPai().getO() <= 0) {
                    node.getPai().setFilhoEsq(null);
                    atualizaFB((NoAVL) node.getPai(), 2, -1);
                } else {
                    node.getPai().setFilhoDir(null);
                    atualizaFB((NoAVL) node.getPai(), 2, 1);
                }
                this.tamanho--;
                return node;
            }

            // excluir no com um filho
            if (node.getFilhoEsq() == null && node.getFilhoDir() != null) {
                if (node.getO() - node.getPai().getO() <= 0) {
                    node.getPai().setFilhoEsq(node.getFilhoDir());
                    node.getFilhoDir().setPai(node.getPai());
                    atualizaFB((NoAVL) node.getPai(), 2, -1);
                } else {
                    node.getPai().setFilhoDir(node.getFilhoDir());
                    node.getFilhoDir().setPai(node.getPai());
                    atualizaFB((NoAVL) node.getPai(), 2, 1);
                }
                this.tamanho--;
                return node;
            }
            if (node.getFilhoEsq() != null && node.getFilhoDir() == null) {
                if (node.getO() - node.getPai().getO() <= 0) {
                    node.getPai().setFilhoEsq(node.getFilhoEsq());
                    node.getFilhoEsq().setPai(node.getPai());
                    atualizaFB((NoAVL) node.getPai(), 2, -1);
                } else {
                    node.getPai().setFilhoDir(node.getFilhoEsq());
                    node.getFilhoEsq().setPai(node.getPai());
                    atualizaFB((NoAVL) node.getPai(), 2, 1);
                }
                this.tamanho--;
                return node;
            }
            // excluir com dois nós
            NoAVL aux = (NoAVL) node.getFilhoDir();
            while (aux.getFilhoEsq() != null) {
                // percorrer para pegar o menor elemento que obrigatoriamente é um filho esquerdo
                aux = (NoAVL) aux.getFilhoEsq();
                System.out.println("aaaaa" + aux.getFilhoEsq().getO());
            }
            int menorEsquerdo = aux.getO();
            System.out.println(menorEsquerdo);
            int auxfb = aux.getFb();
            remocao(aux, menorEsquerdo);
            node.setO(menorEsquerdo);
            node.setFb(auxfb);
            //this.tamanho--;
            return node;
        }
        return null;
    }

    public void print() {
        int x = altura(this.raiz) + 1, y = this.tamanho, z = 0;
        int matrix[][] = new int[x][y];
        ArrayList<No> nodesContidos = this.nos();

        while (z < y) {
            matrix[this.depth(nodesContidos.get(z))][z] = nodesContidos.get(z).getO();
            z++;
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] != 0) {
                    System.out.println(matrix[i][j] + "--");
                }
                else {
                    System.out.println("--");
                }
            }
            System.out.println("\n");
        }
    }
}
