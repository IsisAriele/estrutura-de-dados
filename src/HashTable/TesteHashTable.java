package HashTable;

public class TesteHashTable {
    public static void main(String[] args) {
        HashTableLinearProbing hashTableLP = new HashTableLinearProbing();

        hashTableLP.insert(18, "18");
        hashTableLP.insert(41, "41");
        hashTableLP.insert(22, "22");
        hashTableLP.insert(44, "44");
        hashTableLP.insert(59, "59");
        hashTableLP.insert(32, "32");
        hashTableLP.insert(31, "31");
        hashTableLP.insert(73, "73");

        System.out.println("Chave 18: " + hashTableLP.get(18));
        hashTableLP.remove(73);
        hashTableLP.printTable();

        // ------------------------------------------ //

        HashTableHashingDuplo hashTableHD = new HashTableHashingDuplo();

        hashTableHD.insert(18, "18");
        hashTableHD.insert(41, "41");
        hashTableHD.insert(22, "22");
        hashTableHD.insert(44, "44");
        hashTableHD.insert(59, "59");
        hashTableHD.insert(32, "32");
        hashTableHD.insert(31, "31");
        hashTableHD.insert(73, "73");

        hashTableHD.printTable();
    }
}
