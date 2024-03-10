package Ordenacao;
import java.util.LinkedList;
public class MergeSort {
    public static void main(String[] args) {
        LinkedList<Integer> sequence = new LinkedList<>();
        sequence.add(12);
        sequence.add(11);
        sequence.add(13);
        sequence.add(5);
        sequence.add(6);

        System.out.println("Sequência antes da ordenação:");
        printSequence(sequence);

        mergeSort(sequence);

        System.out.println("\nSequência após a ordenação:");
        printSequence(sequence);
    }

    static void mergeSort(LinkedList<Integer> S) {
        if (S.size() > 1) {
            // Divisão da sequência em duas
            LinkedList<Integer> S1 = new LinkedList<>();
            LinkedList<Integer> S2 = new LinkedList<>();
            partition(S, S1, S2);

            // Recursivamente ordenar S1 e S2
            mergeSort(S1);
            mergeSort(S2);

            // Juntar S1 e S2
            merge(S1, S2, S);
        }
    }

    static void merge(LinkedList<Integer> A, LinkedList<Integer> B, LinkedList<Integer> S) {
        S.clear(); // Limpar a sequência resultante

        while (!A.isEmpty() && !B.isEmpty()) {
            if (A.getFirst() < B.getFirst()) {
                S.addLast(A.removeFirst());
            } else {
                S.addLast(B.removeFirst());
            }
        }

        while (!A.isEmpty()) {
            S.addLast(A.removeFirst());
        }

        while (!B.isEmpty()) {
            S.addLast(B.removeFirst());
        }
    }

    static void partition(LinkedList<Integer> S, LinkedList<Integer> S1, LinkedList<Integer> S2) {
        int size = S.size();
        int middle = size / 2;

        // Adiciona os elementos da primeira metade em S1
        for (int i = 0; i < middle; i++) {
            S1.addLast(S.removeFirst());
        }

        // Adiciona os elementos da segunda metade em S2
        while (!S.isEmpty()) {
            S2.addLast(S.removeFirst());
        }
    }

    static void printSequence(LinkedList<Integer> sequence) {
        for (int num : sequence) {
            System.out.print(num + " ");
        }
    }
}
