package main.tree;

public class No {
    
    private int valor;
    private No esquerdaNo;
    private No direitaNo;
    private No anterior;

    public No(int valor) {
        this.valor = valor;
        this.anterior = null;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getAnterior() {
        return this.anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getEsquerdaNo() {
        return this.esquerdaNo;
    }

    public void setEsquerdaNo(No esquerdaNo) {
        this.esquerdaNo = esquerdaNo;
    }

    public No getDireitaNo() {
        return this.direitaNo;
    }

    public void setDireitaNo(No direitaNo) {
        this.direitaNo = direitaNo;
    }
}