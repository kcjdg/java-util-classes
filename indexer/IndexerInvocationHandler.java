import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * Some of the use case:
 * <pre>
 *    1. Custom Collections/Data Structure
 *    2. Sparse Arrays
 *    3. Matrix Operations
 *    4. Database Records
 *    5. Caching Mechanisms
 * </pre>
 * @param <T>
 */
public class IndexerInvocationHandler <T> implements InvocationHandler {

    private final Map<Integer, T> data = new HashMap<>();
    private T cachedValue;
    private int cachedIndex;
    private final T defaultValue;

    public IndexerInvocationHandler(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        switch (method.getName()) {
            case "get":
                int index = (Integer) args[0];
                if (cachedValue != null && cachedIndex == index) {
                    System.out.println("Returning cached value for index " + index);
                    return cachedValue;
                }
                System.out.println("Getting value for index " + index);
                cachedIndex = index;
                cachedValue = Optional.ofNullable(data.get(index)).orElse(defaultValue);
                return cachedValue;
            case "set":
                System.out.println("Setting value for index " + args[0]);
                cachedIndex = (Integer) args[0];
                cachedValue = (T) args[1];
                data.put(cachedIndex, cachedValue);
                return null;
            default:
                throw new UnsupportedOperationException("Unsupported method: " + method.getName());
        }
    }
}
