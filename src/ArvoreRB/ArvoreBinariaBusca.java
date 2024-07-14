package ArvoreRB;
import java.util.Iterator;

public class ArvoreBinariaBusca {
    public int size;
    public NoRB raiz;

    public ArvoreBinariaBusca(){
        this.size = 0;
        this.raiz = null;
    }

    public NoRB pesquisa(NoRB NoRB, Object key) {
        System.out.println("Atual recursão - " + key + " Pai: " + NoRB);
        // chegou num ponto que não desce mais
        if (NoRB.isExternal())
            return NoRB;

        if ((int) key < (int) NoRB.getKey()) {
            if (NoRB.getLeftChild() == null) // quando for igual retorna o NoRB
                return NoRB;
            return pesquisa(NoRB.getLeftChild(), key);
        } else if ((int) key == (int) NoRB.getKey()){
            return NoRB;
        } else {
            if (NoRB.getRightChild() == null) // quando for igual retorna o NoRB
                return NoRB;
            return pesquisa(NoRB.getRightChild(), key);
        }
    }


    public NoRB incluir(Object key) {
        System.out.println("Inserindo valor: " + key);
        NoRB NoRBPai = pesquisa(raiz, key); // Acho quem será o pai


        System.out.println("Valor do pai: " + NoRBPai.getKey());

        NoRB NoRBvoNoRB = new NoRB(NoRBPai, key);
        if ((int) NoRBPai.getKey() > (int) key){
            // se a chave do pai for maior insere NoRB filho esquerdo
            NoRBPai.setLeftChild(NoRBvoNoRB);
            NoRBvoNoRB.setParent(NoRBPai);
        } else { //direita
            NoRBPai.setRightChild(NoRBvoNoRB);
            NoRBvoNoRB.setParent(NoRBPai);
        }
        this.size++;
        return NoRBvoNoRB;
    }


    public NoRB remover(Object key) {
        NoRB NoRB = pesquisa(raiz, key); // Encontra o nó a ser removido
        if (NoRB != null) {
            removerNoRB(NoRB);
            size--;
        }
        return NoRB;
    }

    //refazer o método acima com if else
    public void removerNoRB(NoRB NoRB) {
        int quantidadeFilhos = quantidadeFilhos(NoRB);

        if (quantidadeFilhos == 0) {
            System.out.println("Entrou case 0 " + NoRB.getKey());
            removerFolha(NoRB);
        } else if (quantidadeFilhos == 1) {
            System.out.println("Entrou case 1");
            removerPaiDeUm(NoRB);
        } else if (quantidadeFilhos == 2) {
            System.out.println("Entrou case 2");
            removerPaiDeDois(NoRB);
        }
    }

    public int quantidadeFilhos(NoRB NoRB) {
        int count = 0;
        if (NoRB.hasLeftChild()) {
            count++;
        }
        if (NoRB.hasRightChild()) {
            count++;
        }
        return count;
    }

    public void removerFolha(NoRB NoRB) {
        NoRB pai = NoRB.getParent();
        if (pai == null) {
            raiz = null; // O nó é a raiz
        } else if (pai.getLeftChild() == NoRB) {
            pai.setLeftChild(null);
            System.out.println("ENTROU!!!");
        } else {
            pai.setRightChild(null);
        }
    }

    public void removerPaiDeUm(NoRB NoRB) {
        NoRB filho = (NoRB.hasLeftChild()) ? NoRB.getLeftChild() : NoRB.getRightChild();

        NoRB pai = NoRB.getParent();

        if (pai == null) {
            raiz = filho; // O nó é a raiz
        } else if (pai.getLeftChild() == NoRB) { // se ele é filho esquerdo, o pai terá um NoRBvo filho esquerdo

            pai.setLeftChild(filho);
        } else {
            pai.setRightChild(filho);
        }
        filho.setParent(pai);
    }

    public void removerPaiDeDois(NoRB NoRB) {

        NoRB sucessor = encontrarMenorNoRB(NoRB.getRightChild());
        Object temp = sucessor.getKey();
        removerNoRB(sucessor);
        NoRB.setKey(temp);
    }

    public NoRB encontrarMenorNoRB(NoRB NoRB) {
        while (NoRB.getLeftChild() != null) {
            NoRB = NoRB.getLeftChild();
        }
        return NoRB;
    }



    public NoRB getRaiz() {
        return this.raiz;
    }


    public void setRaiz(NoRB p) {
        this.raiz = p;
        size++;
    }


    public void emOrdem(NoRB NoRB) {
        // NoRB é visitado depois do filho da esquerda e antes do filho da direita
        //Utiliza uma abordagem recursiva para percorrer a subárvore esquerda,
        // visitar o próprio nó e, em seguida, percorrer a subárvore direita.
        if(NoRB.getLeftChild() != null){
            emOrdem(NoRB.getLeftChild());
        }
        System.out.print(NoRB.getKey() + " ");
        if(NoRB.getRightChild() != null){
            emOrdem(NoRB.getRightChild());
        }
    }

    public void preOrdem(NoRB NoRB) {
        // NoRB é visitado antes de seus descendentes
        System.out.print(NoRB.getKey() + " ");
        if(NoRB.getLeftChild() != null){
            preOrdem(NoRB.getLeftChild());
        }
        if(NoRB.getRightChild() != null){
            preOrdem(NoRB.getRightChild());
        }
    }


    public void posOrdem(NoRB NoRB) {
        // NoRB é visitado depois de seus descendentes
        if(NoRB.getLeftChild() != null){
            posOrdem(NoRB.getLeftChild());
        }
        if(NoRB.getRightChild() != null){
            posOrdem(NoRB.getRightChild());
        }
        System.out.print(NoRB.getKey() + " ");
    }


    public int altura(NoRB NoRB) {
        if (NoRB == null || NoRB.isExternal()) {
            return 0;
        }
        int alturaEsquerda = altura(NoRB.getLeftChild());
        int alturaDireita = altura(NoRB.getRightChild());

        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }


    public int profundidade(NoRB NoRB) {
        if (NoRB == raiz) {
            return 0;
        }
        return 1 + profundidade(NoRB.getParent());
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

    protected void preencheTabela(NoRB NoRB, Object[][] tabela, int linha, int coluna) {
        if (NoRB == null)
            return;

        tabela[linha][coluna] = NoRB.getKey();

        int offset = (int) Math.pow(2, tabela.length - linha - 2);

        if (NoRB.getLeftChild() != null) {
            preencheTabela(NoRB.getLeftChild(), tabela, linha + 1, coluna - offset);
        }

        if (NoRB.getRightChild() != null) {
            preencheTabela(NoRB.getRightChild(), tabela, linha + 1, coluna + offset);
        }
    }


    public Iterator NoRBs() {
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

