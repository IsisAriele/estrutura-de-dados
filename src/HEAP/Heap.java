package HEAP;

public class Heap {

    private Node root;
    public Node lastNode;
    private int size = 0;

    public Heap(Object key) {
        this.root = new Node(null, key);
        this.size++;
        this.lastNode = root;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node root() {
        return root;
    }

    public Object min() {
        return root.getKey();
    }

    public Object key(Node node) {
        return node.getKey();
    }

    public Object value(Node node) {
        return node.getValue();
    }

    private boolean isRoot(Node node) {
        return node.equals(root);
    }

    private void swapKeys(Node no1, Node no2) {
        Object aux = no1.getKey();
        no1.setKey(no2.getKey());
        no2.setKey(aux);
    }

    public Node insert(Object key) {
        Node newNodeParent = nextNode(); // o pai disponivel para adotar
        Node newNode = new Node(newNodeParent, key); // instancia do novo nó a ser inserido

        if (newNodeParent.getLeftChild() == null) {
            newNodeParent.setLeftChild(newNode); //inserção na esquerda do nó pai
        } else {
            newNodeParent.setRightChild(newNode); //inserção na direita do nó pai
        }

        upHeap(newNode);
        this.lastNode = newNode; // atualiza o o último no
        this.size++;
        return newNode;
    }

    private void upHeap(Node node) {
        // Enquanto não for a raiz e a chave for menor que a chave do pai,
        // vai trocando os nós entre pai e filho, subindo o nó.
        while (!isRoot(node) && (int) node.getKey() < (int) node.getParent().getKey()) {
            swapKeys(node, node.getParent());
            node = node.getParent();
        }
    }

    // Método auxiliar para obter o próximo nó a ser adicionado
    private Node nextNode() {
        Node atual = lastNode;

        if (isRoot(atual)) { // Se for raiz, retorna raiz
            return atual;
        }
        // enquanto não for a raiz da árvore e até que o nó atual
        // não seja o filho esquerdo do seu pai, o atual vira o pai do nó
        while (!isRoot(atual) && !atual.getParent().getLeftChild().equals(atual)) {
            atual = atual.getParent();
        }
        // se não é a raiz e o filho direito do pai for nulo, tem espaço, retorna o pai
        if (!isRoot(atual) && atual.getParent().getRightChild() == null) {
            return atual.getParent();
            // se não, não é a raiz e o filho direito do pai não for nulo,
            // pega o filho direito do pai atual
        } else if (!isRoot(atual) && atual.getParent().getRightChild() != null) {
            atual = atual.getParent().getRightChild();
        }
        // procurando o filho mais a esquerda partindo do atual
        while (atual.getLeftChild() != null) {
            atual = atual.getLeftChild();
        }

        return atual;
        // Dessa forma atual resulta sempre no pai do novo nó a ser inserido
    }

    public Object removeMin() {
        Object min = root.getKey();
        // faz a troca das chaves para depois só remover o último no
        swapKeys(root, lastNode);
        // atualizar o novo ultimo no
        Node newLastNode = newLastNode();
        // remover o antigo último no que tem a chave do root
        if (lastNode.getParent().getRightChild() == null) {
            // Se filho da direita for nulo, se remove, pois ele é o esquerdo
            lastNode.getParent().setLeftChild(null);
        } else {
            // se o filho da direita não for nulo, se remove, pois ele é o da direita
            lastNode.getParent().setRightChild(null);
        }

        downHeap();
        this.size--;
        this.lastNode = newLastNode;

        return min;
    }

    // Método auxiliar para obter o novo último
    private Node newLastNode() {
        Node atual = lastNode;
        // verifica se o último é a raiz
        if (isRoot(atual)) {
            return atual;
        }
        // enquanto não for a raiz ou o nó pai do nó atual não tiver um filho direito.
        while (!isRoot(atual) && atual.getParent().getRightChild() == null) {
            atual = atual.getParent();
        }

        if (!isRoot(atual) && atual.getParent().getLeftChild() == null) {
            // se o irmão esquerdo for nulo, retorna o pai dele
            return atual.getParent();
        } else if (!isRoot(atual) && atual.getParent().getLeftChild() != null) {
            // se o irmão dele não é nulo, então atual vira o irmão dele (filho de esquerda do pai)
            atual = atual.getParent().getLeftChild();
        }

        while (atual.getRightChild() != null) {
            atual = atual.getRightChild();
        }

        return atual;
        // retornar o atual que é o novo ultimo nó.
    }

    // Método auxiliar para restaurar a propriedade heap-order após a remoção
    private void downHeap() {
        Node node = root;
        Node oldNode = root;

        while (!node.externo()) {
            node = down(node);
            System.out.println(node);
            if ((int) node.getKey() < (int) oldNode.getKey()) {
                swapKeys(oldNode, node);
            } else {
                break;
            }
        }
    }

    // Método auxiliar para obter o próximo nó durante o downHeap
    private Node down(Node node) {
        // vai basicamente procurar um possível menor nó filho
        // sempre qeu voltar pra esse metodo no while vai procurar um no menor que o root
        if (node.interno()) {
            if (node.getLeftChild() == null && node.getRightChild() != null) {
                node = node.getRightChild();
            } else if (node.getLeftChild() != null && node.getRightChild() == null) {
                node = node.getLeftChild();
            } else if ((int) node.getLeftChild().getKey() < (int) node.getRightChild().getKey()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return node;
    }

    public int altura(Node no) {
        if (no == null || no.externo()) {
            return 0;
        }
        int alturaEsquerda = altura(no.getLeftChild());
        int alturaDireita = altura(no.getRightChild());

        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public void mostrar() {
        int h = altura(root);
        int nLinhas = h + 1;
        double nColunas = Math.pow(2, h + 1);

        Object[][] tabela = new Object[nLinhas][(int) nColunas];
        preencheTabela(root, tabela, 0, (int) nColunas / 2);

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

    private void preencheTabela(Node no, Object[][] tabela, int linha, int coluna) {
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
}
