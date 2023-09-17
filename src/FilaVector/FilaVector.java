package FilaVector;
import java.util.Vector;

public class FilaVector implements FilaVectorInterface{
    private Vector<Object> vector;
    public FilaVector() {
        vector = new Vector<>();
    }

    @Override
    public int size() {
        return vector.size();
    }
    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }
    // insere no fim
    @Override
    public void enqueue(Object o){
        vector.add(o);
    }
    // remove e mostra o elemento do inicio
    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new FilaVectorVaziaExcecao("A fila está vazia!");
        }
        Object temp = vector.get(0);
        vector.remove(0);
        return temp;
    }
    @Override
    public Object first(){
        if (isEmpty()) {
            throw new FilaVectorVaziaExcecao("A fila está vazia!");
        }
        return vector.get(0);
    }
    public void listar() {
        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.get(i) + " ");
        }
        System.out.println();
    }
}
