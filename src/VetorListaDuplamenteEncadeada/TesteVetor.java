package VetorListaDuplamenteEncadeada;

public class TesteVetor {
    public static void main(String[] args) {
        VetorListaDuplamenteEncadeada vetor = new VetorListaDuplamenteEncadeada();
        vetor.insertAtRank(0, 2);
        vetor.insertAtRank(0, 3);
        vetor.insertAtRank(1, 4);
        vetor.insertAtRank(2, 9);
        vetor.insertAtRank(4, 10);
        vetor.print();

        System.out.println();
        System.out.println(vetor.elemAtRank(2));

        vetor.removeAtRank(4);
        vetor.removeAtRank(1);

        vetor.print();

        System.out.println(vetor.replaceAtRank(2, 99));
        vetor.print();


    }
}
