public interface IAVL {
    public void rotacaoSimplesEsq(NoAVL no);
    public void rotacaoSimplesDir(NoAVL no);
    public void atualizaFB(NoAVL no, String op, int nodefb);
    public void print();
}