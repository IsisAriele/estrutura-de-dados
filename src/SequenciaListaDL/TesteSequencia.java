package SequenciaListaDL;

public class TesteSequencia {
    public static void main(String[] args) {
        SequenciaLD sequencia = new SequenciaLD();
        System.out.println("### TESTANDO MÉTODOS DO VETOR: ###");
        sequencia.print();
        System.out.println("Tamanho da sequencia");
        System.out.println(sequencia.size());

        System.out.println("Inserindo em posição específica: ");
        sequencia.insertAtRank(0, 1);
        sequencia.insertAtRank(1, 2);
        sequencia.insertAtRank(2, 3);
        sequencia.print();

        System.out.println("Retornando o elemento na posição escolhida (1)");
        System.out.println(sequencia.elemAtRank(1));

        System.out.println("Substituindo o elemento da posição 2");
        System.out.println(sequencia.replaceAtRank(2, 100));
        sequencia.print();

        System.out.println("Removendo elemento na posição escolhida (2)");
        System.out.println(sequencia.removeAtRank(2));
        sequencia.print();

        System.out.println();
        System.out.println("### TESTANDO MÉTODOS DE LISTA: ###");

        System.out.println("Inserindo um nó antes do nó informado (1)");
        sequencia.insertBefore(sequencia.atRank(1), 33);
        sequencia.print();

        System.out.println("Inserindo um nó depois do nó informado (1)");
        sequencia.insertAfter(sequencia.atRank(2), 55);
        sequencia.print();

        System.out.println("Inserindo o nó no inicio da sequencia");
        sequencia.insertFirst(21);
        sequencia.print();

        System.out.println("Inserindo o nó no fim da sequencia");
        sequencia.insertLast(23);
        sequencia.print();

        System.out.println("Substituindo o elemento do nó pelo objeto passado");
        sequencia.replaceElement(sequencia.atRank(1), 10);
        sequencia.print();

        System.out.println("Trocando os elementos de dois nós");
        sequencia.swapElements(sequencia.atRank(1), sequencia.last());
        sequencia.print();

        System.out.println("Removendo um nó");
        sequencia.remove(sequencia.atRank(0));
        sequencia.print();

        System.out.println("Tamanho da sequencia");
        System.out.println(sequencia.size());

        System.out.println("Testando método rankOf");
        System.out.println(sequencia.rankOf(sequencia.last()));

    }
}
