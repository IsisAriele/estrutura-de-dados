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


        // Inserções remoções passando os vertices
        System.out.println("\n Inserções remoções passando os vertices");
        Vertice v = new Vertice("D");
        Vertice w = new Vertice("E");
        Vertice x = new Vertice("F");
        Vertice y = new Vertice("G");

        grafo.inserirVertice(v); // D
        grafo.inserirVertice(w); // E
        grafo.inserirVertice(x); // F
        grafo.inserirVertice(y); // G
        grafo.inserirAresta(v, y, 5, true);
        grafo.inserirAresta(v, w, 10, true);
        grafo.inserirAresta(x, w, 15, true);

        
        grafo.mostrarGrafo();

        grafo.removerVertice(w);
        grafo.mostrarGrafo();

        System.out.println("\n Fazendo a remoção direta de aresta");
        // Cria a aresta que liga os vértices v e y
        // Aresta aresta = new Aresta(v, y, 5, true);

        // Remove a aresta criada
        grafo.removerAresta(v, y);

        // Mostra o grafo após a remoção
        grafo.mostrarGrafo();

        System.out.println("\n Mostrando lista de arestas");

        grafo.arestas().forEach(aresta -> {
            System.out.println(aresta.getVerticeOrigem().getValor() + " -> " + aresta.getVerticeDestino().getValor());
        });

        
    }
}
