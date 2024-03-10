package HEAP;

public class TesteHeap {
    public static void main(String[] args) {
        Heap heap = new Heap(2);

        heap.insert(3);
        heap.insert(5);
        heap.insert(9);
        heap.insert(7);
        heap.insert(6);

        System.out.println(heap.lastNode);
        heap.mostrar();

        Object min = heap.removeMin();
        System.out.println("Elemento removido: " + min);

        heap.mostrar();
        System.out.println(heap.lastNode);
    }
}
