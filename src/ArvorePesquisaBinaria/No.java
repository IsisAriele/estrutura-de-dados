package ArvorePesquisaBinaria;

public class No {
    private Object key;
    private No parent;
    private No leftChild;
    private No rightChild;
    public No(No pai, Object k) {
        parent = pai;
        key = k;
    }

    public Object getKey() {
        return key;
    }
    public No getParent() {
        return parent;
    }
    public No getLeftChild() {
        return leftChild;
    }
    public No getRightChild() {
        return rightChild;
    }
    public void setKey(Object k) {
        key = k;
    }
    public void setParent(No p) {
        parent = p;
    }
    public void setLeftChild(No n) {
        leftChild = n;
    }
    public void setRightChild(No n) {
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
        return String.format("No<%s>", key.toString());
    }
}
