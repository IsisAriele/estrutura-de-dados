package VetorArray;

public class VetorArray {

    private Object[] array;
    private int capacidade;
    private int size = 0;

    public VetorArray(int capacidade){
        this.capacidade = capacidade;
        this.array = new Object[this.capacidade];
    }

    // Retorna o elemento na colocação r
    public Object elemAtRank(int r){
        return array[r];
    }

    // Substitui o elemento na colocação r por o e retorna o antigo elemento
    public Object replaceAtRank(int r, Object o){
        if(r > size){
            throw new VetorExcecao("Não é possível inserir um elemento numa posição que é maior que o número de elementos atual da lista");
        }
        Object aux = array[r];
        array[r] = o;
        return aux;
    }

    // Insere um novo elemento na colocação r
    public void insertAtRank(int r, Object o){
        if(r > size){
            throw new VetorExcecao("Não é possível inserir um elemento numa posição que é maior que o número de elementos atual da lista");
        }
        if(capacidade == size){
            System.out.println("duplicando");
            capacidade *= 2;
            Object[] novoArray = new Object[capacidade];
            for (int i = 0; i < size; i++) {
                novoArray[i] = array[i];
            }
            array = novoArray;
        }
        // Movendo os elementos para abrir espaço para o novo elemento.
        for (int i = size; i > r; i--) {
            array[i] = array[i - 1];
        }
        array[r] = o;
        size++;
    }

    // Remove e retorna o elemento na posição r
    public Object removeAtRank(int r){
        if(isEmpty()){
            throw new VetorExcecao("O vetor está vazio");
        }
        if(r > size){
            throw new VetorExcecao("Não é possível remover um elemento numa posição que é maior que o número de elementos atual da lista");
        }
        Object aux = array[r];
        for (int i = r; i < size + 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
        return aux;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(this.array[i]);
            System.out.print(' ');
        }
    }

}
