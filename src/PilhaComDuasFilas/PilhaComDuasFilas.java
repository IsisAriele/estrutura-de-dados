package PilhaComDuasFilas;

public class PilhaComDuasFilas implements PilhaComDuasFilasInterface {
    private int inicio = 0;
    private int fim = 0;
    private int capacidade;
    private Object[] filaEntrada; // Fila principal usada para inserção e acesso
    private Object[] filaSaida; // Fila auxiliar usada na remoção de elementos

    public PilhaComDuasFilas(int capacidade) {
        this.capacidade = capacidade;
        this.filaEntrada = new Object[capacidade];
        this.filaSaida = new Object[capacidade];
    }

    @Override
    public void push(Object elemento) {
        if (size() == (capacidade - 1)) { // Verifica se a fila está cheia
            aumentaCapacidade();
        }
        filaEntrada[fim] = elemento;
        fim = (fim + 1) % capacidade;
    }

    public void aumentaCapacidade() {
        int novaCapacidade;
        novaCapacidade = capacidade * 2;
        Object[] novaFila = new Object[novaCapacidade];

        int inicioOriginal = inicio;
        for (int i = 0; i < size(); i++) {
            novaFila[i] = filaEntrada[inicioOriginal];
            inicioOriginal = (inicioOriginal + 1) % capacidade;
        }
        // Atualizações
        fim = size();
        inicio = 0;
        capacidade = novaCapacidade;
        filaEntrada = novaFila;
        // Atualiza nova capacidade de filaSaida
        Object[] novaFilaSaida = new Object[novaCapacidade];
        filaSaida = novaFilaSaida;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        // Invertendo a fila
        transferirFilaEntradaParaFilaSaida();
        // Dequeue
        Object temp = filaSaida[fim + 1];
        fim = (fim + 1) % capacidade;
        //Desinvertendo a fila
        transferirFilaSaidaParaFilaEntrada();
        return temp;
    }

    @Override
    public void transferirFilaEntradaParaFilaSaida() {
        while (fim >= 0) {
            filaSaida[fim] = filaEntrada[inicio];
            inicio++;
            fim--;
        }
        inicio--;
        fim++;
    }

    @Override
    public void transferirFilaSaidaParaFilaEntrada() {
        while (fim <= size()) {
            filaEntrada[inicio] = filaSaida[fim];
            inicio--;
            fim++;
        }
        inicio++;
        fim--;
    }

    @Override
    public Object top() {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        return filaEntrada[fim - 1];
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
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        for (int i = inicio; i != fim; i = (i + 1) % capacidade) {
            System.out.print(filaEntrada[i] + " ");
        }
        System.out.println();
    }
}
