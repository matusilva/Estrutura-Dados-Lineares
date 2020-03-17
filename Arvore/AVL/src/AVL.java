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

            // perguntar ao professor sobre a rotacao dupla
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
    public void atualizaFB(NoAVL no, String op, int nodefb) {
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

        if (op.equals("i")) {
            // opcao i = inserir
            if (no.getPai() != null && no.getFb() != 0) {
                if (no.getO() < no.getPai().getO()) {
                    atualizaFB((NoAVL) no.getPai(), op, 1);
                }
                else {
                    atualizaFB((NoAVL) no.getPai(), op, -1);
                }
            }
        }
        else if (op.equals("r")) {
            // opcao r = remover
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
        if (this.raiz == null) {
            this.setRaiz(node);
            this.tamanho++;
        }
        else {
            NoAVL nodePai = (NoAVL) buscar(o, getRaiz());
            if (nodePai.getO() == node.getO()) {
                System.out.println("Elemento já Existe");
            }
            else if (node.getO() < nodePai.getO()) {
                nodePai.setFilhoEsq(node);
                node.setPai(nodePai);
                this.tamanho++;
                // node inserido a esquerda do pai novo
                atualizaFB(nodePai, "i", 1);
            }
            else if (node.getO() > nodePai.getO()) {
                nodePai.setFilhoDir(node);
                node.setPai(nodePai);
                this.tamanho++;
                // node inserido a direita de novo
                atualizaFB(nodePai, "i", -1);
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
                    atualizaFB((NoAVL) node.getPai(), "r", -1);
                } else {
                    node.getPai().setFilhoDir(null);
                    atualizaFB((NoAVL) node.getPai(), "r", 1);
                }
                this.tamanho--;
                return node;
            }

            // excluir no com um filho
            if (node.getFilhoEsq() == null && node.getFilhoDir() != null) {
                if (node.getO() - node.getPai().getO() <= 0) {
                    node.getPai().setFilhoEsq(node.getFilhoDir());
                    node.getFilhoDir().setPai(node.getPai());
                    atualizaFB((NoAVL) node.getPai(), "r", -1);
                } else {
                    node.getPai().setFilhoDir(node.getFilhoDir());
                    node.getFilhoDir().setPai(node.getPai());
                    atualizaFB((NoAVL) node.getPai(), "r", 1);
                }
                this.tamanho--;
                return node;
            }
            if (node.getFilhoEsq() != null && node.getFilhoDir() == null) {
                if (node.getO() - node.getPai().getO() <= 0) {
                    node.getPai().setFilhoEsq(node.getFilhoEsq());
                    node.getFilhoEsq().setPai(node.getPai());
                    atualizaFB((NoAVL) node.getPai(), "r", -1);
                } else {
                    node.getPai().setFilhoDir(node.getFilhoEsq());
                    node.getFilhoEsq().setPai(node.getPai());
                    atualizaFB((NoAVL) node.getPai(), "r", 1);
                }
                this.tamanho--;
                return node;
            }
            // excluir com dois nós
            NoAVL aux = (NoAVL) node.getFilhoDir();
            while (aux.getFilhoEsq() != null) {
                // percorrer para pegar o menor elemento que obrigatoriamente é um filho esquerdo
                aux = (NoAVL) aux.getFilhoEsq();
                //System.out.println("aaaaa" + aux.getFilhoEsq().getO());
            }
            int menorEsquerdo = aux.getO();
            System.out.println("menor esquerdo " + menorEsquerdo);
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
        String matrix[][] = new String[x][y];

        ArrayList<No> nodesContidos = this.nos();
        int fb;
        while (z < y) {
            fb = ((NoAVL) nodesContidos.get(z)).getFb();
            matrix[this.depth(nodesContidos.get(z))][z] = nodesContidos.get(z).getO() + "[" +  fb + "]";
            z++;
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] != null) {
                    System.out.print(matrix[i][j] + "  ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println("\n");
        }
    }
}