package PilhaVector;
import java.util.Vector;

public class PilhaVector implements Pilha{
    private Vector<Object> vector;

    public PilhaVector() {
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

    @Override
    public Object top() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }
        return vector.lastElement();
    }

    @Override
    public void push(Object o) {
        vector.add(o);
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }
        Object temp = vector.lastElement();
        vector.remove(vector.size() - 1);
        return temp;
    }

    public void listar() {
        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.get(i) + " ");
        }
        System.out.println();
    }

}
