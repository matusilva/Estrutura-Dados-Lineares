public class No
{
    private int o;
    private No pai;
    private No filhoEsq;
    private No filhoDir;

    public No(int o)
    {
        this.o = o;
    }

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getFilhoEsq() {
        return filhoEsq;
    }

    public void setFilhoEsq(No filhoEsq) {
        this.filhoEsq = filhoEsq;
    }

    public No getFilhoDir() {
        return filhoDir;
    }

    public void setFilhoDir(No filhoDir) {
        this.filhoDir = filhoDir;
    }
}