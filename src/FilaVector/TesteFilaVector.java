package FilaVector;

public class TesteFilaVector {
    public static void main(String[] args) {
        FilaVector pp = new FilaVector();
        System.out.println("Inserindo");
        for(int f = 0; f < 10; f++){
            pp.enqueue(f);
        }
        pp.listar();
        System.out.println("retirando");
        for(int f = 0; f < 5; f++){
            System.out.println(pp.dequeue());
        }
        pp.listar();
        System.out.println(pp.first());
    }
}
