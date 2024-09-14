package Grafo;

public class Aresta {
    private Vertice verticeOrigem;
    private Vertice verticeDestino;
    private Object valor;
    private boolean isDirecionada;

    // Construtor para arestas não direcionadas
    public Aresta(Vertice verticeOrigem, Vertice verticeDestino, Object valor) {
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        this.valor = valor;
        this.isDirecionada = false;
    }

    // Construtor para arestas direcionadas
    public Aresta(Vertice verticeOrigem, Vertice verticeDestino, Object valor, boolean isDirecionada) {
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        this.valor = valor;
        this.isDirecionada = isDirecionada;
    }

    public Vertice getVerticeOrigem() {
        return this.verticeOrigem;
    }

    public Vertice getVerticeDestino() {
        return this.verticeDestino;
    }

    public Object getValor() {
        return this.valor;
    }

    public boolean isDirecionada() {
        return this.isDirecionada;
    }

    public void setDirecionada(boolean isDirecionada) {
        this.isDirecionada = isDirecionada;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
