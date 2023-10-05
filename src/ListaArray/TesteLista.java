package ListaArray;

public class TesteLista {
    public static void main(String[] args) {
        ListaArray lista = new ListaArray(10);
        for (int i = 0; i < 4; i++) {
            lista.insertFirst(i);
        }
        lista.print();

        lista.insertBefore(5, 9);
        lista.print();

        lista.insertBefore(5, 100);
        lista.print();

        lista.insertAfter(1, 33);
        lista.print();

        lista.insertLast(55);
        lista.print();

        lista.remove(2);
        lista.print();
    }
}
