package com.netcracker.MyLinkedList;

import java.util.LinkedList;

public class CompareLinkList {
    int size;

    public CompareLinkList(int size) {
        this.size = size;
    }

    public void compareList() {
        MyLinkedList<String> myList = new MyLinkedList<>(String.class);
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Compare add(E):");
        compareAdd(myList, list);
        System.out.println("Compare add(index,E):");
        compareAddInd(myList, list);
        System.out.println("Compare indexOf(E):");
        compareIndexOf(myList, list);
        System.out.println("Compare remove(index):");
        compareRemove(myList, list);
    }

    public void compareAdd(MyLinkedList<String> list1, LinkedList<String> list2) {
        long startTime;
        long estimatedTime;
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list1.add("Element " + (i + 1));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("My time: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list2.add("Element " + (i + 1));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Normal time: " + estimatedTime);
    }

    public void compareAddInd(MyLinkedList<String> list1, LinkedList<String> list2) {
        long startTime;
        long estimatedTime;
        startTime = System.nanoTime();
        list1.add(9000, "Choosen Element");
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("My time: " + estimatedTime);

        startTime = System.nanoTime();
        list2.add(9000, "Choosen Element");
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Normal time: " + estimatedTime);
    }

    public void compareIndexOf(MyLinkedList<String> list1, LinkedList<String> list2) {
        int found;
        long startTime;
        long estimatedTime;
        startTime = System.nanoTime();
        found = list1.indexOf("Choosen Element");
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("My time: " + estimatedTime);

        startTime = System.nanoTime();
        found = list2.indexOf("Choosen Element");
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Normal time: " + estimatedTime);
    }
    public void compareRemove(MyLinkedList<String> list1, LinkedList<String> list2) {
        long startTime;
        long estimatedTime;
        startTime = System.nanoTime();
        for (int i = 1000; i < 2000; i++) {
            String removed = list1.remove(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("My time: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 1000; i <2000; i++) {
            String removed = list2.remove(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Normal time: " + estimatedTime);
    }
}