package HashTable;

public class Par {
    public static final Par AVAILABLE = new Par(-1, null);

    private int key;
    private String value;

    public Par(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
