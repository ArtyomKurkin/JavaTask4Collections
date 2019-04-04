package com.netcracker.MyLinkedList;

import java.util.Iterator;
public interface MyListIterator<E> extends Iterator<E> {

    boolean hasNext();

    E next();

    int nextInd();

    void remove();
}
