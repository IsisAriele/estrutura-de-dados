package DuasPilhas;

import DuasPilhas.DuasPilhas;

public class TesteDuasPilhas {
    public static void main(String[] args) {
        DuasPilhas pp = new DuasPilhas(1);

        for(int f = 0; f < 10; f++){
            System.out.println("Inserindo vermelho");
            pp.pushVermelho(f);
            System.out.println("Inserindo Preto");
            pp.pushPreto(f);
        }
        pp.listar();

        System.out.println("Inserindo Preto");
        for(int f = 20; f < 31; f++){
            pp.pushPreto(f);
        }

        pp.listar();

        System.out.println("Inserindo Vermelho");
        for(int f = 13; f <= 13; f++){
            pp.pushVermelho(f);
        }

        pp.listar();

        System.out.println("Retirando vermelho");
        for(int f = 0; f < 5; f++){
            System.out.println("O objeto retirado da pilha vermelha foi: " + pp.popVermelho());
        }
        pp.listar();

        System.out.println("Retirando preto");
        for(int f = 0; f < 5; f++){
            System.out.println("O objeto retirado da pilha preta foi:" + pp.popPreto());
        }

        pp.listar();

        System.out.println("O último objeto na pilha colorida preta é: " + pp.topPreto());
        System.out.println("O tamanho da pilha colorida preta é: " + pp.sizePreto());
        System.out.println("O último objeto na pilha colorida vermelha é: " + pp.topVermelho());
        System.out.println("O tamanho da pilha colorida vermelha é: " + pp.sizeVermelho());
    }
}
