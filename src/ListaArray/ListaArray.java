package ListaArray;

public class ListaArray implements Lista{
    private Object[] lista;
    private int size = 0;
    private int capacidade;

    public ListaArray(int capacidade){
        this.capacidade = capacidade;
        lista = new Object[capacidade];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // verifica se o elemento na posição n é o primeiro
    @Override
    public boolean isFirst(int n) {
        if(lista[0] == lista[n]){
            return true;
        } else {
            return false;
        }
    }

    // verifica se o elemento na posição n é o último.
    @Override
    public boolean isLast(int n) {
        if(lista[size - 1] == lista[n]){
            return true;
        } else {
            return false;
        }
    }

    // retorna o primeiro elemento
    @Override
    public Object first() {
        return lista[0];
    }

    // retorna o último elemento
    @Override
    public Object last() {
        return lista[size - 1];
    }

    // retorna o elemento antes do elemento na posição n.
    @Override
    public Object before(int n) {
        return lista[n - 1];
    }

    // retorna o elemento depois do elemento na posição n
    @Override
    public Object after(int n) {
        return lista[n + 1];
    }

    // substitui o elemento na posição n pelo objeto o
    @Override
    public Object replaceElement(int n, Object o) {
        Object aux = lista[n];
        lista[n] = o;
        return aux;
    }

    // troca os elementos nas posições n e m.
    @Override
    public void swapElements(int n, int m) {
        Object aux = lista[n];
        lista[n] = lista[m];
        lista[m] = aux;
    }

    // insere o objeto o antes do elemento na posição n
    @Override
    public void insertBefore(int n, Object o) {
        if(capacidade == size){
            aumentaCapacidade();
        }
        if(n == 0 || n > size + 1){
            throw new ListaExcecao("Índice informado ultrapassa os limites da lista");
        }else {
            for (int i = size; i > n - 1; i--) {
                lista[i] = lista[i - 1];
            }
            lista[n - 1] = o;
            size++;
        }
    }

    // insere o objeto o após o elemento na posição n.
    @Override
    public void insertAfter(int n, Object o) {
        if(capacidade == size){
            aumentaCapacidade();
        }
        if(n > size){
            throw new ListaExcecao("Índice informado ultrapassa os limites da lista");
        }else {
            for (int i = size; i > n + 1; i--) {
                lista[i] = lista[i - 1];
            }
            lista[n + 1] = o;
            size++;
        }
    }

    // insere o objeto o no início da lista.
    @Override
    public void insertFirst(Object o) {
        if(capacidade == size){
            aumentaCapacidade();
        }
        if(size > 0){
            for (int i = size; i > 0; i--) {
                lista[i] = lista[i - 1];
            }
            lista[0] = o;
            size++;
        } else {
            lista[0] = o;
            size++;
        }
    }

    //  insere o objeto o no final da lista.
    @Override
    public void insertLast(Object o) {
        if(capacidade == size){
            aumentaCapacidade();
        }
        lista[size] =o;
        size++;
    }

    //  remove o elemento na posição n da lista.
    @Override
    public void remove(int n) {
        for (int i = n; i < size; i++) {
            lista[i] = lista[i + 1];
        }
        size--;
    }

    public void aumentaCapacidade(){
        capacidade *= 2;
        Object[] novaLista = new Object[capacidade];
        for (int i = 0; i < size; i++) {
            novaLista[i] = lista[i];
        }
        lista = novaLista;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.print(this.lista[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
