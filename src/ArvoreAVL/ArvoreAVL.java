package ArvoreAVL;


public class ArvoreAVL extends ArvoreBinariaBusca{

    public ArvoreAVL(){
        super();
    }

    public void inserirAVL(Object k){
        No novo = new No(null, k);
        if(this.getRaiz() == null){
            this.setRaiz(novo);
        } else {
            novo = incluir(k);
            atualizaFb(novo);
        }
    }

    public void atualizaFb(No novo) {
        No pai = novo.getParent();

        while (pai != null) {
            if (novo == pai.getLeftChild()) {
                pai.setFb(pai.getFb() + 1);
            } else {
                pai.setFb(pai.getFb() - 1);
            }

            if (pai.getFb() == -2 || pai.getFb() == 2) {
                rebalancear(pai);
                break; // Após rebalancear, não é necessário continuar subindo na árvore
            }

            if (pai.getFb() == 0) {
                break; // Se o fator de balanceamento for 0, não há necessidade de continuar subindo
            }

            novo = pai;
            pai = novo.getParent();
        }
    }


    private void rebalancear(No n) {

        if (n.getFb() == -2) {
            if (n.getRightChild().getFb() <= 0 ) {
                rotacaoEsquerda(n);
            } else { //verificar consição de entrar null
                rotacaoDuplaEsquerda(n);
            }
        } else if (n.getFb() == 2) {
            if ( n.getLeftChild().getFb() >= 0) {
                rotacaoDireita(n);
            } else{
                rotacaoDuplaDireita(n);
            }
        }
    }

    private No rotacaoEsquerda(No n) {
        No sucessor = n.getRightChild();

        if(n.getParent() == null){
            sucessor.setParent(null);
            setRaiz(sucessor);
        } else{
            sucessor.setParent(n.getParent()); // pai do nó alterado agr será o pai do filho direito
            if (n == n.getParent().getLeftChild()) { // se o no desb. for filho esquerdo do seu pai
                n.getParent().setLeftChild(sucessor); // o filho esquerdo do pai do no desb. será o filho direito do no desb.

            } else {
                n.getParent().setRightChild(sucessor); // o filho direito do pai do no desb. será o filho direito do no desb.
            }
        }

        n.setParent(sucessor);
        n.setRightChild(sucessor.getLeftChild());

        if (sucessor.getLeftChild() != null) {
            sucessor.getLeftChild().setParent(n); //
        }
        sucessor.setLeftChild(n);

        int newBalN = n.getFb() + 1 - Math.min(sucessor.getFb(), 0);
        int newBalSucessor = sucessor.getFb() + 1 + Math.max(newBalN, 0);

        n.setFb(newBalN);
        sucessor.setFb(newBalSucessor);
        return sucessor;
    }

    private No rotacaoDireita(No n) {
        No sucessor = n.getLeftChild();

        if(n.getParent() == null){
            sucessor.setParent(null);
            setRaiz(sucessor);
        } else{
            sucessor.setParent(n.getParent()); // pai do nó alterado agr será o pai do filho direito
            if (n == n.getParent().getLeftChild()) { // se o no desb. for filho esquerdo do seu pai
                n.getParent().setLeftChild(sucessor); // o filho esquerdo do pai do no desb. será o filho direito do no desb.

            } else {
                n.getParent().setRightChild(sucessor); // o filho direito do pai do no desb. será o filho direito do no desb.
            }
        }

        n.setParent(sucessor);
        n.setLeftChild(sucessor.getRightChild());

        if (sucessor.getRightChild() != null) {
            sucessor.getRightChild().setParent(n); //
        }
        sucessor.setRightChild(n);

        int newBalN = n.getFb() - 1 - Math.max(sucessor.getFb(), 0);
        int newBalSucessor = sucessor.getFb() - 1 + Math.min(newBalN, 0);

        n.setFb(newBalN);
        sucessor.setFb(newBalSucessor);
        return sucessor;
    }

    private void rotacaoDuplaDireita(No n) {
        No child = n.getLeftChild();
        rotacaoEsquerda(child);
        rotacaoDireita(n);
    }

    private void rotacaoDuplaEsquerda(No n) {
        No child = n.getRightChild();
        rotacaoDireita(child);
        rotacaoEsquerda(n);
    }

    public Object remocaoAVL(Object k){
        No n = pesquisa(raiz, k);
        // No pai = n.getParent();
        int quantFilhos = quantidadeFilhos(n);
        boolean isLeft = false;

        No pontoReferencia = null;
        // na remoção não se pode atualizar a partir do pai do no, mas sim a partir do substituto do no!!!!

        if(quantFilhos == 0){
            // aqui guardo a referencia do pai do no que será removido, pois dele será atualizado o fator de balanceamento
            pontoReferencia = n.getParent();
            if(pontoReferencia.getLeftChild() == n){
                isLeft = true;
            }

        } else if(quantFilhos == 1){
            // nesse caso o no tem um filho, então a referencia sera o pai do no removido
            // referencia = n.getLeftChild() != null ? n.getLeftChild() : n.getRightChild();
            pontoReferencia = n.getParent();
            if(pontoReferencia.getLeftChild() == n){
                isLeft = true;
            }
        } else if (quantFilhos == 2){
            // nesse caso o no tem dois filhos, então a referencia a ser salva sera o pai do no a substituir (que é o menor no a direita do no removido)
            No sucessor = encontrarMenorNo(n.getRightChild());
            pontoReferencia = encontrarMenorNo(n.getRightChild()).getParent();
            if (pontoReferencia.getLeftChild() == sucessor) {
                isLeft = true;
            }
        }

        remover(k);
        // Atualização começa do pai
        atualizaFbRemocao(isLeft, pontoReferencia);

        return k;
    }

    public void atualizaFbRemocao(boolean isLeft, No referencia){
        while (referencia != null) {
            if (isLeft) {
                referencia.setFb(referencia.getFb() - 1);
                System.out.println("fb do pai do no removido: " + referencia.getFb());
            } else {
                referencia.setFb(referencia.getFb() + 1);
                System.out.println("fb do pai do no removido: " + referencia.getFb());
            }

            if (referencia.getFb() == -2 || referencia.getFb() == 2) {
                rebalancear(referencia);
                break;
            }

            if (referencia.getFb() != 0) {
                break;
            }

            No prox = referencia.getParent();
            referencia = prox;
        }
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
                else {
                    No no = (No) tabela[i][j];
                    Object key = no.getKey();
                    System.out.printf("%s[%d]", key, no.getFb());
                    // System.out.printf("%s", key);

                    // System.out.printf("%3d[%d]", no.getKey(), no.getFb());
                }
            }
            System.out.println();
        }
    }

    public void preencheTabela(No no, Object[][] tabela, int linha, int coluna) {
        if (no == null)
            return;

        tabela[linha][coluna] = no;

        int offset = (int) Math.pow(2, tabela.length - linha - 2);

        if (no.getLeftChild() != null) {
            preencheTabela(no.getLeftChild(), tabela, linha + 1, coluna - offset);
        }

        if (no.getRightChild() != null) {
            preencheTabela(no.getRightChild(), tabela, linha + 1, coluna + offset);
        }
    }

}
