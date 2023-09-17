package PilhaVector;

public class TestePilha {
    public static void main(String[] args) {
        PilhaVector pp = new PilhaVector();
        System.out.println("Inserindo");
        for(int f = 0; f < 10; f++){
            pp.push(f);
        }
        pp.listar();
        System.out.println("retirando");
        for(int f = 0; f < 5; f++){

            System.out.println(pp.pop());
        }
        pp.listar();
    }
}
