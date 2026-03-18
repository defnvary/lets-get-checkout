public interface UserInputRetriever<T> {
    public T produceOutput(int sel) throws IllegalArgumentException;
}
