package Fila;

public interface FilaInterface {
    public abstract void enqueue(Object elemento);
    public abstract Object dequeue();
    public abstract Object first();
    public abstract int size();
    public abstract boolean isEmpty();
}
