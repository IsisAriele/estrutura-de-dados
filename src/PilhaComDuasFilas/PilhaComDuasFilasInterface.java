package PilhaComDuasFilas;

public interface PilhaComDuasFilasInterface {
    public void push(Object elemento);
    public Object pop();
    public void transferirFilaEntradaParaFilaSaida();
    public void transferirFilaSaidaParaFilaEntrada();
    public Object top();
    public int size();
    public boolean isEmpty();
}
