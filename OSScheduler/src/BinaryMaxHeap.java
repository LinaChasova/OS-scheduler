/**
 * Created by AlinaCh on 22.03.2017.
 */
public class BinaryMaxHeap <Item> {

    private int capacity;
    private Entry<Item>[] maxHeap;
    private int index;

    /**
     * initializing of BinaryMaxHeap using Array with given size
     * @param size of the heap
     */
    public BinaryMaxHeap(int size) {
        capacity = size;
        maxHeap = (Entry<Item>[]) new Entry[capacity + 1];
        index = 0;
    }

    /**
     * adds element to the heap
     * in the array starts from 1 index
     * performs bubble up algorithm in order to follow BinaryMaxHeap rules
     * @param element that is to be inserted
     */
    public void insert(Entry element) {
        if (index == 0) {
            maxHeap[1] = new Entry(element.item, element.priority);
            index = 2;
        } else {
            maxHeap[index++] = new Entry(element.item, element.priority);
            bubbleUp();
        }
    }

    /**
     * deletes given element from the heap, by firstly searching fir its index
     * than places last element to the root
     * performs sink down algorithm in order to follow BinaryMaxHeap rules
     * @param element that is to be deleted
     */
    public void delete(Entry element) {
        int temp = search(element);
        if (temp != -1) {
            maxHeap[temp] = new Entry(maxHeap[--index].item, maxHeap[index].priority);
            maxHeap[index] = null;
        }
        swipeDown(temp);
    }

    /**
     * deletes the root of the heap, by placing last element to the root and performing swipe-down algorithm
     */
    public void deleteMax() {
        if (index == 2) {
            maxHeap[1] = null;
            index = 0;
        } else {
            index--;
            maxHeap[1] = new Entry(maxHeap[index].item, maxHeap[index].priority);
            maxHeap[index] = null;
            if (index != 2) {
                swipeDown(1);
            }
        }
    }

    /**
     * deletes and returns the root of the heap
     * @return the root
     */
    public Entry deleteMaximum() {
        Entry element = new Entry(maxHeap[1].item, maxHeap[1].priority);
        deleteMax();
        return element;
    }

    /**
     * searches given element
     * @param element that is to be searched
     * @return index of element or -1 if such does not exist
     */
    public int search(Entry element) {
        for (int i = 1; i < index; i++) {
            if (element.item.equals(maxHeap[i].item))
                return i;
        }
        return -1;
    }

    /**
     * @return the size of the heap
     */
    public int size() {
        return index;
    }

    /**
     * bubble up algorithm that checks whether the element is bigger than its parents and
     * exchanges them, repeats until the heap is sorted
     */
    private void bubbleUp() {
        int temp = index - 1;
        while (temp > 1) {
            if (maxHeap[temp/2].priority < maxHeap[temp].priority) {
                swap(temp, temp/2);
                temp = temp / 2;
            } else
                break;
        }
    }

    /**
     * swipe down algorithm that checks whether element is less that its children
     * and exchanges with the bigger one, repeats until the heat is sorted
     * @param temp
     */
    private void swipeDown(int temp) {
        while (temp < index - 1) {
            if (maxHeap[temp].priority > maxHeap[2*temp].priority || maxHeap[temp].priority > maxHeap[2*temp + 1].priority) {
                if (maxHeap[2*temp].priority >= maxHeap[2*temp + 1].priority) {
                    swap(temp, 2*temp);
                    temp = 2*temp;
                } else {
                    swap(temp, 2 * temp + 1);
                    temp = 2 * temp + 1;
                }
            }
        }
    }

    /**
     * swapping of elements
     * @param i1 index of 1st element
     * @param i2 index of 2nd element
     */
    private void swap(int i1, int i2) {
        Entry temp = new Entry(maxHeap[i1].item, maxHeap[i1].priority);
        maxHeap[i1] = new Entry(maxHeap[i2].item, maxHeap[i2].priority);
        maxHeap[i2] = new Entry(temp.item, temp.priority);
    }
}
