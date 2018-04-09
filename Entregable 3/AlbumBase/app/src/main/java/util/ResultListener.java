package util;

public interface ResultListener<T> {
    void finish(T resultado);
}