package ArvoreAVL;

public class TesteAVL {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        No raiz = new No(null, 50);
        arvore.setRaiz(raiz);
        arvore.inserirAVL(60);
        arvore.inserirAVL(70);
        arvore.inserirAVL(52);
        arvore.mostrar();
        arvore.inserirAVL(51);
        arvore.mostrar();
        arvore.inserirAVL(65);

        arvore.inserirAVL(63);
        arvore.mostrar();

        arvore.remocaoAVL(63);
        arvore.mostrar();

        arvore.inserirAVL(80);
        arvore.mostrar();

        arvore.inserirAVL(63);
        arvore.mostrar();
        arvore.inserirAVL(67);
        arvore.mostrar();
        arvore.remocaoAVL(60);
        arvore.mostrar();
        arvore.inserirAVL(68);
        arvore.mostrar();

        arvore.inserirAVL(90);
        arvore.mostrar();
        arvore.inserirAVL(30);
        arvore.mostrar();

        arvore.remocaoAVL(70);
        arvore.mostrar();
        arvore.remocaoAVL(90);
        arvore.mostrar();

        //Exemplo que mostra rotação dupla esquerda
        //No raiz = new No(null, 2);
        //arvore.setRaiz(raiz);
        //arvore.inserirAVL(1);
        //arvore.inserirAVL(5);
        //arvore.inserirAVL(4);
        //arvore.inserirAVL(9);
        //arvore.mostrar();
        //arvore.inserirAVL(3);
        //arvore.mostrar();
    }
}
