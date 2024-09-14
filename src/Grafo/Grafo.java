package Grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Grafo {
    private Vector<Vertice> listaVertices;

    public Grafo() {
        this.listaVertices = new Vector<>();
    }

    public void inserirVertice(Object valor) {
        Vertice v = new Vertice(valor);
        this.listaVertices.add(v); 
    }

    public void inserirAresta(int vOrigem, int vDestino, Object valor, boolean isDirecionada) {
        // Obter os vértices de origem e destino por meio dos índices da lista
        Vertice verticeOrigem = this.listaVertices.get(vOrigem);
        Vertice verticeDestino = this.listaVertices.get(vDestino);
        
        Aresta a = new Aresta(verticeOrigem, verticeDestino, valor, isDirecionada);
        verticeOrigem.inserirAresta(a);
        // se não for direcionada, inserir a aresta no vértice destino. 
        // Pois assim, será inserida como direcionada em ambos os vértices
        if (!isDirecionada) {
            Aresta a2 = new Aresta(verticeDestino, verticeOrigem, valor, false);
            verticeDestino.inserirAresta(a2);
        }
    }

    // Retorna um array armazenando os vértices finais da aresta e.
    public Vertice[] finalVertices(Aresta e) {
        return new Vertice[]{e.getVerticeOrigem(), e.getVerticeDestino()};
    }

    // Retorna o vértice oposto de v em relação à aresta e.
    public Vertice oposto(Vertice v, Aresta e) {
        if (e.getVerticeOrigem().equals(v)) {
            return e.getVerticeDestino();
        } else if (e.getVerticeDestino().equals(v)) {
            return e.getVerticeOrigem();
        } else {
            return null;
        }
    }

    // Retorna se os vértices v e w são adjacentes.
    public boolean saoAdjacentes(Vertice v, Vertice w) {
        return v.getverticesAdjacentes().stream()
                .anyMatch(a -> finalVertices(a)[0].equals(w) || finalVertices(a)[1].equals(w));
    }

    public void substituirVertice(Vertice v, Object valor) {
        v.setValor(valor);
    }

    public void substituirAresta(Aresta e, Object valor) {
        e.setValor(valor);
    }

    public void inserirVertice(Vertice v) {
        this.listaVertices.add(v);
    }

    public void inserirAresta(Vertice v, Vertice w, Object valor) {
        Aresta a = new Aresta(v, w, valor, false);
        v.inserirAresta(a);
        w.inserirAresta(a);
    }

    public Object removerVertice(Vertice v) {
        for (Aresta a : v.getverticesAdjacentes()) {
            Vertice w = oposto(v, a);
            w.getverticesAdjacentes().remove(a);
            
        }
        this.listaVertices.remove(v);
        return v.getValor();
    }

    public Object removerAresta(Aresta e) {
        e.getVerticeOrigem().getverticesAdjacentes().remove(e);
        e.getVerticeDestino().getverticesAdjacentes().remove(e);
        return e.getValor();
    }

    public List<Aresta> arestasIncidentes(Vertice v) {
        return new ArrayList<>(v.getverticesAdjacentes());
    }

    public Vector<Vertice> vertices() {
        return this.listaVertices;
    }

    public List<Aresta> arestas() {
        List<Aresta> listaArestas = new ArrayList<>();
        for (Vertice v : this.listaVertices) {
            listaArestas.addAll(v.getverticesAdjacentes());
        }
        return listaArestas;
    }

    public boolean eDirecionado(Aresta e) {
        return e.isDirecionada();
    }

    public void inserirArestaDirecionada(Vertice v, Vertice w, Object valor) {
        Aresta a = new Aresta(v, w, valor, true);
        v.inserirAresta(a);
    }

    public void mostrarGrafo() {
        for (Vertice v : this.listaVertices) {
            System.out.print("Vertice " + v.getValor() + " -> ");
            for (Aresta a : v.getverticesAdjacentes()) {
                Vertice destino = a.getVerticeDestino();
                System.out.print(destino.getValor() + " (Valor da Aresta: " + a.getValor() + ") ");
                if (a.isDirecionada()) {
                    System.out.print("[Direcionada] ");
                }
            }
            System.out.println(); // Nova linha após listar todas as arestas do vértice
        }
    }


    // public boolean ehConexo() {
    //     if (this.listaVertices.isEmpty()) return true;

    //     boolean[] visitados = new boolean[this.listaVertices.size()];
    //     dfs(0, visitados);

    //     for (boolean visitado : visitados) {
    //         if (!visitado) return false;
    //     }
    //     return true;
    // }
    // private void dfs(int i, boolean[] visitados) {
    //     visitados[i] = true;
    //     Vertice v = this.listaVertices.get(i);
    //     for (Aresta a : v.getListaAdjacencia()) {
    //         Vertice destino = a.getVerticeDestino();
    //         int indexDestino = this.listaVertices.indexOf(destino);
    //         if (!visitados[indexDestino]) {
    //             dfs(indexDestino, visitados);
    //         }
    //     }
    // }
}
