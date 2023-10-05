package ListaDuplamenteEncadeada;

public class No {
    public Object elemento;
    public No next, prev;

    public No(Object elemento) {
        this.elemento = elemento;
        this.next = null;
        this.prev = null;
    }
}
