package ListaArray;
public interface Lista {
    public int size();
    public boolean isEmpty();
    public boolean isFirst(Object o);
    public boolean isLast(Object o);
    public Object first();
    public Object last();
    public Object before(int n);
    public Object after(int n);
    public Object replaceElement(int n, Object o);
    public void swapElements(int n, int m);
    public void insertBefore(int n, Object o);
    public void insertAfter(int n, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public void remove(int n);
}
