package SequenciaListaDL;

public interface Sequencia {
    // Métodos de vetor
    public Object elemAtRank(int r);
    public Object replaceAtRank(int r, Object o);
    public void insertAtRank(int r, Object o);
    public Object removeAtRank(int r);

    // Métodos de lista
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

    // Métodos ponte
    public No atRank(int rank);
    public int rankOf(No n);

    // Métodos de sequência
    public void print();
    public int size();
    public boolean isEmpty();

}
