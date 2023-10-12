import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        Function<String, String> test= (x)->"test" + x;
        var indexer = IndexerProxyFactory.create(test);
        indexer.set(0, (x)->"f"+x);
        System.out.println(indexer.get(0).apply("0"));  // Outputs: Getting value for index 0
        System.out.println(indexer.get(2).apply("x"));  // Outputs: Getting value for index 2

    }
}
