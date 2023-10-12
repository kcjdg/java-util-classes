public class IndexerProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> Indexer<T> create(T defaultValue) {
        return (Indexer<T>) java.lang.reflect.Proxy.newProxyInstance(
                Indexer.class.getClassLoader(),
                new Class[] { Indexer.class },
                new IndexerInvocationHandler<>(defaultValue)
        );
    }
}