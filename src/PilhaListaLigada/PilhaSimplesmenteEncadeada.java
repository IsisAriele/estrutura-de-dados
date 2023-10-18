package PilhaListaLigada;

public class PilhaSimplesmenteEncadeada {
    private No inicio;   // Referência para o primeiro nó da fila
    private int tamanho; // Tamanho da fila

    // Construtor e inicializações
    public PilhaSimplesmenteEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // push insere um elemento no inicio da pilha
    public void push(Object elemento) {
        No novoNo = new No(elemento); // Instancia novo nó
        if (inicio == null) {
            inicio = novoNo; // Condição pilha vazia
        } else {
            No temp = inicio;
            inicio = novoNo;
            inicio.proximo = temp;
        }
        tamanho++;
    }

    // pop remove e retorna o ultimo elemento da pilha, ou seja, no inicio
    public Object pop() {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia");
        } else {
            No temp = inicio;
            inicio = inicio.proximo;
            tamanho--;
            return temp;
        }

    }

    // Retorna o último elemento da pilha
    public Object top() {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia");
        } else {
            return inicio.elemento;
        }
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public int size() {
        return tamanho;
    }

    public void imprimirLista() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}
