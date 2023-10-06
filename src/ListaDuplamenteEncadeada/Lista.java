package ListaDuplamenteEncadeada;
public interface Lista {
    public int size();
    public boolean isEmpty();
    public boolean isFirst(No n);
    public boolean isLast(No n);
    public No first();
    public No last();
    public No before(No n);
    public No after(No n);
    public Object replaceElement(No n, Object o);
    public void swapElements(No n, No m);
    public void insertBefore(No n, Object o);
    public void insertAfter(No n, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public void remove(No n);
}
