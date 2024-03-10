package Skiplist;

public class SkiplistMain {
    public static void main(String[] args) {
        SkipList skipList = new SkipList();

//         Exemplo de inserção
        skipList.insert(3, 30);
        skipList.insert(6, 60);
        skipList.insert(7, 70);
        skipList.insert(9, 90);
        skipList.insert(12, 120);

        System.out.println("Skip List após a inserção:");
        skipList.display();

        // Exemplo de busca
        System.out.println("Busca pela chave 7: " + skipList.search(7));
        System.out.println("Busca pela chave 8: " + skipList.search(8));

//        // Exemplo de remoção
        skipList.remove(6);
        skipList.remove(9);

        System.out.println("Skip List após a remoção:");
        skipList.display();
    }
}
