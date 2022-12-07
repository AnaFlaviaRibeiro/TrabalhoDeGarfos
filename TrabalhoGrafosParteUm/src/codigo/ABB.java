package codigo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ABB<T> implements Iterable<T> {
    private Map<Integer, T> data;

    public ABB() {
        this.data = new LinkedHashMap<>();
    }

    public T find(int key) {
        return this.data.get(key);
    }

    public boolean add(int key, T newElement) {
        boolean result = false;
        if (!this.data.containsKey(key)) {
            this.data.put(key, newElement);
            result = true;
        }
        return result;
    }

    public int size() {
        return this.data.size();
    }

    public void clear() {
        this.data.clear();
    }

    public T[] allElements(T[] array) {
        T[] allData = this.data.values().toArray(array);
        return allData;
    }

    public T remove(int key) {
        return this.data.remove(key);
    }

    @Override
    public Iterator<T> iterator() {
        var items = this.data.values().toArray();
        return new Iterator<T>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < items.length;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                return (T) items[current++];
            }
        };
    }
}
