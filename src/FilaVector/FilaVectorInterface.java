package FilaVector;

public interface FilaVectorInterface {
    public abstract void enqueue(Object o);
    public abstract Object dequeue();
    public abstract Object first();
    public abstract int size();
    public abstract boolean isEmpty();
}
