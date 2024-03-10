package HashTable;
public class HashTableLinearProbing {
    private static final int DEFAULT_CAPACITY = 13;
    private static final int NO_SUCH_KEY = -1;
    private Par[] table;
    private int size;

    public HashTableLinearProbing() {
        this(DEFAULT_CAPACITY);
    }

    public HashTableLinearProbing(int capacity) {
        table = new Par[capacity];
        size = 0;
    }

    public void insert(int key, String value) {
        // Calcula o índice usando a função de hash
        int index = hash(key);
        // Enquanto não estiver vazia, não for AVAILABLE (remoção)
        // e a chave não for a que estamos procurando, continue procurando
        while (table[index] != null && table[index] != Par.AVAILABLE && table[index].getKey() != key) {
            index = (index + 1) % table.length; // Sondagem linear: move para a próxima
        }

        // Se estiver vazia ou contiver AVAILABLE,
        // colocamos um novo par (chave, valor)
        if (table[index] == null || table[index] == Par.AVAILABLE) {
            table[index] = new Par(key, value);
            size++;

            // Verifica o fator de carga e faz o "rehash" se necessário
            if ((double) size / table.length > 0.75) {
                rehash(); // Se a tabela estiver ficando cheia, aumentamos o tamanho e reorganizamos
            }
        } else {
            // Chave já existe, deste modo, atualiza o valor
            table[index].setValue(value);
        }
    }

    public String get(int key) {
        int index = findElement(key); // Encontra indice da chave
        if (index != NO_SUCH_KEY) {
            return table[index].getValue(); // Se achou a chave retorna o valor
        } else {
            return "NO_SUCH_KEY";
        }
    }

    public String remove(int key) {
        int index = findElement(key); // Encontra o indice da chave
        if (index != NO_SUCH_KEY) {
            String value = table[index].getValue();
            table[index] = Par.AVAILABLE; // Remoção
            size--;
            return value;
        } else {
            return "NO_SUCH_KEY";
        }
    }

    private int findElement(int key) {
        int index = hash(key); // Encontra o indice da chave
        int probeCount = 0;
        // Utiliza sondagem linear pra encontrar o prox enquanto
        // a capacidade da sondagem não exceder
        while (probeCount < table.length) {
            Par currentPar = table[index];

            if (currentPar == null || currentPar == Par.AVAILABLE) {
                return NO_SUCH_KEY;
            } else if (currentPar.getKey() == key) {
                return index; // Retorna o indice se encontrar a chave
            } else {
                index = (index + 1) % table.length;
                probeCount++;
            }
        }
        return NO_SUCH_KEY;
    }

    private int hash(int key) {
        return key % table.length; // Calcula o indice da tabela
    }

    private void rehash() {
        // dobra o tamanho da tabela redistribuindo os elementos existentes
        Par[] oldTable = table;
        table = new Par[2 * oldTable.length];
        size = 0;

        for (Par Par : oldTable) {
            if (Par != null && Par != Par.AVAILABLE) {
                insert(Par.getKey(), Par.getValue());
            }
        }
    }

    public void printTable() {
        System.out.println("Tabela Hash (Linear Probing):");

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                System.out.println(i + ": -");
            } else if (table[i] == Par.AVAILABLE) {
                System.out.println(i + ": AVAILABLE");
            } else {
                System.out.println(i + ": Chave=" + table[i].getKey() + ", Valor=" + table[i].getValue());
            }
        }
        System.out.println("Tamanho da Tabela: " + size);
    }
}
