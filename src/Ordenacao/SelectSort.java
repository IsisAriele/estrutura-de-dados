package Ordenacao;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Array antes da ordenação:");
        printArray(array);

        SelectSort(array);

        System.out.println("\nArray após a ordenação:");
        printArray(array);
    }

    // Tempo total é o(n^2)
    static void SelectSort(int[] array) {
        int n = array.length;
        // Compara o primeiro com todos os outros e assim por diante até n - 2
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (array[j] < array[i]) {
                    // Troca os elementos se estiverem fora de ordem
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
