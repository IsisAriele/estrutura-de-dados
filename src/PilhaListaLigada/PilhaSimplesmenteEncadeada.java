package PilhaListaLigada;

public class PilhaSimplesmenteEncadeada {
    private No inicio;   // Referência para o primeiro nó da fila
    private int tamanho; // Tamanho da fila

    // Construtor e inicializações
    public PilhaSimplesmenteEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // push insere um elemento no fim da pilha
    public void push(Object elemento) {
        No novoNo = new No(elemento); // Instancia novo nó
        if (inicio == null) {
            inicio = novoNo; // Condição pilha vazia
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo; // Encontra o último nó da fila
            }
            atual.proximo = novoNo; // Define o próximo do último nó (null) como o novo nó
        }
        tamanho++;
    }

    // pop remove e retorna o ultimo elemento da pilha
    public Object pop() {
        No temp;

        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A fila está vazia");
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo; // Vai até o ultimo nó
            }
            temp = atual;
            atual = null; // Remove o último nó
        }
        tamanho--;
        return temp;
    }

    // Retorna o último elemento da pilha
    public Object top() {
        No temp;

        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A fila está vazia");
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo; // Vai até o ultimo nó
            }
            temp = atual;
        }
        return temp;
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
