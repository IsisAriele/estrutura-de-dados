package ListaDuplamenteEncadeada;

public class TesteListaDL {
    public static void main(String[] args) {
        ListaDL lista = new ListaDL();
        lista.insertBefore(0, 1);
        lista.print();
        lista.insertBefore(0, 2);
        lista.insertBefore(0, 3);
        lista.insertBefore(4, 4);
        lista.print();

        lista.insertAfter(1, 55);
        lista.print();
        lista.insertAfter(3, 66);
        lista.print();
    }
}
