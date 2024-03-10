package ArvoreSimples;

import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreSimples {
    No raiz;
    int tamanho;
    public ArvoreSimples(Object o) {
        raiz = new No(null, o);
        tamanho = 1;
    }

    public No root() {
        return raiz;
    }

    public No parent(No v){
        return (v.parent());
    }

    public Iterator children(No v) {
        return v.children();
    }

    public boolean isInternal(No v) {
        return (v.childrenNumber() > 0);
    }

    public boolean isExternal(No v) {
        return (v.childrenNumber() == 0);
    }

    public boolean isRoot(No v) {
        return v == raiz;
    }

    public No addChild(No v, Object o) {
        No novo = new No(v, o);
        v.addChild(novo);
        tamanho++;
        return novo;
    }

    public Object remove(No v) throws InvalidNoException {
        No pai = v.parent();
        if (pai != null || isExternal(v))
            pai.removeChild(v);
        else
             throw new InvalidNoException("Nó inválido.");
        Object o = v.element();
        tamanho--;
        // Retorno o elemento removido
        return o;
    }

    public void swapElements(No v, No w) {
        Object temp = v.element();
        v.setElement(w.element());
        w.setElement(temp);
    }

    public int depth(No v) {
        int profundidade = profundidade(v);
        return profundidade;
    }

    private int profundidade(No v) {
        if (v == raiz)
            return 0;
        else
            return 1 + profundidade(v.parent());
    }

    public int height(No v) {
        //distância mais longa entre esse nó e uma de suas folhas (nós externos)
        if (isExternal(v))
            return 0;
        else {
            int h = 0;
            Iterator filhos = children(v);
            while(filhos.hasNext()){
                h = Math.max(h, height((No)filhos.next()));
            }
            //height((No)filhos.next())-> Chamada recursiva para calcular a altura do filho atual.
            //Math.max(h, ... )-> Mantém o valor máximo entre a altura atual e a altura do filho.
            return 1 + h;
        }
    }

    public Iterator elements() {
        ArrayList<Object> elems = new ArrayList<>();
        collectElements(root(), elems);
        return elems.iterator();
    }

    public void collectElements(No v, ArrayList<Object> elems) {
        elems.add(v.element()); // Adiciona o elemento do no na lista elems
        Iterator<No> e = v.children(); // Guarda iterator dos filhos do no
        while (e.hasNext()) { // enquanto tiver filho ele chama recursivamente o metodo para cada um dos filhos
            collectElements(e.next(), elems);
        }
    }

    public Iterator Nos() {
        ArrayList<No> nos = new ArrayList<>();
        collectNos(root(), nos);
        return nos.iterator();
    }

    public void collectNos(No v, ArrayList<No> nos) {
        nos.add(v);

        Iterator<No> c = v.children();
        while (c.hasNext()) {
            collectNos(c.next(), nos);
        }
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return false;
    }

    public Object replace(No v, Object o) {
        //Substitui o elemento de um no
        v.setElement(o);
        return o;
    }

    public void printTree(No v, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(v.element());

        Iterator<No> c = v.children();
        while (c.hasNext()) {
            printTree(c.next(), level + 1);
        }

    }
}
