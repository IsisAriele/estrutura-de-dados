package ArvoreSimples;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArvoreSimples arvore = new ArvoreSimples(0);

        // Adicionando filhos
        No raiz = arvore.root();

        No filho1 = arvore.addChild(raiz, 1);
        No filho2 = arvore.addChild(raiz, 2);

        No filho11 = arvore.addChild(filho1, 11);
        No filho12 = arvore.addChild(filho1, 12);

        No filho21 = arvore.addChild(filho2, 21);
        No filho22 = arvore.addChild(filho2, 22);

        No filho211 = arvore.addChild(filho21, 211);
        No filho2111 = arvore.addChild(filho211, 2111);
        No filho2112 = arvore.addChild(filho211, 2112);
        arvore.printTree(raiz, 0);

        //Verificando altura da arvore
        System.out.println(arvore.height(raiz));
        System.out.println("-------------------");

        // Trocando elementos
        arvore.swapElements(filho12, filho211);
        arvore.printTree(raiz, 0);

        System.out.println("-------------------");

        // Iterando sobre todos os nós
        Iterator nos = arvore.Nos();
        while (nos.hasNext()){
            System.out.println(nos.next());
        }

        System.out.println("-------------------");

        // Iterando sobre todos os elementos
        Iterator elements = arvore.elements();
        while (elements.hasNext()){
            System.out.println(elements.next());
        }
    }
}
