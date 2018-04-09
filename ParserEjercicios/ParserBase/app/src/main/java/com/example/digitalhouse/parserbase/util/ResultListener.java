package com.example.digitalhouse.parserbase.util;

public interface ResultListener<T> {
    void finish(T resultado);
}