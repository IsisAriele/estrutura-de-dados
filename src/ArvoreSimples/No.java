package ArvoreSimples;
import java.util.ArrayList;
import java.util.Iterator;

public class No {
    private Object o;
    private No pai;
    private ArrayList<No> filhos = new ArrayList<>();
    public No(No pai, Object o) {
        this.pai = pai;
        this.o = o;
    }
    public Object element() {
        return o;
    }
    public No parent() {
        return pai;
    }
    public void setElement(Object o) {
        this.o = o;
    }
    public void addChild(No o) {
        filhos.add(o);
    }
    public void removeChild(No o) {
        filhos.remove(o);
    }
    public int childrenNumber() {
        return filhos.size();
    }
    public Iterator children() {
        return filhos.iterator();
    }

    @Override
    public String toString() {
        return String.format("No<%s>",o.toString());
    }
}
