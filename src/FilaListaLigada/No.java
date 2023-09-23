package FilaListaLigada;
public class No {
    Object elemento;
    No proximo;

    public No(Object elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    @Override
    public String toString() {
        return " "+ this.elemento;
    }
}
