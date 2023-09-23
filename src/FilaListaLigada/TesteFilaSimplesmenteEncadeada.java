package FilaListaLigada;

public class TesteFilaSimplesmenteEncadeada {
    public static void main(String[] args) {
        FilaSimplesmenteEncadeada fila = new FilaSimplesmenteEncadeada();
        System.out.println("Inserindo nós na fila:");
        for (int i = 0; i < 10; i++) {
            fila.enqueue(i);
        }

        fila.imprimirFila();

        System.out.println("Removendo nós na fila:");
        for (int i = 0; i < 6; i++) {
            System.out.println(fila.dequeue());
        }

        fila.imprimirFila();
        System.out.println("O primeiro elemento da fila é:" + fila.first());
        System.out.println("O tamanho da fila é: " + fila.size());
    }
}
