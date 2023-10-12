import java.util.Objects;

/**
 * Represent a pair of two related elements
 *
 * <p>This class is designed to hold two related objects of potentially different types
 * It offers utility methods for common operations and can be used in scenarios where
 * theres a need  to group two objects without creating a specific class for them </p>
 *
 * Usage:
 * <pre>
 *  Pair<String, Integer> nameAndAge = Pair.with("Alice",30);
 *  String name = nameAndAge.getValue0();
 *  Integer age = nameAndAge.getValue1();
 * <pre/>
 * @param <A> the type of the first element in the pair
 * @param <B> the type of the second element in the pair
 *
 */
public record Pair<A,B>(A value0, B value1) {

    /**
     * Static factory method for easy creation
     * @param value0 first element of the pair
     * @param value1 second element of the pair
     * @param <A> type of the first element
     * @param <B> type of the second element
     * @return a new Pair
     */
    public static <A,B> Pair<A,B> with(A value0, B value1){
        return new Pair<>(value0, value1);
    }

    /**
     * Creates a new Pair with first value changed
     * @param newValue value of first element
     * @return new Pair with first value changed
     */
    public Pair<A,B> setA0(A newValue){
        return new Pair<>(newValue, value1);
    }

    /**
     * Creates a new Pair with second value changed
     * @param newValue value of second element
     * @return new Pair with second value changed
     */
    public Pair<A,B> setA1(B newValue){
        return new Pair<>(value0, value1);
    }

    /**
     * Swap values of Pair
     * @return a new Pair with swap values
     */
    public Pair<B,A> swap(){
        return new Pair<>(value1, value0);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return  true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return value0.equals(pair.value0) && value1.equals(pair.value1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value0, value1);
    }

    @Override
    public String toString() {
        return "(" + value0 + ", "+ value1 + ")";
    }
}
