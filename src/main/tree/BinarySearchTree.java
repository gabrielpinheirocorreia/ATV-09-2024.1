package main.tree;

import main.estrut.Tree;

public class BinarySearchTree implements Tree {

    private No cabeca;

    public BinarySearchTree() {
        cabeca = null;
    }

    @Override
    public boolean buscaElemento(int valor) {
        return buscaElementoRecursivo(cabeca, valor);
    }

    private boolean buscaElementoRecursivo(No no, int valor) {
        if (no == null)
            return false;

        if (valor == no.getValor())
            return true;

        if (valor < no.getValor())
            return buscaElementoRecursivo(no.getEsquerdaNo(), valor);
        else
            return buscaElementoRecursivo(no.getDireitaNo(), valor);
    }

    @Override
    public int minimo() {
        if (cabeca == null)
            throw new IllegalStateException("Árvore vazia");

        No n = cabeca;
        while (n.getEsquerdaNo() != null) {
            n = n.getEsquerdaNo();
        }
        return n.getValor();
    }

    @Override
    public int maximo() {
        if (cabeca == null)
            throw new IllegalStateException("Árvore vazia");

        No n = cabeca;
        while (n.getDireitaNo() != null) {
            n = n.getDireitaNo();
        }
        return n.getValor();
    }

    @Override
    public void insereElemento(int valor) {
        cabeca = insereElementoRecursivo(cabeca, valor);
    }

    private No insereElementoRecursivo(No no, int valor) {
        if (no == null)
            return new No(valor);

        if (valor < no.getValor())
            no.setEsquerdaNo(insereElementoRecursivo(no.getEsquerdaNo(), valor));
        else if (valor > no.getValor())
            no.setDireitaNo(insereElementoRecursivo(no.getDireitaNo(), valor));

        return no;
    }

    @Override
    public void remove(int valor) {
        cabeca = removeRecursivo(cabeca, valor);
    }

    private No removeRecursivo(No no, int valor) {
        if (no == null)
            return null;

        if (valor == no.getValor()) {
            // Caso 1: nó sem filhos
            if (no.getEsquerdaNo() == null && no.getDireitaNo() == null)
                return null;

            // Caso 2: nó com um filho
            if (no.getDireitaNo() == null)
                return no.getEsquerdaNo();
            if (no.getEsquerdaNo() == null)
                return no.getDireitaNo();

            // Caso 3: nó com dois filhos
            int menorValor = minimoRecursivo(no.getDireitaNo());
            no.setValor(menorValor);
            no.setDireitaNo(removeRecursivo(no.getDireitaNo(), menorValor));
            return no;
        }

        if (valor < no.getValor()) {
            no.setEsquerdaNo(removeRecursivo(no.getEsquerdaNo(), valor));
            return no;
        }

        no.setDireitaNo(removeRecursivo(no.getDireitaNo(), valor));
        return no;
    }

    private int minimoRecursivo(No no) {
        if (no.getEsquerdaNo() == null)
            return no.getValor();
        return minimoRecursivo(no.getEsquerdaNo());
    }

    @Override
    public int[] preOrdem() {
        return preOrdemRecursivo(cabeca);
    }

    private int[] preOrdemRecursivo(No no) {
        if (no == null)
            return new int[]{};
    
        int[] result = new int[contaNos(no)];
        int index = 0;
        result[index++] = no.getValor();
        int[] esquerda = preOrdemRecursivo(no.getEsquerdaNo());
        for (int valor : esquerda) {
            result[index++] = valor;
        }
        int[] direita = preOrdemRecursivo(no.getDireitaNo());
        for (int valor : direita) {
            result[index++] = valor;
        }
        return result;
    }

    @Override
    public int[] emOrdem() {
        return emOrdemRecursivo(cabeca);
    }

    private int[] emOrdemRecursivo(No no) {
        if (no == null)
            return new int[]{};

        int[] result = new int[contaNos(no)];
        int index = 0;
        int[] esquerda = emOrdemRecursivo(no.getEsquerdaNo());
        for (int valor : esquerda) {
            result[index++] = valor;
        }
        result[index++] = no.getValor();
        int[] direita = emOrdemRecursivo(no.getDireitaNo());
        for (int valor : direita) {
            result[index++] = valor;
        }
        return result;
    }

    @Override
    public int[] posOrdem() {
        return posOrdemRecursivo(cabeca);
    }

    private int[] posOrdemRecursivo(No no) {
        if (no == null)
            return new int[]{};

        int[] result = new int[contaNos(no)];
        int index = 0;
        int[] esquerda = posOrdemRecursivo(no.getEsquerdaNo());
        for (int valor : esquerda) {
            result[index++] = valor;
        }
        int[] direita = posOrdemRecursivo(no.getDireitaNo());
        for (int valor : direita) {
            result[index++] = valor;
        }
        result[index++] = no.getValor();
        return result;
    }

    private int contaNos(No no) {
        if (no == null)
            return 0;
        return contaNos(no.getEsquerdaNo()) + contaNos(no.getDireitaNo()) + 1;
    }
}
