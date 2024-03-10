package Ordenacao;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};

        System.out.println("Array antes da ordenação:");
        printArray(array);

        insertSort(array);

        System.out.println("\nArray após a ordenação:");
        printArray(array);
    }

    // Tempo é o(n^2)
    static void insertSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int aux = array[i];
            int j = i - 1;

            while (j >= 0 && aux < array[j]) {
                // Desloca os elementos maiores para a direita
                array[j + 1] = array[j];
                j--;
            }

            // Insere o elemento aux no lugar correto
            array[j + 1] = aux;
        }
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
