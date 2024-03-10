package ArvorePesquisaBinaria;

public class TesteArvoreBinaria {
    public static void main(String[] args) {
        Comparador comparador = new Comparador();

        ArvoreBinariaPesquisa arvore = new ArvoreBinariaPesquisa(comparador);

        No raiz = new No(null, 10);
        arvore.setRaiz(raiz);
        arvore.incluir(50);
        arvore.incluir(30);
        arvore.incluir(60);
        arvore.incluir(8);
        arvore.incluir(20);
        arvore.incluir(40);
        arvore.incluir(80);
        arvore.incluir(9);
        arvore.incluir(51);

//        arvore.incluir(7);
        arvore.incluir(70);
        arvore.incluir(90);

        System.out.println("Travessia:");
        arvore.emOrdem(arvore.getRaiz());

        System.out.println("====================");
        arvore.mostrar();
        arvore.remover(90);
        System.out.println("====================");
        arvore.mostrar();
        arvore.remover(80);
        System.out.println("====================");
        arvore.mostrar();
        arvore.remover(10);
        System.out.println("====================");
        arvore.mostrar();
        arvore.remover(20);
        System.out.println("====================");
        arvore.mostrar();
        arvore.incluir(65);
        System.out.println("====================");
        arvore.mostrar();
        arvore.remover(60);
        System.out.println("====================");
        arvore.mostrar();
        arvore.remover(9);
        System.out.println("====================");
        arvore.mostrar();
        arvore.remover(50);
        System.out.println("====================");
        arvore.mostrar();
    }
}

