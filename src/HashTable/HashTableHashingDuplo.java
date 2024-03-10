package HashTable;

public class HashTableHashingDuplo {
    private static final int DEFAULT_CAPACITY = 13;
    private static final int NO_SUCH_KEY = -1;
    private Par[] table;
    private int size;

    public HashTableHashingDuplo() {
        this(DEFAULT_CAPACITY);
    }

    public HashTableHashingDuplo(int capacity) {
        table = new Par[capacity];
        size = 0;
    }

    public void insert(int key, String value) {
        // Calcula o índice usando a função de hash principal
        int index = hash(key);
        // Salva o índice para ser possivelmente utilizado no cálculo de dispersão
        // e evitar sobreescrita do índice atual.
        int auxIndex = index;

        // Calcula a função de dispersão secundária
        int d = hashSecondary(key);

        int j = 0;
        while (table[index] != null && table[index] != Par.AVAILABLE && table[index].getKey() != key) {
            // Formula para sondagem dupla
            index = (auxIndex + j * d) % table.length;
            j++;
        }
        // Se vazio ou disponivel insere um novo par
        if (table[index] == null || table[index] == Par.AVAILABLE) {
            table[index] = new Par(key, value);
            size++;
            // verifica fator de carga e faz rehash
            if ((double) size / table.length > 0.75) {
                rehash();
            }
        } else {
            // A chave já existe, atualiza o valor associado
            table[index].setValue(value);
        }
    }

    public String get(int key) {
        int index = findElement(key);
        if (index != NO_SUCH_KEY) {
            return table[index].getValue();
        } else {
            return "NO_SUCH_KEY";
        }
    }

    public String remove(int key) {
        int index = findElement(key);
        if (index != NO_SUCH_KEY) {
            String value = table[index].getValue();
            table[index] = Par.AVAILABLE;
            size--;
            return value;
        } else {
            return "NO_SUCH_KEY";
        }
    }

    private int findElement(int key) {
        int index = hash(key);
        int d = hashSecondary(key);
        int probeCount = 0;

        while (probeCount < table.length) {
            Par currentPar = table[index];

            if (currentPar == null || currentPar == Par.AVAILABLE) {
                return NO_SUCH_KEY;
            } else if (currentPar.getKey() == key) {
                return index;
            } else {
                index = (index + probeCount * d) % table.length;
                probeCount++;
            }
        }
        return NO_SUCH_KEY;
    }

    private int hash(int key) {
        return key % table.length;
    }

    private int hashSecondary(int key) {
        int q = 7;
        return q - (key % q);
    }

    public static boolean isPrimo(int numero) {
        // Verifica divisibilidade por números de 2 até a raiz quadrada do número
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                // Se o número é divisível por algum outro além de 1 e ele mesmo, não é primo
                return false;
            }
        }
        // Se não foi encontrado nenhum divisor além de 1 e o próprio número, é primo
        return true;
    }

    private void rehash() {
        Par[] oldTable = table;

        int novoTamanho = 2 * oldTable.length;

        while(!isPrimo(novoTamanho)) {
            novoTamanho++;
        }

        table = new Par[novoTamanho];
        size = 0;

        for (Par par : oldTable) {
            if (par != null && par != Par.AVAILABLE) {
                insert(par.getKey(), par.getValue());
            }
        }
    }

    public void printTable() {
        System.out.println("Tabela Hash (Hashing Duplo):");

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
