package Skiplist;

import java.util.Random;

public class SkipList {
    private Node head;
    private int maxLevel;
    private int size;
    private Random random;

    public SkipList() {
        // Inicializa a SkipList com um nó head contendo valores mínimos
        this.head = new Node(Integer.MIN_VALUE, -1);
        this.maxLevel = 1;
        this.size = 0;
        this.random = new Random();
    }

    public void insert(int key, int value) {
        // Gera um nível aleatório para o novo nó
        int level = randomLevel();
        Node newNode = new Node(value, key);

        // Atualiza head se o novo nível for maior que o nível
        // máximo atual e atualiza max level
        if (level > maxLevel) {
            updateHead(level);
            maxLevel = level;
        }

        Node current = head;

        for (int i = maxLevel - 1; i >= 0; i--) {
            // Percorre os níveis até encontrar a posição correta para inserir o novo nó
            while (current.next != null && current.next.key < key) {
                current = current.next;
            }

            if (i < level) {
                // Insere o novo nó neste nível
                newNode.next = current.next;
                current.next = newNode;

                // Atualiza os links para o novo nó
                if (i > 0) {
                    newNode.down = newNodeDown(newNode);
                }

                newNode = newNodeDown(newNode);
            }

            // Move para o próximo nível inferior
            if (current.down != null) {
                current = current.down;
            }
        }
        size++;
    }

    public boolean search(int key) {
        Node current = head;

        for (int i = maxLevel - 1; i >= 0; i--) {
            // Percorre os níveis até encontrar a posição correta para a chave
            while (current.next != null && current.next.key < key) {
                current = current.next;
            }

            // Verifica se a chave foi encontrada neste nível
            if (current.next != null && current.next.key == key) {
                return true;
            }

            // Move para o próximo nível inferior
            if (current.down != null) {
                current = current.down;
            }
        }

        return false;
    }

    private int randomLevel() {
        // Gera aleatoriamente um nível para um novo nó
        int level = 1;
        while (random.nextDouble() < 0.5 && level < maxLevel + 1) {
            level++;
        }
        return level;
    }

    private Node newNodeDown(Node node) {
        // Cria um novo nó abaixo do nó fornecido
        Node newNode = new Node(node.value, node.key);
        newNode.up = node;
        node.down = newNode;
        return newNode;
    }

    private void updateHead(int newLevel) {
        // Atualiza a cabeça para um novo nível
        Node newHead = new Node(Integer.MIN_VALUE, -1);
        newHead.down = head;
        head.up = newHead;
        head = newHead;
        maxLevel = newLevel;
    }

    public void remove(int key) {
        Node current = head;
        Node aux = null;

        for (int i = maxLevel - 1; i >= 0; i--) {
            // Percorre os níveis até encontrar a posição correta para remover o nó
            while (current.next != null && current.next.key < key) {
                current = current.next;
            }

            // Verifica se o nó a ser removido foi encontrado neste nível
            if (current.next != null && current.next.key == key) {
                aux = current.next;
                current.next = current.next.next; // Remove o nó auxiliar neste nível
            }

            // Move para o próximo nível inferior
            if (current.down != null) {
                current = current.down;
            }
        }

        // Remove possíveis duplicatas nos níveis inferiores
        removeDuplicates(aux);
        size--;
    }

    private void removeDuplicates(Node aux) {
        // Remove possíveis duplicatas nos níveis inferiores
        while (aux.down != null) {
            aux = aux.down;
            Node current = head;

            // Encontra o nó duplicado e o remove neste nível
            while (current.next != null && current.next != aux) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next; // Remove o nó duplicado neste nível
            }
        }
    }

    public void display() {
        Node current = head;

        // Encontra o nó mais baixo à esquerda
        while (current.down != null) {
            current = current.down;
        }

        int levelNum = 0;

        while (current != null) {
            // Exibe os nós em cada nível
            System.out.print("Nível " + levelNum + ": ");
            Node temp = current.next;

            while (temp != null) {
                System.out.print("(" + temp.key + ", " + temp.value + ") ");
                temp = temp.next;
            }

            System.out.println();
            current = current.up;
            levelNum++;
        }
    }
}
