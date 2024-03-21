package ArvorePesquisaBinaria;
import java.util.Iterator;

public interface IArvoreBinariaPesquisa {
    // void setComparator(Comparador c);
    // Comparador getComparador();
    No pesquisa(No no, Object key);
    No incluir(Object key);
    Object remover(Object key);
    No getRaiz();
    void setRaiz(No p);
    void emOrdem(No no);
    void preOrdem(No no);
    void posOrdem(No no);
    int altura(No no);
    int profundidade(No no);
    void mostrar();
    Iterator nos();
    Iterator elements();
    int size();
    boolean isEmpty();
}
