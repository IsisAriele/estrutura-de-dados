package VetorListaDuplamenteEncadeada;

public class VetorListaDuplamenteEncadeada {
    private int size;
    private No first, last;

    public VetorListaDuplamenteEncadeada(){
        this.first = new No(null);
        this.last = new No(null);
        this.size = 0;
    }

    // Retorna o elemento na colocação r
    public Object elemAtRank(int r){
        No atual = first.next;
        for (int i = 0; i < r; i++) {
            atual = atual.next;
        }
        return atual.elemento;
    }

    // Substitui o elemento na colocação r por o e retorna o antigo elemento
    public Object replaceAtRank(int r, Object o){
        if(r > size){
            throw new VetorExcecao("Não é possível inserir um elemento numa posição que é maior que o número de elementos atual da lista");
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
    public void insertAtRank(int r, Object o){
        No novoNo = new No(o);
        No antigoNo = first.next;
        if(r > size){
            throw new VetorExcecao("Não é possível inserir um elemento numa posição que é maior que o número de elementos atual da lista");
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
    public Object removeAtRank(int r){
        No antigoNo = first.next;
        Object elemento;
        if(r > size){
            throw new VetorExcecao("Não é possível remover um elemento numa posição que é maior que o número de elementos atual da lista");
        }
        if(isEmpty()){
            throw new VetorExcecao("Vetor já esta vazio");
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

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return first.next == null;
    }

    public void print() {
        No atual = first;
        while (atual != null){
            System.out.print(atual.elemento);
            System.out.print(" ");
            atual = atual.next;
        }
    }
}
