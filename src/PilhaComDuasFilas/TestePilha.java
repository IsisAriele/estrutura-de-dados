package PilhaComDuasFilas;

public class TestePilha {
    public static void main(String[] args) {
        PilhaComDuasFilas pp = new PilhaComDuasFilas(1);
        System.out.println("Inserindo");
        for (int f = 0; f < 11; f++) {
            pp.push(f);
        }
        pp.listar();
        System.out.println("Inserindo");
        for (int f = 0; f < 3; f++) {
            pp.push(f);
        }
        pp.listar();

        System.out.println(pp.top());
        System.out.println(pp.size());

        System.out.println("retirando");
        for (int f = 0; f < 3; f++) {
            System.out.println(pp.pop());
        }

    }
}
