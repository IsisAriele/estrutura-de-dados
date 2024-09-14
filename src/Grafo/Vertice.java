package Grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private Object valor;
    private List<Aresta> verticesAdjacentes;

    public Vertice(Object valor) {
        this.valor = valor;
        this.verticesAdjacentes = new ArrayList<>();
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void inserirAresta(Aresta aresta) {
        this.verticesAdjacentes.add(aresta);
    }

    public List<Aresta> getverticesAdjacentes() {
        return verticesAdjacentes;
    }
}
