/**
 * Created by AlinaCh on 22.03.2017.
 */
public class Entry<Item> {

    public Item item;
    public Integer priority;

    /**
     * initializing of the Entry
     * @param item some element
     * @param priority priority of the element
     */
    public Entry(Item item, Integer priority){
        this.item = item;
        this.priority = priority;
    }

    /**
     * default initializing of the Entry
     */
    public Entry() {
        this.item = null;
        this.priority = 0;
    }

    /**
     * @return String representation of the Entry
     */
    public String toString() {
        String result = item.toString() + " " + priority.toString();
        return result;
    }
}
