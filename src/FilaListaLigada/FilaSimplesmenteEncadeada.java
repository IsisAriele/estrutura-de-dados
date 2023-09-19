package FilaListaLigada;

public class FilaSimplesmenteEncadeada {
    private No inicio; // Referência para o primeiro nó da fila
    private int tamanho; // Tamanho da fila

    //Construtor com inicializações da fila
    public FilaSimplesmenteEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // enqueue realiza inserção no fim
    public void enqueue(Object elemento) {
        No novoNo = new No(elemento); // Instância do novo nó
        if (inicio == null) {
            inicio = novoNo; // Se a fila estiver vazia, o novo nó se torna o início
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo; // Encontra o último nó da fila
            }
            atual.proximo = novoNo; // Define o próximo do último nó (o null) como o novo nó
        }
        tamanho++;
    }

    // dequeue retorna e remove o elemento do início da fila
    public Object dequeue() {
        if (isEmpty()) {
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        No temp = inicio;
        inicio = inicio.proximo; // Remove o primeiro nó atualizando o início
        tamanho--; // Decrementa o tamanho da fila
        return temp;
    }

    // indica se há elementos na fila
    public boolean isEmpty() {
        return inicio == null;
    }

    // first retorna o elemento do início
    public Object first() {
        if (isEmpty()) {
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        return inicio;
    }

    public int size() {
        return tamanho;
    }

    public void imprimirFila() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}
