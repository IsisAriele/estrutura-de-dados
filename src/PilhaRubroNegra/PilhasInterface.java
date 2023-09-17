package PilhaRubroNegra;

public interface PilhasInterface {
    void pushVermelho(Object elemento);
    void pushPreto(Object elemento);
    Object popVermelho();
    Object popPreto();

    Object topVermelho() throws PilhaVaziaExcecao;

    Object topPreto() throws PilhaVaziaExcecao;

    boolean isEmptyVermelho();
    boolean isEmptyPreto();

    int sizeVermelho();

    int sizePreto();
}
