package Iterator;

interface Aggregate {
    BaseIterator createIterator();
}

class ConcreteAggregate implements Aggregate {

    private Integer[] nums;

    public ConcreteAggregate() {
        this.nums = new Integer[]{1, 2, 3};
    }

    @Override
    public BaseIterator createIterator() {
        return new ConcreteIterator(nums);
    }
}

interface BaseIterator<Item> {

    Item next();

    boolean hasNext();
}

class ConcreteIterator<Item> implements BaseIterator<Item> {

    private Item[] items;
    private int curPos;

    public ConcreteIterator(Item[] items) {
        this.items = items;
        this.curPos = 0;
    }

    @Override
    public Item next() {
        return items[curPos++];
    }

    @Override
    public boolean hasNext() {
        return curPos < items.length;
    }
}

public class Iterator {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        BaseIterator iterator = aggregate.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
