package Fila;

public class Fila implements FilaInterface {
    private int inicio = 0;
    private int fim = 0;
    private int capacidade;
    private int incremento;
    private Object[] elementos;

    public Fila(int capacidade, int incremento) {
        this.capacidade = capacidade;
        this.incremento = incremento;
        this.elementos = new Object[capacidade];
    }

    @Override
    public void enqueue(Object elemento) {
        if (size() == (capacidade - 1)) { // Fila está cheia
            int novaCapacidade;
            if (incremento == 0) {
                novaCapacidade = capacidade * 2;
            } else {
                novaCapacidade = capacidade + incremento;
            }
            Object[] novoArray = new Object[novaCapacidade];

            int inicioOriginal = inicio;

            for (int i = 0; i < size(); i++) {
                novoArray[i] = elementos[inicioOriginal];
                inicioOriginal = (inicioOriginal + 1) % capacidade;
            }
            // Atualizações
            fim = size();
            inicio = 0;
            capacidade = novaCapacidade;
            elementos = novoArray;
        }
        elementos[fim] = elemento;
        fim = (fim + 1) % capacidade;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        Object elementoRemovido = elementos[inicio];
        inicio = (inicio + 1) % capacidade;
        return elementoRemovido;
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        return elementos[inicio];
    }

    @Override
    public int size() {

        return (capacidade - inicio + fim) % capacidade;
    }

    @Override
    public boolean isEmpty() {
        return inicio == fim;
    }

    public void listar() {
        if (isEmpty()) {
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        for (int i = inicio; i != fim; i = (i + 1) % capacidade) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}
