package PilhaRubroNegra;

public class DuasPilhas implements PilhasInterface{
    private Object[] lista;
    private int indiceTopoVermelho;
    private int indiceTopoPreto;
    private int tamanhoDaLista;

    public DuasPilhas(int tamanhoDaLista){
        this.tamanhoDaLista = tamanhoDaLista;
        indiceTopoPreto = tamanhoDaLista;
        indiceTopoVermelho = -1;
        lista = new Object[this.tamanhoDaLista];
    }

    @Override
    public void pushVermelho(Object o) {
        if (indiceTopoVermelho + 1 == indiceTopoPreto) {
            int tamanhoAnterior = tamanhoDaLista;
            tamanhoDaLista *= 2;
            Object[] novaLista = new Object[tamanhoDaLista];
            // Cópia da pilha vermelha no novo array
            for(int i = 0; i <= indiceTopoVermelho; i++) {
                novaLista[i] = lista[i];
            }
            // Cópia da pilha preta no novo array
            //  aux inicializa com o índice do último elemento do novo array.
            int aux = tamanhoDaLista - 1;
            // loop começa pelo tamanho do array anterior e vai até o índice do topoPreto, ou seja, do início ao final da pilha
            for(int i = tamanhoAnterior - 1; i >= indiceTopoPreto; i--){
                novaLista[aux] = lista[i];
                aux--;
            }
            // indiceTopoPreto precisa ser atualizado com + 1, pois no for anterior aux foi decrementado.
            indiceTopoPreto = aux + 1;
            lista = novaLista;
        }
        indiceTopoVermelho += 1;
        lista[indiceTopoVermelho] = o;
    }

    @Override
    public void pushPreto(Object o) {
        if (indiceTopoPreto - 1 == indiceTopoVermelho) {
            int tamanhoAnterior = tamanhoDaLista;
            tamanhoDaLista *= 2;
            Object[] novaLista = new Object[tamanhoDaLista];
            for(int i = 0; i <= indiceTopoVermelho; i++) {
                novaLista[i] = lista[i];
            }
            int aux = tamanhoDaLista - 1;
            for(int i = tamanhoAnterior - 1; i >= indiceTopoPreto; i--){
                novaLista[aux] = lista[i];
                aux--;
            }
            indiceTopoPreto = aux + 1;
            lista = novaLista;
        }
        indiceTopoPreto -= 1;
        lista[indiceTopoPreto] = o;
    }

    @Override
    public Object popVermelho() throws PilhaVaziaExcecao {
        if (isEmptyVermelho()){
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia!");
        }
        Object temp = lista[indiceTopoVermelho];
        lista[indiceTopoVermelho] = null;
        indiceTopoVermelho -= 1;
        return temp;
    }

    @Override
    public Object popPreto() throws PilhaVaziaExcecao {
        if (isEmptyPreto()){
            throw new PilhaVaziaExcecao("A pilha Preta está vazia!");
        }
        Object temp = lista[indiceTopoPreto];
        lista[indiceTopoPreto] = null;
        indiceTopoPreto += 1;
        return temp;
    }

    @Override
    public Object topVermelho() throws PilhaVaziaExcecao {
        if (isEmptyVermelho()){
            throw new PilhaVaziaExcecao("A pilha Preta está vazia!");
        }
        return lista[indiceTopoVermelho];
    }

    @Override
    public Object topPreto() throws PilhaVaziaExcecao {
        if (isEmptyPreto()){
            throw new PilhaVaziaExcecao("A pilha Preta está vazia!");
        }
        return lista[indiceTopoPreto];
    }

    @Override
    public boolean isEmptyVermelho() {
        return indiceTopoVermelho == -1;
    }

    @Override
    public boolean isEmptyPreto() {
        return indiceTopoPreto == tamanhoDaLista;
    }

    @Override
    public int sizeVermelho() {
        return indiceTopoVermelho + 1;
    }

    @Override
    public int sizePreto() {
        return tamanhoDaLista - indiceTopoPreto;
    }

    public void listar() {
        for (int i = 0; i < tamanhoDaLista; i++) {
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }
}

