package Ordenacao;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Array antes da ordenação:");
        printArray(array);

        bubbleSort(array);

        System.out.println("\nArray após a ordenação:");
        printArray(array);
    }

    // Tempo total = o(n^2)
    // Em cada passagem ele pega o maior e vai colocando do final para o início
    static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Troca os elementos se estiverem fora de ordem
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
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
