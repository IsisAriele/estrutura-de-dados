package ArvoreRB;

public class NoRB {
    private char cor;
    private Object key;
    private NoRB parent;
    private NoRB leftChild;
    private NoRB rightChild;

    public NoRB(NoRB pai, Object k) {
        parent = pai;
        key = k;
        cor = 'n';
        leftChild = null; // Filho esquerdo inicializado como nó externo preto
        rightChild = null; // Filho direito inicializado como nó externo preto
    }

    public char getCor() {
        return cor;
    }

    public void setCor(char cor) {
        this.cor = cor;
    }

    public Object getKey() {
        return key;
    }
    public NoRB getParent() {
        return parent;
    }
    public NoRB getLeftChild() {
        return leftChild;
    }
    public NoRB getRightChild() {
        return rightChild;
    }
    public void setKey(Object k) {
        key = k;
    }
    public void setParent(NoRB p) {
        parent = p;
    }
    public void setLeftChild(NoRB n) {
        leftChild = n;
    }
    public void setRightChild(NoRB n) {
        rightChild = n;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }
    public boolean hasRightChild() {
        return this.rightChild != null;
    }
    public boolean hasParent() {
        return this.parent != null;
    }
    public boolean isInternal() {
        return this.hasLeftChild() || this.hasRightChild();
    }
    public boolean isExternal() {
        return !this.isInternal();
    }

    @Override
    public String toString() {
        return String.format("NoRB<%s>", key.toString());
    }
}
