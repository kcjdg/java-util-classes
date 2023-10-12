@FunctionalInterface
public interface EventHandler<T> {
    void handle(T args);
}
