package HEAP;

public class TesteHeapArray {
    public static void main(String[] args) {
        HeapArray heap = new HeapArray(10);

        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.mostrarArray();

        System.out.println("Tamanho do heap: " + heap.size());
        System.out.println("Elemento mínimo: " + heap.min());
        heap.mostrarArray();
        while (!heap.isEmpty()) {
            System.out.println("Removido: " + heap.removeMin());
        }

        System.out.println("Tamanho final do heap: " + heap.size());
        heap.mostrarArray();
    }
}
