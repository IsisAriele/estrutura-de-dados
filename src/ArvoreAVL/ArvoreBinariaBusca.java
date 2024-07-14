package ArvoreAVL;

import java.util.Iterator;

public class ArvoreBinariaBusca {
    public int size;
    public No raiz;


    public ArvoreBinariaBusca(){
        this.size = 0;
        this.raiz = null;
    }

    public No pesquisa(No no, Object key) {
        System.out.println("Atual recursão - " + key + " Pai: " + no);
        // chegou num ponto que não desce mais
        if (no.isExternal())
            return no;

        if ((int) key < (int) no.getKey()) {
            if (no.getLeftChild() == null) // quando for igual retorna o no
                return no;
            return pesquisa(no.getLeftChild(), key);
        } else if ((int) key == (int) no.getKey()){
            return no;
        } else {
            if (no.getRightChild() == null) // quando for igual retorna o no
                return no;
            return pesquisa(no.getRightChild(), key);
        }
    }


    public No incluir(Object key) {
        System.out.println("Inserindo valor: " + key);
        No noPai = pesquisa(raiz, key); // Acho quem será o pai


        System.out.println("Valor do pai: " + noPai.getKey());

        No novoNo = new No(noPai, key);
        if ((int) noPai.getKey() > (int) key){
            // se a chave do pai for maior insere no filho esquerdo
            noPai.setLeftChild(novoNo);
            novoNo.setParent(noPai);
        } else { //direita
            noPai.setRightChild(novoNo);
            novoNo.setParent(noPai);
        }
        this.size++;
        return novoNo;
    }



    public No remover(Object key) {
        No no = pesquisa(raiz, key); // Encontra o nó a ser removido
        if (no != null) {
            removerNo(no);
            size--;
        }
        return no;
    }

    //refazer o método acima com if else
    public void removerNo(No no) {
        int quantidadeFilhos = quantidadeFilhos(no);

        if (quantidadeFilhos == 0) {
            System.out.println("Entrou case 0 " + no.getKey());
            removerFolha(no);
        } else if (quantidadeFilhos == 1) {
            System.out.println("Entrou case 1");
            removerPaiDeUm(no);
        } else if (quantidadeFilhos == 2) {
            System.out.println("Entrou case 2");
            removerPaiDeDois(no);
        }
    }

    public int quantidadeFilhos(No no) {
        int count = 0;
        if (no.hasLeftChild()) {
            count++;
        }
        if (no.hasRightChild()) {
            count++;
        }
        return count;
    }

    public void removerFolha(No no) {
        No pai = no.getParent();
        if (pai == null) {
            raiz = null; // O nó é a raiz
        } else if (pai.getLeftChild() == no) {
            pai.setLeftChild(null);
            System.out.println("ENTROU!!!");
        } else {
            pai.setRightChild(null);
        }
    }

    public void removerPaiDeUm(No no) {
        No filho = (no.hasLeftChild()) ? no.getLeftChild() : no.getRightChild();

        No pai = no.getParent();

        if (pai == null) {
            raiz = filho; // O nó é a raiz
        } else if (pai.getLeftChild() == no) { // se ele é filho esquerdo, o pai terá um novo filho esquerdo

            pai.setLeftChild(filho);
        } else {
            pai.setRightChild(filho);
        }
        filho.setParent(pai);
    }

    public void removerPaiDeDois(No no) {

        No sucessor = encontrarMenorNo(no.getRightChild());
        Object temp = sucessor.getKey();
        removerNo(sucessor);
        no.setKey(temp);
    }

    public No encontrarMenorNo(No no) {
        while (no.getLeftChild() != null) {
            no = no.getLeftChild();
        }
        return no;
    }



    public No getRaiz() {
        return this.raiz;
    }


    public void setRaiz(No p) {
        this.raiz = p;
        size++;
    }


    public void emOrdem(No no) {
        // No é visitado depois do filho da esquerda e antes do filho da direita
        //Utiliza uma abordagem recursiva para percorrer a subárvore esquerda,
        // visitar o próprio nó e, em seguida, percorrer a subárvore direita.
        if(no.getLeftChild() != null){
            emOrdem(no.getLeftChild());
        }
        System.out.print(no.getKey() + " ");
        if(no.getRightChild() != null){
            emOrdem(no.getRightChild());
        }
    }


    public void preOrdem(No no) {
        // No é visitado antes de seus descendentes
        System.out.print(no.getKey() + " ");
        if(no.getLeftChild() != null){
            preOrdem(no.getLeftChild());
        }
        if(no.getRightChild() != null){
            preOrdem(no.getRightChild());
        }
    }


    public void posOrdem(No no) {
        // No é visitado depois de seus descendentes
        if(no.getLeftChild() != null){
            posOrdem(no.getLeftChild());
        }
        if(no.getRightChild() != null){
            posOrdem(no.getRightChild());
        }
        System.out.print(no.getKey() + " ");
    }


    public int altura(No no) {
        if (no == null || no.isExternal()) {
            return 0;
        }
        int alturaEsquerda = altura(no.getLeftChild());
        int alturaDireita = altura(no.getRightChild());

        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }


    public int profundidade(No no) {
        if (no == raiz) {
            return 0;
        }
        return 1 + profundidade(no.getParent());
    }

    public void mostrar() {
        int h = altura(raiz);
        int nLinhas = h + 1;
        double nColunas = Math.pow(2, h + 1);

        Object[][] tabela = new Object[nLinhas][(int) nColunas];
        preencheTabela(raiz, tabela, 0, (int) nColunas / 2);

        for (int i = 0; i < nLinhas; i++) {
            for (int j = 0; j < (int) nColunas; j++) {
                if (tabela[i][j] == null)
                    System.out.print("   ");
                else
                    System.out.printf("%3s", tabela[i][j]);
            }
            System.out.println();
        }
    }

    protected void preencheTabela(No no, Object[][] tabela, int linha, int coluna) {
        if (no == null)
            return;

        tabela[linha][coluna] = no.getKey();

        int offset = (int) Math.pow(2, tabela.length - linha - 2);

        if (no.getLeftChild() != null) {
            preencheTabela(no.getLeftChild(), tabela, linha + 1, coluna - offset);
        }

        if (no.getRightChild() != null) {
            preencheTabela(no.getRightChild(), tabela, linha + 1, coluna + offset);
        }
    }


    public Iterator nos() {
        return null;
    }


    public Iterator elements() {
        return null;
    }


    public int size() {
        return this.size;
    }


    public boolean isEmpty() {
        return this.size == 0;
    }
}
