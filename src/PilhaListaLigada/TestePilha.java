package PilhaListaLigada;

public class TestePilha {
    public static void main(String[] args) {
        PilhaSimplesmenteEncadeada pilha = new PilhaSimplesmenteEncadeada();
        System.out.println("Inserindo elementos na pilha: ");
        for (int i = 0; i < 10; i++) {
            pilha.push(i);
        }

        pilha.imprimirLista();

        System.out.println("Removendo elementos na pilha: ");
        for (int i = 0; i < 6; i++) {
            System.out.println(pilha.pop());
        }

        pilha.imprimirLista();

        System.out.println(pilha.top());
        System.out.println(pilha.size());
    }
}
