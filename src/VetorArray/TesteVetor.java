package VetorArray;

public class TesteVetor {
    public static void main(String[] args) {
        VetorArray array = new VetorArray(10);
        array.insertAtRank(0, 0);
        array.insertAtRank(1, 1);
        array.insertAtRank(2, 2);
        array.insertAtRank(3, 3);
        array.insertAtRank(4, 4);
        array.insertAtRank(5, 5);

        array.print();
        System.out.println();
        System.out.println("Remove");
        System.out.println(array.removeAtRank(0));
        array.print();
        System.out.println();
        System.out.println(array.removeAtRank(1));
        array.print();
        System.out.println();
        System.out.println(array.replaceAtRank(1, 9));
        array.print();
        System.out.println("Remove");
        System.out.println(array.removeAtRank(2));
        array.print();
        System.out.println();
    }
}
