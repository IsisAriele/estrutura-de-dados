package ArvoreRB;

public class ArvoreRB extends ArvoreBinariaBusca {
    public ArvoreRB() {
        super();
    }

    public void inserirRB(Object k) {
        NoRB novo = new NoRB(null, k);
        if (this.getRaiz() == null) {
            novo.setCor('n');
            this.setRaiz(novo);
        } else {
            novo = incluir(k);
            novo.setCor('r');
            verificaRegras(novo);
        }
    }

    public void verificaRegras(NoRB no) {
        NoRB pai = no.getParent();
        NoRB avo, tio;
        if (pai == null || pai.getCor() == 'n') {
            return;
        } else { // pai rubro
            if (pai.getParent() != null) {
                avo = pai.getParent();
                if (avo.getLeftChild() == pai) {
                    tio = avo.getRightChild();
                } else {
                    tio = avo.getLeftChild();
                }
                if (tio != null && tio.getCor() == 'r') {
                    recoloracao(no, pai, tio, avo);
                } else {
                    rotacoes(no, pai, tio, avo);
                }
            }
        }
    }

    public void recoloracao(NoRB no, NoRB pai, NoRB tio, NoRB avo) {
        // Aqui o pai e o tio do no serão pintados de negros e o avo de rubro
        pai.setCor('n');
        tio.setCor('n');
        if (avo != raiz) {
            avo.setCor('r');
        }
        verificaRegras(avo);
    }

    private void rotacoes(NoRB no, NoRB pai, NoRB tio, NoRB avo) {
        if (pai.getLeftChild() == no && avo.getLeftChild() == pai) {
            rotacaoDireita(avo);
        } else if (pai.getRightChild() == no && avo.getRightChild() == pai) {
            rotacaoEsquerda(avo);
        } else if (pai.getRightChild() == no && avo.getLeftChild() == pai) {
            rotacaoDireitaDupla(avo);
        } else if (pai.getLeftChild() == no && avo.getRightChild() == pai) {
            rotacaoEsquerdaDupla(avo);
        }
    }

    public NoRB rotacaoDireita(NoRB no) {
        NoRB sucessorNovoNegro = no.getLeftChild(); // filho que será o negro no topo
        if (no.getParent() == null) { // se o no era raiz, o que ocupará seu lugar será a raiz
            sucessorNovoNegro.setParent(null);
            setRaiz(sucessorNovoNegro);
        } else {
            sucessorNovoNegro.setParent(no.getParent()); // pai do nó alterado agr será o pai do filho direito
            if (no == no.getParent().getLeftChild()) { // se o no desb. for filho esquerdo do seu pai
                no.getParent().setLeftChild(sucessorNovoNegro); // o filho esquerdo do pai do no desb. será o filho
                // direito do no desb.
            } else {
                no.getParent().setRightChild(sucessorNovoNegro); // o filho direito do pai do no desb. será o filho
                // direito do no desb.
            }
        }
        no.setParent(sucessorNovoNegro);
        no.setLeftChild(sucessorNovoNegro.getRightChild());
        if (sucessorNovoNegro.getRightChild() != null) {
            sucessorNovoNegro.getRightChild().setParent(no); //
        }
        sucessorNovoNegro.setRightChild(no);
        sucessorNovoNegro.setCor('n');
        no.setCor('r');
        return sucessorNovoNegro;
    }

    private NoRB rotacaoEsquerda(NoRB no) {
        NoRB sucessorNovoNegro = no.getRightChild();
        if (no.getParent() == null) { // se o no era raiz, o que ocupará seu lugar será a raiz
            sucessorNovoNegro.setParent(null);
            setRaiz(sucessorNovoNegro);
        } else {
            sucessorNovoNegro.setParent(no.getParent()); // pai do nó alterado agr será o pai do filho esquerdo
            if (no == no.getParent().getLeftChild()) { // se o no desb. for filho esquerdo do seu pai
                no.getParent().setLeftChild(sucessorNovoNegro); // o filho esquerdo do pai do no desb. será o filho
                // direito do no desb.
            } else {
                no.getParent().setRightChild(sucessorNovoNegro); // o filho direito do pai do no desb. será o filho
                // direito do no desb.
            }
        }
        no.setParent(sucessorNovoNegro);
        no.setRightChild(sucessorNovoNegro.getLeftChild());
        if (sucessorNovoNegro.getLeftChild() != null) {
            sucessorNovoNegro.getLeftChild().setParent(no); //
        }
        sucessorNovoNegro.setLeftChild(no);
        sucessorNovoNegro.setCor('n');
        no.setCor('r');
        return sucessorNovoNegro;
    }

    private void rotacaoDireitaDupla(NoRB no) {
        rotacaoEsquerda(no.getLeftChild());
        rotacaoDireita(no);
    }

    private void rotacaoEsquerdaDupla(NoRB no) {
        rotacaoDireita(no.getRightChild());
        rotacaoEsquerda(no);
    }

