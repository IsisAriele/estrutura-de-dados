package HEAP;

public class HeapArray {
    private int[] heap;
    private int size;

    public HeapArray(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        if (size == heap.length) {
            System.out.println("Heap cheia.");
            return;
        }

        heap[size] = value; // Insere o valor no final do heap
        upHeap(size);
        size++;
    }

    public int removeMin() {
        if (isEmpty()) {
            System.out.println("Heap vazia");
            return -1;
        }

        int min = heap[0];

        heap[0] = heap[size - 1]; // Substitui a raiz pelo último elemento
        size--;
        downHeap(0);

        return min;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int min() {
        if (isEmpty()) {
            System.out.println("Heap vazia");
            return -1;
        }

        return heap[0]; // Retorna o menor elemento, que está na raiz do heap
    }

    // Método para restaurar a propriedade do heap subindo o elemento no índice especificado
    private void upHeap(int index) {
        int parent = (index - 1) / 2; // calcula o indice do pai do nó

        // Enquanto o índice não é a raiz e o valor do nó atual é menor que o do pai
        while (index > 0 && heap[index] < heap[parent]) {
            swapKeys(index, parent); // Troca o elemento com seu pai
            index = parent;
            parent = (index - 1) / 2; // Recalcula o índice do pai do novo nó atual
        }
    }

    // Método para restaurar a propriedade do heap descendo o elemento no índice especificado
    private void downHeap(int index) {
        // Calculo dos indices dos filhos esquerdo e direito a partir do indice especificado
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;
        int smallElem = index; // Inicializa com o indice do nó atuall

        // Verifica se o filho esquerdo existe e se o valor do filho esquerdo é menor que o valor do nó atual.
        // Se verdadeiro, atualiza smallElem com o índice do filho esquerdo.
        if (leftChild < size && heap[leftChild] < heap[smallElem]) {
            smallElem = leftChild;
        }

        // Mesma coisa, mas com o direito
        if (rightChild < size && heap[rightChild] < heap[smallElem]) {
            smallElem = rightChild;
        }


        if (smallElem != index) {
            swapKeys(index, smallElem); // Troca o elemento com seu menor filho se necessário.
            downHeap(smallElem);
        }
    }

    private void swapKeys(int i, int j) {
        int aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    public void mostrarArray() {
        System.out.print("Heap Array: [");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
