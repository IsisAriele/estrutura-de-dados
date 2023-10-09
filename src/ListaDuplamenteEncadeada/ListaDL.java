package ListaDuplamenteEncadeada;

public class ListaDL implements Lista{

    private int size;
    private No first, last;

    public ListaDL(){
        this.first = new No(null);
        this.last = new No(null);
        this.size = 0;
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return first.next == null;
    }


    // Verifica se o nó passado é o primeiro
    public boolean isFirst(No n) {
        return n == first.next;
    }

    // verifica se o nó é o último.
    public boolean isLast(No n) {
        return n == last.prev;
    }

    // retorna o primeiro elemento
    public No first() {
        return first.next;
    }

    // retorna o último elemento
    public No last() {
        return last.prev;
    }

    // retorna o elemento do nó antes do nó passado.
    public No before(No n) {
        return n.prev;
    }

    // retorna o elemento do nó depois do nó passado
    public No after(No n) {
        return n.next;
    }

    // substitui o elemento do nó pelo objeto o
    public Object replaceElement(No n, Object o) {
        Object aux = n.elemento;
        n.elemento = o;
        return aux;
    }

    // troca os elementos dos nós n e m.
    public void swapElements(No n, No m) {
        Object aux = n.elemento;
        n.elemento = m.elemento;
        m.elemento = aux;
    }

    // insere o nó antes do nó informado
    public void insertBefore(No n, Object o) {
        No novoNo = new No(o);
        n.prev.next = novoNo;
        novoNo.prev = n.prev;
        n.prev = novoNo;
        novoNo.next = n;
        //verificar se é necessário lançar execeção caso esteja vazio
        size++;
    }

    // insere o nó o após o nó passado.
    public void insertAfter(No n, Object o) {
        No novoNo = new No(o);
        n.next.prev = novoNo;
        novoNo.next = n.next;
        n.next = novoNo;
        novoNo.prev = n;
        size++;
    }

    // insere o nó no inicio da lista.
    public void insertFirst(Object o) {
        No novoNo = new No(o);
        if(first.next == null){
            first.next = novoNo;
            last.prev = novoNo;
            novoNo.prev = first;
            novoNo.next = last;
        } else {
            novoNo.next = first.next;
            novoNo.prev = first;
            first.next.prev = novoNo;
            first.next = novoNo;
        }
        size++;
    }

    //  insere o nó no final da lista.
    public void insertLast(Object o) {
        No novoNo = new No(o);
        if(last.prev == null){
            last.prev = novoNo;
            first.next = novoNo;
            novoNo.prev = first;
            novoNo.next = last;
        } else {
            novoNo.next = last;
            novoNo.prev = last.prev;
            last.prev.next = novoNo;
            last.prev = novoNo;
        }
        size++;
    }

    //  remove o nó passado
    public void remove(No n) {
        n.next.prev = n.prev;
        n.prev.next = n.next;
        n = null;
        size--;
    }

    public void print() {
        No atual = first;
        while (atual != null){
            System.out.print(atual.elemento);
            System.out.print(" ");
            atual = atual.next;
        }
        System.out.println();
    }
}
