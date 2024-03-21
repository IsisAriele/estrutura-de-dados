package ArvorePesquisaBinaria;
import java.util.Iterator;

public class ArvoreBinariaPesquisa implements IArvoreBinariaPesquisa{
    public int size;
    public No raiz;


    public ArvoreBinariaPesquisa(){
        this.size = 0;
        this.raiz = null;
    }

    @Override
    public No pesquisa(No no, Object key) {
        // System.out.println("Atual recursão - " + key + " Pai: " + no);
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

    @Override
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
//
//    @Override
//    public Object remover(Object key) {
//        // Chamada para o método auxiliar de remoção
//        raiz = removerRec(raiz, key);
//        // Atualiza o tamanho da árvore após a remoção
//        size--;
//        // Retorna a chave removida
//        return key;
//    }
//
//    private No removerRec(No raiz, Object key) {
//        // Caso base: árvore vazia
//        if (raiz == null) {
//            return null;
//        }
//
//        // Caso recursivo: percorre a árvore
//        if ((int) key < (int) raiz.getKey()) {
//            // Chama recursivamente para a subárvore esquerda
//            raiz.setLeftChild(removerRec(raiz.getLeftChild(), key));
//        } else if ((int) key > (int) raiz.getKey()) {
//            // Chama recursivamente para a subárvore direita
//            raiz.setRightChild(removerRec(raiz.getRightChild(), key));
//        } else {
//            // Caso: nó com apenas um filho ou nenhum filho
//            if (raiz.getLeftChild() == null) {
//                // Retorna o filho à direita, se existir
//                return raiz.getRightChild();
//            } else if (raiz.getRightChild() == null) {
//                // Retorna o filho à esquerda, se existir
//                return raiz.getLeftChild();
//            }
//
//            // Caso 3: nó com dois filhos
//            // Obtém o sucessor em ordem (menor nó na subárvore direita)
//            //  root.key = successor.key;
//            raiz.setKey(encontrarMenorNo(raiz.getRightChild()).getKey());
//
//            // Exclui o sucessor em ordem da subárvore direita
//            raiz.setRightChild(removerRec(raiz.getRightChild(), raiz.getKey()));
//        }
//
//        // Retorna a raiz atualizada após a remoção
//        return raiz;
//    }
//
//    // Método auxiliar para encontrar o menor nó em uma subárvore
//    private No encontrarMenorNo(No no) {
//        // Percorre a árvore até o nó mais à esquerda
//        while (no.getLeftChild() != null) {
//            no = no.getLeftChild();
//        }
//        // Retorna o nó mais à esquerda
//        return no;
//    }

    @Override
    public No remover(Object key) {
        No no = pesquisa(raiz, key); // Encontra o nó a ser removido
        if (no != null) {
            System.out.println("Removendo: " + no.getKey());
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


    @Override
    public No getRaiz() {
        return this.raiz;
    }

    @Override
    public void setRaiz(No p) {
        this.raiz = p;
        size++;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public int altura(No no) {
        if (no == null || no.isExternal()) {
            return 0;
        }
        int alturaEsquerda = altura(no.getLeftChild());
        int alturaDireita = altura(no.getRightChild());

        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    @Override
    public int profundidade(No no) {
        if (no == raiz) {
            return 0;
        }
        return 1 + profundidade(no.getParent());
    }
    @Override
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

    @Override
    public Iterator nos() {
        return null;
    }

    @Override
    public Iterator elements() {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}