    public void removerRB(Object k) {
        NoRB n = pesquisa(raiz, k);
        int quantFilhos = quantidadeFilhos(n);

        if (quantFilhos == 0) {
            if (n == raiz) {
                setRaiz(null);
                remover(k);
            }
            if (n.getCor() == 'r') {
                remover(k);
            } else if (n.getCor() == 'n') {
                remover(k);
                boolean isLeft = n == n.getParent().getLeftChild();
                checagemDuploNegro(n.getParent(), isLeft); // vai direto para a situação 3 (casos recursivos), is left aqui mostrará se n é filho esquerdo
            }

        } else if (quantFilhos == 1) {
            if (n == raiz) { // n só tem um filho e é a raiz. Neste caso ele só pode ter filho rubro pelas
                // regras, e este será pintado de preto
                setRaiz(n.getLeftChild() != null ? n.getLeftChild() : n.getRightChild()); // se n é a raiz, seu filho
                // será a raiz
                if (n.getRightChild() != null && n.getRightChild().getCor() == 'r') {
                    n.getRightChild().setCor('n');
                }
                remover(k);
            }
            if (n.getCor() == 'r') { // se tem 1 filho e é rubro o filho é negro pelas regras só substitui
                remover(k);
            } else if (n.getCor() == 'n') { // n é negro e seu filho pode ser rubro ou negro
                // Achar posição do seu filho
                NoRB filho;
                if(n.getLeftChild() != null){
                    filho = n.getLeftChild();
                } else {
                    filho = n.getRightChild();
                }

                if(filho.getCor() == 'r'){ // Prévia da situação 2, pinta filho de negro e acabou
                    filho.setCor('n');
                    remover(n.getKey());
                }else{ // Se filho tbm é negro, segue direto para situação 3
                    remover(k);
                    boolean isLeft = filho == n.getLeftChild();
                    checagemDuploNegro(n, isLeft); // is left aqui mostrará se seu unico filho é esquerdo
                }
            }

        } else { // casos que tem 2 filhos seguem para as 4 possíveis situações
            removerComRegras(n);
        }
    }

    private void removerComRegras(NoRB n) {

        NoRB sucessor = encontrarMenorNoRB(n.getRightChild());
        NoRB paiSucessor = sucessor.getParent();

        boolean isLeft = false;
        // Verifico se é filho esquerdo
        if (sucessor == sucessor.getParent().getLeftChild()) {
            isLeft = true;
        }

        // SITUAÇÃO 1: NO RUBRO E SUCESSOR RUBRO
        if (n.getCor() == 'r' && sucessor.getCor() == 'r' && sucessor != null) {
            remover(n.getKey());
            // SITUAÇÃO 2: NO NEGRO E SUCESSOR RUBRO
        } else if (n.getCor() == 'n' && sucessor.getCor() == 'r' && sucessor != null) {
            sucessor.setCor('n');
            remover(n.getKey());
            // SITUAÇÃO 3: NO NEGRO E SUCESSOR NEGRO
        } else if (n.getCor() == 'n' && sucessor.getCor() == 'n' && sucessor != null) {
            remover(n.getKey());
            checagemDuploNegro(paiSucessor, isLeft);

            // SITUAÇÃO 4: NO RUBRO E SUCESSOR NEGRO
        } else if (n.getCor() == 'r' && sucessor.getCor() == 'n' && sucessor != null) {
            sucessor.setCor('r');
            remover(n.getKey());
            checagemDuploNegro(paiSucessor, isLeft);

        }
    }

