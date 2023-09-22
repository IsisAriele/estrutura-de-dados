package FilaComDuasPilhas;

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
        // Aumenta capacidade se necessário
        if (indiceTopo == capacidade -1){ //pilha vazia
           aumentaCapacidade();
        }
        // PUSH
        indiceTopo += 1;
        pilhaEntrada[indiceTopo] = elemento;
        System.out.println(elemento);
    }

    public void aumentaCapacidade(){
        capacidade *= 2;
        Object[] novaLista = new Object[capacidade];
        for(int i = 0; i <= indiceTopo; i++) {
            novaLista[i] = pilhaEntrada[i];
        }
        pilhaEntrada = novaLista;
        //Aumentando também a capacidade da pilha saída
        Object[] novaListaSaida = new Object[capacidade];
        pilhaSaida = novaListaSaida;
    }

    // Remover elemento do início da fila
    @Override
    public Object dequeue() {
        if (isEmpty()){
            throw new FilaVaziaExcecao("A fila está vazia!");
        }
        // Invertendo a pilha
        transferirPilhaEntradaParaPilhaSaida();
        // POP
        Object temp = pilhaSaida[indiceFinal];
        pilhaSaida[indiceFinal] = null;
        indiceFinal--;
        // "Desinvertendo" a pilha
        transferirPilhaSaidaParaPilhaEntrada();
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return indiceTopo == -1;
    }

    @Override
    public void transferirPilhaEntradaParaPilhaSaida() {
        while(indiceTopo >= 0){
            indiceFinal++;
            pilhaSaida[indiceFinal] = pilhaEntrada[indiceTopo];
            indiceTopo--;
        }
        indiceTopo++;
    }

    public void transferirPilhaSaidaParaPilhaEntrada(){
        while(indiceFinal >=0){
            pilhaEntrada[indiceTopo] = pilhaSaida[indiceFinal];
            indiceTopo++;
            indiceFinal--;
        }
        indiceTopo--;
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new FilaVaziaExcecao("A fila está vazia!");
        }
        return pilhaEntrada[indiceFinal + 1]; // Após a última transferência para pilha entrada, indice final fica -1.
    }

    @Override
    public int size() {
        return indiceTopo + 1;
    }

    public void listar() {
        if (isEmpty()) {
            throw new Fila.FilaVaziaExcecao("A fila está vazia");
        }
        // Use a pilha de saída para listar os elementos na ordem correta
        for (int i = 0; i <= indiceTopo; i++) {
            System.out.print(pilhaEntrada[i] + " ");
        }
        System.out.println();
    }
}
