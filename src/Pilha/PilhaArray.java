package Pilha;

public class PilhaArray implements Pilha {
    private int tamanhoDaPilha;
    private Object[] lista;
    private int indiceDoTopo = -1;

    public PilhaArray(int tamanhoDaPilha){
        this.tamanhoDaPilha = tamanhoDaPilha;
        this.lista = new Object[this.tamanhoDaPilha];
    }
    @Override
    public int size() {
        return this.indiceDoTopo + 1;
    }

    @Override
    public boolean isEmpty() {
        return indiceDoTopo == -1;
    }

    @Override
    public Object top() throws PilhaVaziaExcecao {
        if (isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }

        return lista[indiceDoTopo];
    }

    @Override
    public void push(Object o) {
        if (indiceDoTopo == tamanhoDaPilha - 1) {
            System.out.println("Aumentando o tamanho da lista");
            tamanhoDaPilha *= 2;
            Object[] novaLista = new Object[tamanhoDaPilha];
            for(int i = 0; i <= indiceDoTopo; i++) {
                novaLista[i] = lista[i];
            }
            lista = novaLista;
        }
        indiceDoTopo += 1;
        lista[indiceDoTopo] = o;
        System.out.println(o);
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        if (isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }
        Object temp = lista[indiceDoTopo];
        lista[indiceDoTopo] = null;
        indiceDoTopo -= 1;
        return temp;
    }
}
