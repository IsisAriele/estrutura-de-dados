package FilaComDuasPilhas;

public interface FilaComDuasPilhasInterface {
    public void enqueue(Object elemento);

    public Object dequeue();

    //public boolean pilhaSaidaIsEmpty();

    public void transferirPilhaEntradaParaPilhaSaida();

    public Object first();

    public int size();

    public boolean isEmpty();
}
