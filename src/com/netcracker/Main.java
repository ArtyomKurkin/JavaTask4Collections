package com.netcracker;

import com.netcracker.MyLinkedList.Circle;
import com.netcracker.MyLinkedList.CompareLinkList;
import com.netcracker.MyLinkedList.MyLinkedList;
import com.netcracker.testCollections.TestClass;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Circle> test = new MyLinkedList<>(Circle.class);

        //Test functions of MyLinkedList

        //size()
        System.out.println("Size of collection = "+test.size());

        //add(E)

        for (int i=0;i<3;i++){
            test.add(new Circle(i+1,"Red"));
        }
        //toString()
        System.out.println(test.toString());
        System.out.println("________________");
        //add(E,index)
        for (int i=0;i<3;i++){
            test.add(i*2,new Circle(i*5,"Blue"));
        }
        //Iterator
        for(Circle element:test){
            System.out.println(element.toString());
        }
        System.out.println("________________");

        //size()
        System.out.println("Size of collection = "+test.size());
        System.out.println("________________");

        //remove(index)
        int k = test.size();
        Circle remCir = new Circle();
        for (int i=1;i<3;i++){
            remCir = test.remove(k-i);//k is fixed before and =6, for greater visability;
        }
        System.out.println("The last removed element: "+remCir.toString());
        System.out.println(test.toString());
        System.out.println("________________");

        //set(index)
        int indexCheck = 2;
        Circle setCir = new Circle(33,"BLACK");
        setCir = test.set(indexCheck,setCir);
        System.out.println("The replaced element:"  +setCir.toString());
        System.out.println(test.toString());
        System.out.println("________________");

        //get(index)
        Circle getCir = test.get(indexCheck);
        System.out.println("The gotten element: "+getCir.toString());
        System.out.println("________________");

        //indexof(E)
        System.out.println("The index of gotten element = "+test.indexOf(getCir));
        System.out.println("________________");

        //toArray

        Circle[] arr = test.toArray();

        for (int i=0;i<test.size();i++){
            System.out.println("The element of array: "+ arr[i].toString());
            System.out.println("The element of collection: "+ test.get(i).toString());
        }
        System.out.println("________________");

        //clear()

        test.clear();
        System.out.println(test.toString());
        System.out.println("The size of collection = "+test.size());

        System.out.println("_________________________________________________");

        System.out.println("Compare MyLinkedList and LinkedList");
        CompareLinkList compareLinkList = new CompareLinkList(10000);
        compareLinkList.compareList();

        TestClass testClass = new TestClass(500000);
        System.out.println("_________________________________________________");

        System.out.println("Compare Add and Remove for begin of Lists:");
        testClass.compareAddListStart("aaa");
        testClass.compareRemoveListStart();
        System.out.println("Compare Add and Remove for middle of Lists:");
        testClass.compareAddList("aaa",250000);
        testClass.compareRemoveList(250000);
        System.out.println("Compare Add and Remove for end of Lists:");
        testClass.compareAddList("aaa",500000);
        testClass.compareRemoveListEnd();

        System.out.println("_______________");
        System.out.println("Compare HashSet, LinkedHashSet and TreeSet");
        testClass.compareAddSet("aaa");
        testClass.compareContainsSet("aaa");
        testClass.compareRemoveSet("aaa");


        System.out.println("_______________");
        System.out.println("Compare HashMap, LinkedHashMap and TreeMap");
        testClass.comparePutMap("aaa");
        testClass.compareGetMap("aaa");
        testClass.compareRemoveMap("aaa");










    }
}
