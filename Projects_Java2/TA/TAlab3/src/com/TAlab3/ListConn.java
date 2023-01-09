package com.TAlab3;

public interface ListConn<T> {

    void addOnEnd(T element);

    void addOnStart(T element);

    void addOnIndex(T element, int index);

    void deleteOnIndex(int index);

    void deleteOnStart();

    void deleteOnEnd();

    int indexOfElement(T element);
}
