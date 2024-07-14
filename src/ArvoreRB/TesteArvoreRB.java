package ArvoreRB;

public class TesteArvoreRB {
    public static void main(String[] args) {
        ArvoreRB arvore = new ArvoreRB();

        // Teste 1 - inserção e apenas recolorir
//        NoRB raiz = new NoRB(null, 30);
//
//        arvore.setRaiz(raiz);
//        arvore.inserirRB(13);
//        arvore.inserirRB(53);
//        arvore.mostrar();
//        arvore.inserirRB(8);
//        arvore.mostrar();
//        arvore.inserirRB(23);
//        arvore.inserirRB(43);
//        arvore.inserirRB(83);
//        arvore.inserirRB(7);
//        arvore.mostrar();
//        arvore.inserirRB(63);
//        arvore.inserirRB(93);
//        arvore.mostrar();
//        arvore.inserirRB(96);
//
//        arvore.mostrar();

        // Teste 2 - inserção e rotação a direita
//        NoRB raiz = new NoRB(null, 30);
//        arvore.setRaiz(raiz);
//        arvore.inserirRB(20);
//        arvore.mostrar();
//        arvore.inserirRB(10);
//        arvore.mostrar();

        // Teste 3 - inserção e rotação a esquerda
//        NoRB raiz = new NoRB(null, 30);
//        arvore.setRaiz(raiz);
//        arvore.inserirRB(40);
//        arvore.mostrar();
//        arvore.inserirRB(50);
//        arvore.mostrar();

        // Teste 4 - inserção e rotação dupla direita
//        NoRB raiz = new NoRB(null, 30);
//        arvore.setRaiz(raiz);
//        arvore.inserirRB(60);
//        arvore.mostrar();
//        arvore.inserirRB(40);
//        arvore.mostrar();

//_______________________________________________________
        //Teste 5 - inserção e rotação dupla esquerda
        NoRB raiz = new NoRB(null, 30);
        arvore.setRaiz(raiz);
        arvore.inserirRB(10);
        arvore.mostrar();
        arvore.inserirRB(20);
        arvore.mostrar();

        // TESTES ADICIONAIS
        // Teste 5.2 - inserção e recolorir
        arvore.inserirRB(25);
        arvore.mostrar();

        // Teste 5.3 - inserção e rotação direita dupla
        arvore.inserirRB(26);
        arvore.mostrar();

        // TESTES ALEATÓRIOS DE REMOÇÃO

        // Situação 2 - no negro e sucessor rubro
        arvore.removerRB(26);
        arvore.mostrar();

        // Situação 3.1: sucessor negro com irmão rubro
        arvore.inserirRB(40);
        arvore.mostrar();
        arvore.inserirRB(45);
        arvore.mostrar();

        // arvore.remover(20);
        arvore.inserirRB(60);
        arvore.mostrar();
        arvore.inserirRB(70);
        arvore.mostrar();


        // teste 4: 45 rubro e seu sucessor 60 é negro
        arvore.removerRB(45);
        arvore.mostrar();
//______________________________________________________
        // TESTES ORGANIZADOS DE REMOÇÃO:

        // Situação 1: No rubro e sucessor rubro
        arvore.inserirRB(24);
        arvore.mostrar();
        arvore.removerRB(20);
        arvore.mostrar();

        // Situação 2: No negro e sucessor rubro
        arvore.removerRB(60);
        arvore.mostrar();

        // Situação 3 - caso 1: sucessor negro com irmão rubro
        arvore.removerRB(40);
        arvore.mostrar();
        arvore.removerRB(30);
        arvore.mostrar();

        // Mais testes serão implementados para as outras situações

    }
}
