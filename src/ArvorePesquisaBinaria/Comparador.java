package ArvorePesquisaBinaria;

public class Comparador {
    public Comparador(){
    }
    public int comparer(int n1, int n2){
        if (n1 > n2) return 1;
        if (n1 < n2) return -1;
        return 0;
    }
}
