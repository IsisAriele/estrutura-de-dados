package Grafo;

public class MainGrafo {
    public static void main(String[] args) throws Exception {
        Grafo grafo = new Grafo();
        grafo.inserirVertice("A");
        grafo.inserirVertice("B");
        grafo.inserirVertice("C");

        grafo.inserirAresta(0, 1, 5, true); // A -> B
        grafo.inserirAresta(0, 2, 7, true); // A -> C

        grafo.mostrarGrafo();
    }
}
