package SequenciaListaDL;

public class SequenciaLD  implements Sequencia{
    private int size;
    private No first, last;

    public SequenciaLD(){
        this.first = new No(null);
        this.last = new No(null);
        this.size = 0;
    }

    // Métodos do vetor ----------------------------------------------

    // Retorna o elemento na colocação r
    public Object elemAtRank(int r) {
        No atual = first.next;
        for (int i = 0; i < r; i++) {
            atual = atual.next;
        }
        return atual.elemento;
    }

    // Substitui o elemento na colocação r por o e retorna o antigo elemento
    public Object replaceAtRank(int r, Object o) {
        if(r > size){
            throw new SequenciaExcecao("Não é possível inserir um elemento numa posição que é maior que o número de elementos atual da lista");
        }
        No atual = first.next;
        for (int i = 0; i < r; i++) {
            atual = atual.next;
        }
        Object aux = atual.elemento;
        atual.elemento = o;
        return aux;
    }

    // Insere um novo elemento na colocação r
    public void insertAtRank(int r, Object o) {
        No novoNo = new No(o);
        No antigoNo = first.next;
        if(r > size){
            throw new SequenciaExcecao("Não é possível inserir um elemento numa posição que é maior que o número de elementos atual da lista");
        }
        if(first.next == null){
            first.next = novoNo;
            last.prev = novoNo;
            novoNo.prev = first;
            novoNo.next = last;
        } else if (r == 0){
            novoNo.next = antigoNo;
            novoNo.prev = first;
            antigoNo.prev = novoNo;
            first.next = novoNo;
        } else {
            for (int i = 0; i < r; i++) {
                antigoNo = antigoNo.next;
            }
            novoNo.prev = antigoNo.prev;
            novoNo.next = antigoNo;
            antigoNo.prev.next = novoNo;
            antigoNo.prev = novoNo;
        }
        size++;
    }

    // Remove e retorna o elemento na posição r
    public Object removeAtRank(int r) {
        No antigoNo = first.next;
        Object elemento;
        if(r > size){
            throw new SequenciaExcecao("Não é possível remover um elemento numa posição que é maior que o número de elementos atual da lista");
        }
        if(isEmpty()){
            throw new SequenciaExcecao("Vetor já esta vazio");
        }
        if(r == 0){
            elemento = antigoNo.elemento;
            antigoNo.next.prev = first;
            first.next = antigoNo.next;
        } else {
            for (int i = 0; i < r; i++) {
                antigoNo = antigoNo.next;
            }
            antigoNo.prev.next = antigoNo.next;
            antigoNo.next.prev = antigoNo.prev;
            elemento = antigoNo.elemento;
        }
        size--;
        return elemento;
    }

    // Métodos de lista ----------------------------------------------

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
        // verificar execção caso sequencia esteja vazia
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

    // Remove o nó passado
    public void remove(No n) {
        n.next.prev = n.prev;
        n.prev.next = n.next;
        n = null;
        size--;
    }

    // Métodos ponte ----------------------------------------------

    // Acessar um nó em uma sequência com base em sua posição
    public No atRank(int r) {
        No atual;
        if(r <= size / 2){
            atual = first.next;
            for (int i = 0; i < r; i++) {
                atual = atual.next;
            }
        } else{
            atual = last.prev;
            for (int i = 0; i < size - r -1 ; i++) {
                atual = atual.prev;
            }
        }
        return atual;
    }

    // determina a posição de um nó específico na sequência.
    public int rankOf(No n) {
        No atual = first.next;
        int r = 0;
        while (atual != n && atual != null){
            atual = atual.next;
            r++;
        }
        return r;
    }

    // Métodos sequência ----------------------------------------------
    public void print() {
        No atual = first;
        while (atual != null){
            System.out.print(atual.elemento);
            System.out.print(" ");
            atual = atual.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first.next == null;
    }

}
