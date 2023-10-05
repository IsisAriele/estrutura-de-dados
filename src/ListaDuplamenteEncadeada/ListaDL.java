package ListaDuplamenteEncadeada;

import ListaArray.ListaExcecao;
import VetorListaDuplamenteEncadeada.No;

public class ListaDL implements Lista{

    private int size;
    private No first, last;

    public ListaDL(){
        this.first = new No(null);
        this.last = new No(null);
        this.size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first.next == null;
    }

    // verifica se o elemento na posição n é o primeiro - for
    // Verifica se o objeto passado é o primeiro - first.next.elemento
    @Override
    public boolean isFirst(int n) {
        // se for necesssario apenas comparar o valor passado no lugar do indice é mais facil
        return false;
    }

    // verifica se o elemento na posição n é o último.
    @Override
    public boolean isLast(int n) {
        return false;
    }

    // retorna o primeiro elemento
    @Override
    public Object first() {
        return first.next.elemento;
    }

    // retorna o último elemento
    @Override
    public Object last() {
        return last.prev.elemento;
    }

    // retorna o elemento antes do elemento na posição n.
    @Override
    public Object before(int n) {
        No atual = first.next;
        for (int i = 0; i < n - 1; i++) {
            atual = atual.next;
        }
        return atual.elemento;
    }

    // retorna o elemento depois do elemento na posição n
    @Override
    public Object after(int n) {
        No atual = first.next;
        for (int i = 0; i < n + 1; i++) {
            atual = atual.next;
        }
        return atual.elemento;
    }

    // substitui o elemento na posição n pelo objeto o
    @Override
    public Object replaceElement(int n, Object o) {
        No atual = first.next;
        for (int i = 0; i < n; i++) {
            atual = atual.next;
        }
        Object aux = atual.elemento;
        atual.elemento = o;
        return aux;
    }

    // troca os elementos nas posições n e m.
    @Override
    public void swapElements(int n, int m) {
        No primeiroNo = first.next;
        for (int i = 0; i < n; i++) {
            primeiroNo = primeiroNo.next;
        }
        Object aux = primeiroNo.elemento;
        No segundoNo = first.next;
        for (int i = 0; i < m; i++) {
            segundoNo = segundoNo.next;
        }
        primeiroNo.elemento = segundoNo.elemento;
        segundoNo.elemento = aux;
    }

    // insere o objeto o antes do elemento na posição n
    @Override
    public void insertBefore(int n, Object o) {
        No atual = first.next;
        No novoNo = new No(o);
        if(n > size + 1){
            throw new ListaExcecao("Índice informado ultrapassa os limites da lista");
        }
        if(isEmpty()){
            System.out.println("Lista vazia, elemento inserido no primeiro nó da lista");
            novoNo.prev = first;
            novoNo.next = last;
            first.next = novoNo;
            last.prev = novoNo;
        } else{
            for (int i = 0; i < n - 1; i++) {
                atual = atual.next;
            }
            atual.prev.next = novoNo;
            novoNo.prev = atual.prev;
            atual.prev = novoNo;
            novoNo.next = atual;
        }
        size++;
    }

    // insere o objeto o após o elemento na posição n.
    @Override
    public void insertAfter(int n, Object o) {
        No atual = first.next;
        No novoNo = new No(o);
        if(n > size - 1){
            throw new ListaExcecao("Índice informado ultrapassa os limites da lista");
        }
        if(isEmpty()) {
            System.out.println("Lista vazia, elemento inserido no primeiro nó da lista");
            novoNo.prev = first;
            novoNo.next = last;
            first.next = novoNo;
            last.prev = novoNo;
        } else {
            for (int i = 0; i < n + 1; i++) {
                atual = atual.next;
            }
            atual.prev.next = novoNo;
            novoNo.prev = atual.prev;
            atual.prev = novoNo;
            novoNo.next = atual;
        }
        size++;
    }

    // insere o objeto o no início da lista.
    @Override
    public void insertFirst(Object o) {

    }

    //  insere o objeto o no final da lista.
    @Override
    public void insertLast(Object o) {

    }

    //  remove o elemento na posição n da lista.
    @Override
    public void remove(int n) {

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
