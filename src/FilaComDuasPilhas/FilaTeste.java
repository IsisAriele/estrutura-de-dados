package FilaComDuasPilhas;


public class FilaTeste {
    public static void main(String[] args) {
        FilaComDuasPilhas pp = new FilaComDuasPilhas(11);
        System.out.println("Inserindo");
        for (int f = 0; f < 10; f++) {
            pp.enqueue(f);
        }
        pp.listar();


        System.out.println("retirando");
        for (int f = 0; f < 3; f++) {
            System.out.println(pp.dequeue());
        }
        System.out.println("retirando");
        for (int f = 0; f < 3; f++) {
            System.out.println(pp.dequeue());
        }
        pp.listar();


        System.out.println("Inserindo");
        for (int f = 0; f < 3; f++) {
            pp.enqueue(f);
        }
        pp.listar();

        System.out.println(pp.size());
        System.out.println(pp.first());
    }
}
