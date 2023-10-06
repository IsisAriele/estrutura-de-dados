package ListaDuplamenteEncadeada;

public class TesteListaDL {
    public static void main(String[] args) {
        ListaDL lista = new ListaDL();
        for (int i = 0; i <= 5; i++) {
            lista.insertFirst(i);
        }
        lista.print();

        No aux = lista.first();
        for (int i = 0; i < 4; i++) { // Acessando o quarto nó
            aux = lista.after(aux);
        }

        System.out.println(aux.elemento); // Verificando elemento do quarto nó
        lista.insertBefore(aux, 10); // Inserindo antes do quarto nó um novo nó com valor 10
        lista.print();

        lista.insertFirst(100);
        lista.insertLast(100);
        lista.print();

        lista.remove(lista.first());
        lista.remove(lista.last());
        lista.print();

        lista.swapElements(lista.first(), lista.last());
        lista.print();

        System.out.println(lista.isFirst(lista.last()));
        System.out.println(lista.isLast(lista.first()));
    }
}
