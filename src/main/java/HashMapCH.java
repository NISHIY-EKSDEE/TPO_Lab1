public class HashMapCH {

    private class HashNode {
        public int value;
        public int key;

        HashNode(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    private int capacity;
    private HashNode[] arr;
    private int size;
    private HashNode dummy;

    public HashMapCH(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = new HashNode[capacity];

        for (int i = 0; i < capacity; i++)
            arr[i] = null;

        dummy = new HashNode(-1, -1);
    }

    public int hashCode(int key) {
        return key % capacity;
    }

    public boolean insertNode(int key, int value) {
        HashNode temp = new HashNode(key, value);
        int hashIndex = hashCode(key);

        int counter = 0;
        while (arr[hashIndex] != null && arr[hashIndex].key != -1 && counter++ < capacity) {
            hashIndex++;
            hashIndex %= capacity;
        }

        if (counter < capacity) {
            size++;
            arr[hashIndex] = temp;
            return true;
        } else {
            return false;
        }
    }

    public Integer deleteNode(int key) {
        int hashIndex = hashCode(key);

        int counter = 0;
        while ((arr[hashIndex] == null || arr[hashIndex].key != key) && counter++ < capacity) {
            hashIndex++;
            hashIndex %= capacity;
        }
        if (counter < capacity) {
                HashNode temp = arr[hashIndex];
                arr[hashIndex] = dummy;
                size--;
                return temp.value;
        } else {
            return null;
        }
    }

    public Integer get(int key) {
        int hashIndex = hashCode(key);
        int counter = 0;
        while ((arr[hashIndex] == null || arr[hashIndex].key != key) && counter++ < capacity) {
            hashIndex++;
            hashIndex %= capacity;
        }
        if (counter < capacity) {
            return arr[hashIndex].value;
        } else {
            return null;
        }
    }

    public int sizeofMap() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (arr[i] != null && arr[i].key != -1) {
                System.out.print("key = " + arr[i].key);
                System.out.println(" value = " + arr[i].value);
            }
        }
    }
};

