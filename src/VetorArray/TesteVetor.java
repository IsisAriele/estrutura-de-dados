package VetorArray;

public class TesteVetor {
    public static void main(String[] args) {
        VetorArray array = new VetorArray(10);
        array.insertAtRank(0, 2);
        array.insertAtRank(1, 3);
        array.insertAtRank(1, 4);
        array.insertAtRank(0, 5);

        array.print(); // 5 2 4 3
        System.out.println();
        System.out.println(array.removeAtRank(0)); // 5
        System.out.println(array.removeAtRank(1));// 4
        array.print(); // 2 3
        System.out.println();
        System.out.println(array.replaceAtRank(1, 9)); // 3
        array.print(); // 2 9
    }
}
