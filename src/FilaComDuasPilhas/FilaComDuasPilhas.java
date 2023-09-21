package FilaComDuasPilhas;

import Pilha.PilhaVaziaExcecao;

public class FilaComDuasPilhas implements FilaComDuasPilhasInterface {
    private int indiceFinal = -1;
    private int indiceTopo = -1;
    private int capacidade;
    private Object[] pilhaEntrada;
    private Object[] pilhaSaida;

    public FilaComDuasPilhas(int capacidade) {
        this.capacidade = capacidade;
        this.pilhaEntrada = new Object[capacidade];
        this.pilhaSaida = new Object[capacidade];
    }

    // Inserir elemento no fim da fila
    @Override
    public void enqueue(Object elemento) {
        if (indiceTopo == capacidade -1){ //pilha vazia
            int capacidadeAntiga = capacidade;
            capacidade *= 2;
            Object[] novaLista = new Object[capacidade];
            for(int i = 0; i <= indiceTopo; i++) {
                novaLista[i] = pilhaEntrada[i];
            }
            pilhaEntrada = novaLista;
        }
        indiceTopo += 1;
        pilhaEntrada[indiceTopo] = elemento;
        System.out.println(elemento);
    }

    // Remover elemento do início da fila
    @Override
    public Object dequeue() {
        if (isEmpty()){
            throw new FilaVaziaExcecao("A pilha está vazia!");
        } else if (pilhaSaidaIsEmpty()){
            transferirPilhaEntradaParaPilhaSaida();
        }
        indiceTopo++;
        Object temp = pilhaSaida[indiceFinal];
        pilhaSaida[indiceFinal] = null;
        indiceFinal--;
        return temp;
    }

    @Override
    public boolean pilhaSaidaIsEmpty() {
        return indiceFinal == -1;
    }

    @Override
    public void transferirPilhaEntradaParaPilhaSaida() {
        while(indiceTopo >= 0){
            indiceFinal++;
            pilhaSaida[indiceFinal] = pilhaEntrada[indiceTopo];
            indiceTopo--;
        }
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new FilaVaziaExcecao("A fila está vazia!");
        }
        if (pilhaSaidaIsEmpty()) {
            transferirPilhaEntradaParaPilhaSaida();
        }
        return pilhaSaida[indiceFinal];
    }

    @Override
    public int size() {
        return indiceTopo + 1;
    }

    @Override
    public boolean isEmpty() {
        return indiceTopo == -1;
    }

    public void listar() {
        if (isEmpty()) {
            throw new Fila.FilaVaziaExcecao("A fila está vazia");
        }

        // Use a pilha de saída para listar os elementos na ordem correta
        for (int i = indiceFinal; i >= 0; i--) {
            System.out.print(pilhaSaida[i] + " ");
        }

        System.out.println("rapaz");
    }
}
