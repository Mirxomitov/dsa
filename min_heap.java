import java.util.Arrays;

class MinHeap {
    private int[] heapArray;
    private int heapSize;
    private int capacity;

    MinHeap(int n) {
        heapSize = n;
        heapArray = new int[n];
        capacity = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int right(int i) {
        return (i + 1) * 2;
    }

    private int left(int i) {
        return i * 2 + 1;
    }
    // 0
    // 1 2
    // 3 4 5 6

    private void ensureCapacity() {
        if (heapSize == capacity)
            Arrays.copyOf(heapArray, heapSize * 2);
    }

    private void swap(int i, int j) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }

    public int size() {return capacity;}

    public void add(int e) {
        ensureCapacity();
        heapArray[++capacity] = e;

        // heapify-up
        int i = capacity;
        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int pop() {
        if (capacity == 0)
            new Exception("Heap is Empty");
        int root = heapArray[0];

        // heapify-down
        int i = 0;

        while (true) {
            int l = left(i);
            int r = right(i);
            int smallest = i;

            if (l < capacity && heapArray[l] < heapArray[smallest])
                smallest = l;
            if (r < capacity && heapArray[r] < heapArray[smallest])
                smallest = r;

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else {
                break;
            }
        }

        return root;
    }
}