public interface Indexer<T> {
    T get(int index);
    void set(int index, T value);
}