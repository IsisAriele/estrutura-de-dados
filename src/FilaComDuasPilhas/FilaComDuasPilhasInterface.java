package FilaComDuasPilhas;

public interface FilaComDuasPilhasInterface {
    public void enqueue(Object elemento);
    public Object dequeue();
    public void transferirPilhaEntradaParaPilhaSaida();
    public void transferirPilhaSaidaParaPilhaEntrada();
    public Object first();
    public int size();
    public boolean isEmpty();
}
