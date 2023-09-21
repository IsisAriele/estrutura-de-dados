package FilaComDuasPilhas;


public class FilaTeste {
    public static void main(String[] args) {
        FilaComDuasPilhas pp = new FilaComDuasPilhas(10);
        System.out.println("Inserindo");
        for(int f = 0; f < 10; f++){
            pp.enqueue(f);
        }

        pp.listar();
        // 0 1 2 3 4 5 6 7 8 9

        System.out.println("retirando");
        for(int f = 0; f < 3; f++){
            System.out.println(pp.dequeue());
        }

        pp.listar();
        // 3 4 5 6 7 8 9

        System.out.println("Inserindo");
        for(int f = 0; f < 3; f++){
            pp.enqueue(f);
        }

        pp.listar();
        // 3 4 5 6 7 8 9 0 1 2

        System.out.println(pp.first());
        System.out.println(pp.size());
    }
}
