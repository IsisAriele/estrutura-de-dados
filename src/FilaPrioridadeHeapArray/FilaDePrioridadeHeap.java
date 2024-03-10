package FilaPrioridadeHeapArray;
public class FilaDePrioridadeHeap {

    // Variáveis que guardam informações sobre nossa fila de prioridade
    private int[] heap;        // Um monte de números organizados
    private int tamanho;        // Quantos números temos na fila agora
    private int capacidade;     // Quantos números podemos ter no máximo

    // Quando criamos uma fila, decidimos o máximo de números que ela pode ter
    public FilaDePrioridadeHeap(int capacidade) {
        this.capacidade = capacidade;     // Dizemos à fila quantos números ela pode ter
        this.tamanho = 0;                 // No começo, não temos nenhum número
        this.heap = new int[capacidade];  // Preparamos um lugar para guardar os números
    }

    // Adicionamos um número à nossa fila
    public void inserir(int elemento) {
        // Verificamos se a fila já está cheia
        if (tamanho == capacidade) {
            System.out.println("A fila de prioridade está cheia.");
            return;  // Se estiver cheia, não podemos adicionar mais números
        }

        tamanho++;          // Agora temos um número a mais
        int indice = tamanho - 1;  // O novo número vai para o final da fila
        heap[indice] = elemento;   // Guardamos o novo número na fila

        // A partir daqui, organizamos a fila para que os números mais importantes (menores) fiquem no topo
        while (indice > 0 && heap[pai(indice)] > heap[indice]) {
            trocar(indice, pai(indice));  // Se o número que acabamos de adicionar for menor do que o seu pai, trocamos eles de lugar
            indice = pai(indice);          // Vamos para o pai para continuar organizando
        }
    }

    // Removemos e retornamos o número mais importante (menor) da fila
    public int remover() {
        // Verificamos se a fila está vazia
        if (tamanho <= 0) {
            System.out.println("A fila de prioridade está vazia.");
            return Integer.MIN_VALUE;  // Se estiver vazia, não temos nenhum número para retornar
        }

        // Se a fila tem apenas um número, retornamos ele e removemos da fila
        if (tamanho == 1) {
            tamanho--;
            return heap[0];
        }

        int raiz = heap[0];                  // Guardamos o número mais importante (menor), que está no topo da fila
        heap[0] = heap[tamanho - 1];        // Substituímos o topo com o último número da fila
        tamanho--;                         // Agora temos um número a menos na fila

        // Agora organizamos a fila para manter a propriedade do heap
        heapify(0);

        return raiz;  // Retornamos o número mais importante (menor)
    }

    // Organizamos a fila a partir de um certo ponto para manter a propriedade do heap
    private void heapify(int indice) {
        int menor = indice;
        int filhoEsquerdo = filhoEsquerdo(indice);
        int filhoDireito = filhoDireito(indice);

        // Encontramos qual é o menor entre o pai, o filho da esquerda e o filho da direita
        if (filhoEsquerdo < tamanho && heap[filhoEsquerdo] < heap[menor]) {
            menor = filhoEsquerdo;
        }

        if (filhoDireito < tamanho && heap[filhoDireito] < heap[menor]) {
            menor = filhoDireito;
        }

        // Se o menor não for o pai, trocamos eles de lugar e continuamos organizando
        if (menor != indice) {
            trocar(indice, menor);
            heapify(menor);
        }
    }

    // Métodos auxiliares para calcular índices no heap
    private int pai(int i) {
        return (i - 1) / 2;
    }

    private int filhoEsquerdo(int i) {
        return 2 * i + 1;
    }

    private int filhoDireito(int i) {
        return 2 * i + 2;
    }

    // Método auxiliar para trocar dois números de lugar na fila
    private void trocar(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Método principal para teste
    public static void main(String[] args) {
        // Criamos uma fila de prioridade com capacidade para 10 números
        FilaDePrioridadeHeap filaDePrioridade = new FilaDePrioridadeHeap(10);

        // Adicionamos alguns números à fila
        filaDePrioridade.inserir(5);
        filaDePrioridade.inserir(2);
        filaDePrioridade.inserir(8);
        filaDePrioridade.inserir(1);
        filaDePrioridade.inserir(6);

        // Removemos e exibimos os números em ordem de prioridade
        while (filaDePrioridade.tamanho > 0) {
            System.out.println(filaDePrioridade.remover());
        }
    }
}
