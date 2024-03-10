package Skiplist;

public class Node {

    int value;
    int key;
    Node up;
    Node down;
    Node next;
    Node prev;

    public Node(int v, int k){
        this.value = v;
        this.key = k;
        this.up = null;
        this.down = null;
        this.next = null;
        this.prev = null;
    }

}
