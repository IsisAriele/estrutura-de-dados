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

    // Métodos adicionais propostos pelo professor

    // Esvazia pilha
    public void empty() {
        for (int i = 0; i <= indiceDoTopo; i++) {
            lista[i] = null;
        }
        indiceDoTopo = -1; // Resetar o índice do topo para indicar que a pilha está vazia.
    }

    //
    public void adicionaPilha(Pilha p) {
        int tamanhoPilhaP = p.size();
        Object[] elementosP = new Object[tamanhoPilhaP];

        // Transferir os elementos da pilha p para o array elementosP
        for (int i = 0; i < tamanhoPilhaP; i++) {
            try {
                elementosP[i] = p.pop();
            } catch (PilhaVaziaExcecao e) {
                e.printStackTrace();
            }
        }

        // Transferir os elementos do array elementosP para a pilha atual
        for (int i = tamanhoPilhaP - 1; i >= 0; i--) {
            push(elementosP[i]);
        }
    }
}
