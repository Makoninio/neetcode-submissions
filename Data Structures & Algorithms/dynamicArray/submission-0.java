class DynamicArray {
    public int[] list;
    public int length;
    public int capacity;

    public DynamicArray(int capacity) {
        this.list = new int[capacity];
        this.length = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        return list[i];
    }

    public void set(int i, int n) {
        list[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        list[length] = n;
        length++;
    }

    public int popback() {
        if (length > 0) {
            length--;
        }
        return list[length];
    }

    private void resize() {
        capacity = capacity * 2;
        int[] newArr = new int[capacity];
        for (int i=0; i<length; i++) {
            newArr[i] = list[i];
        }
        list = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
