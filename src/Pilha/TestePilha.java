package Pilha;

public class TestePilha {

    public static void main(String[] args) {
//        PilhaArray pp = new PilhaArray(1);
//        System.out.println("Inserindo");
//        for(int f = 0; f < 10; f++){
//            pp.push(f);
//        }
//
//        System.out.println("retirando");
//        for(int f = 0; f < 10; f++){
//            System.out.print(f);
//            System.out.println(" - " + pp.pop());
//        }
        PilhaArray pp = new PilhaArray(1);


        System.out.println("Inserindo");
        long startTime = System.currentTimeMillis();
        for(int f = 0; f < 20; f++){
            pp.push(f);
        }
        long endTime = System.currentTimeMillis();
        long tempoExecucao = endTime - startTime;
        System.out.println("tempo " + tempoExecucao);

        pp.listar();

        pp.pop();
        pp.listar();
        pp.pop();
        pp.listar();
    }
}