    private void checagemDuploNegro(NoRB current, boolean isLeft) { // na 1° vez recebo o pai do sucessor

        System.out.println(current);

        // CASO 3: No a ser removido é negro e seu sucessor é negro
        // CASO 3.1: se sucessor é filho esquerdo e o filho direito do seu pai é rubro
        if (isLeft == true
                && current.getRightChild() != null
                && current.getRightChild().getCor() == 'r') {
            current.getRightChild().setCor('n'); // irmão pintado de negro
            current.setCor('r'); // pai pintado de rubro
            rotacaoEsquerda(current);
            // continua para o proximo caso
            checagemDuploNegro(current, isLeft);
            // Caso espelhado
        } else if (isLeft == false
                && current.getLeftChild() != null
                && current.getLeftChild().getCor() == 'r') {
            current.getLeftChild().setCor('n'); // irmão pintado de negro
            current.setCor('r'); // pai pintado de rubro
            rotacaoDireita(current);
            checagemDuploNegro(current, isLeft);
        }
        // CASO 3.2A: irmão negro e filhos do irmão negros; e pai negro: pintar irmão de
        // rubroe continuar
        if (isLeft == true
                && current.getRightChild() != null
                && current.getRightChild().getCor() == 'n'
                && current.getCor() == 'n'
                && ((current.getRightChild().getRightChild() != null && current.getRightChild().getRightChild().getCor() == 'n') || current.getRightChild().getRightChild() == null)
                && ((current.getRightChild().getLeftChild() != null && current.getRightChild().getLeftChild().getCor() == 'n') || current.getRightChild().getLeftChild() == null)
        ) {
            current.getRightChild().setCor('r');
            if(current.getParent() != null) {
                checagemDuploNegro(current.getParent(), isLeft); // Aqui vai subindo o duplo negro
            } else{
                return;
            }
            // Caso espelhado
        } else if (isLeft == false
                && current.getLeftChild() != null
                && current.getLeftChild().getCor() == 'n'
                && current.getCor() == 'n'
                && ((current.getLeftChild().getRightChild() != null && current.getLeftChild().getRightChild().getCor() == 'n') || current.getLeftChild().getRightChild() == null)
                && ((current.getLeftChild().getLeftChild() != null && current.getLeftChild().getLeftChild().getCor() == 'n') || current.getLeftChild().getLeftChild() == null)
        ) {
            current.getLeftChild().setCor('r');
            if(current.getParent() != null){
                checagemDuploNegro(current.getParent(), isLeft); // Aqui vai subindo o duplo negro
            } else {
                return;
            }
        }
        // CASO 3.2B: Irmão é negro com filhos negros e pai rubro: pintar irmão de rubro
        // e pai de negro
        if (isLeft == true
                && current.getRightChild() != null
                && current.getRightChild().getCor() == 'n'
                && current.getCor() == 'r'
                && ((current.getRightChild().getRightChild() != null && current.getRightChild().getRightChild().getCor() == 'n') || current.getRightChild().getRightChild() == null)
                && ((current.getRightChild().getLeftChild() != null && current.getRightChild().getLeftChild().getCor() == 'n') || current.getRightChild().getLeftChild() == null)
        ) {
            current.getRightChild().setCor('r');
            current.setCor('n');
            return; // Caso terminal!
            // Caso espelhado
        } else if (isLeft == false
                && current.getLeftChild() != null
                && current.getLeftChild().getCor() == 'n'
                && current.getCor() == 'r'
                && ((current.getLeftChild().getRightChild() != null && current.getLeftChild().getRightChild().getCor() == 'n') || current.getLeftChild().getRightChild() == null)
                && ((current.getLeftChild().getLeftChild() != null && current.getLeftChild().getLeftChild().getCor() == 'n') || current.getLeftChild().getLeftChild() == null)
        ) {
            current.getLeftChild().setCor('r');
            current.setCor('n');
            return; // Caso terminal!
        }
        // CASO 3.3: irmão negro, irmão com filho esquerdo rubro e irmão com filho
        // direito negro
        // Rotação direita simples em irmão
        // irmão fica com cor r e filhho esquerdo com cor n
        if (isLeft == true
                && current.getRightChild() != null
                && current.getRightChild().getCor() == 'n'
                && ((current.getRightChild().getRightChild() != null && current.getRightChild().getRightChild().getCor() == 'n') || current.getRightChild().getRightChild() == null)
                && current.getRightChild().getLeftChild() != null
                && current.getRightChild().getLeftChild().getCor() == 'r') {
            current.getRightChild().setCor('r');
            current.getRightChild().getLeftChild().setCor('n');
            rotacaoDireita(current.getRightChild());
            checagemDuploNegro(current, isLeft);
            // Caso espelhado
        } else if (isLeft == false
                && current.getLeftChild() != null
                && current.getLeftChild().getCor() == 'n'
                && current.getLeftChild().getRightChild() != null
                && current.getLeftChild().getRightChild().getCor() == 'r'
                && ((current.getLeftChild().getLeftChild() != null && current.getLeftChild().getLeftChild().getCor() == 'n') || current.getLeftChild().getLeftChild() == null)) {
            current.getLeftChild().setCor('r');
            current.getLeftChild().getRightChild().setCor('n');
            rotacaoEsquerda(current.getLeftChild());
            checagemDuploNegro(current, isLeft);
        }
        // CASO 3.4: Irmão negro e irmão com filho direito rubro
        if (isLeft == true
                && current.getRightChild() != null
                && current.getRightChild().getCor() == 'n'
                && current.getRightChild().getRightChild() != null
                && current.getRightChild().getRightChild().getCor() == 'r') {
            char corPai = current.getCor();
            current.getRightChild().setCor(corPai);
            current.setCor('n');
            current.getRightChild().getRightChild().setCor('n');
            rotacaoEsquerda(current);
            return; // Caso terminal!
            // Caso espelhado
        } else if (isLeft == false
                && current.getLeftChild() != null
                && current.getLeftChild().getCor() == 'n'
                && current.getLeftChild().getLeftChild() != null
                && current.getLeftChild().getLeftChild().getCor() == 'r') {
            char corPai = current.getCor();
            current.getLeftChild().setCor(corPai);
            current.setCor('n');
            current.getLeftChild().getLeftChild().setCor('n');
            rotacaoDireita(current);
            return; // Caso terminal!
        }

        if (current == raiz) {
            return;
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
                    NoRB no = (NoRB) tabela[i][j];
                    Object key = no.getKey();
                    char cor = no.getCor();
                    System.out.printf("%s|%c", key, cor);
                }
            }
            System.out.println();
        }
    }

    public void preencheTabela(NoRB no, Object[][] tabela, int linha, int coluna) {
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
