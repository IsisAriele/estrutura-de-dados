package FilaListaLigada;

public class FilaSimplesmenteEncadeada {
    private No inicio; // Referência para o primeiro nó da fila
    private No fim;
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
            fim = novoNo; // Armazeno esse primeiro no em fim para ser acessado na remoção.
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
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
        return inicio.elemento;
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
