package HEAP;

public class Node {
    private Node parent;
    private Object key;
    private Object value;
    private Node leftChild;
    private Node rightChild;

    public Node(Node parent, Object key) {
        this.parent = parent;
        this.key = key;
        this.value = key;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setKey(Object key) {
        this.key = key;
        this.value = key;
    }

    public void setLeftChild(Node node) {
        this.leftChild = node;
    }

    public void setRightChild(Node node) {
        this.rightChild = node;
    }
    private boolean externo(Node no) {
        return no.getLeftChild() == null && no.getRightChild() == null;
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

    public boolean interno() {
        return this.hasLeftChild() || this.hasRightChild();

    }
    public boolean externo() {
        return !this.interno();

    }
    @Override
    public String toString() {
        return String.format("No<%s>", key.toString());
    }
}
