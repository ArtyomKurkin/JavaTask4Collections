package com.netcracker.testCollections;

import java.util.*;

public class TestClass{
    private long size;
    private LinkedList<String> linkedList;
    private ArrayList<String> arrayList;
    private HashSet<String> hashSet;
    private LinkedHashSet<String> linkedHashSet;
    private TreeSet<String> treeSet;
    private HashMap<String ,String> hashMap;
    private LinkedHashMap<String,String> linkedHashMap;
    private TreeMap<String,String> treeMap;
    private long startTime;
    private long estimatedTime;

    public TestClass(long size) {
        this.size = size;

        linkedList = new LinkedList<>();
        arrayList =new ArrayList<>();

        for (int i=0;i<size;i++){
            linkedList.add("aaa");
            arrayList.add("aaa");
        }

        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();
        for (int i=0;i<size;i++){
            hashSet.add("aaa"+i);
            linkedHashSet.add("aaa"+i);
            treeSet.add("aaa"+i);
        }

        hashMap = new HashMap<>();
        linkedHashMap = new LinkedHashMap<>();
        treeMap = new TreeMap<>();

        for (int i=0;i<size;i++){
            hashMap.put("aaa"+i,"aaa");
            linkedHashMap.put("aaa"+i,"aaa");
            treeMap.put("aaa"+i,"aaa");
        }
    }

    public void compareAddList(String element, int place){

        System.out.println("Compare Add for Lists");
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            arrayList.add(place+i, element);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for ArrayList =  " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            linkedList.add(place+i, element);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for LinkedList = " + estimatedTime);
    }

    public void compareRemoveList(int place){
        System.out.println("Compare Remove for Lists");
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            arrayList.remove(place-i-1);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for ArrayList =  " + estimatedTime);
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            linkedList.remove(place-i-1);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for LinkedList = " + estimatedTime);
    }
    public void compareRemoveListStart(){
        System.out.println("Compare Remove for Lists");
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            arrayList.remove(0);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for ArrayList =  " + estimatedTime);
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            linkedList.remove(0);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for LinkedList = " + estimatedTime);
    }
    public void compareAddListStart(String element){
        System.out.println("Compare Add for Lists");
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            arrayList.add(0, element);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for ArrayList =  " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            linkedList.add(0, element);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for LinkedList = " + estimatedTime);
    }

    public void compareRemoveListEnd(){
        System.out.println("Compare Remove for Lists");
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            arrayList.remove(arrayList.size()-1);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for ArrayList =  " + estimatedTime);
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            linkedList.remove(linkedList.size()-1);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for LinkedList = " + estimatedTime);
    }


    public void compareAddSet(String element){
        System.out.println("Compare Add for Sets");
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            hashSet.add(element+(i+size));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for HashSet =  " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            linkedHashSet.add(element+(i+size));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for LinkedHashSet = " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++){
            treeSet.add(element+(i+size));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for TreeSet = " + estimatedTime);
    }
    public void compareContainsSet(String element){
        System.out.println("Compare Contains for Sets");
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            hashSet.contains(element+(5*i));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for HashSet =  " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            linkedHashSet.contains(element+(5*i));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for LinkedHashSet = " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            treeSet.contains(element+(5*i));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for TreeSet = " + estimatedTime);
    }
    public void compareRemoveSet(String element){
        System.out.println("Compare Remove for Sets");
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            hashSet.remove(element+(3*i+1));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for HashSet =  " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            linkedHashSet.remove(element+(3*i+1));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for LinkedHashSet = " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            treeSet.remove(element+(3*i+1));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for TreeSet = " + estimatedTime);
    }

    public void comparePutMap(String element){
        System.out.println("Compare Put for Maps");
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            hashMap.put(element+(size+i),element);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for HashMap =  " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            linkedHashMap.put(element+(size+i),element);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for LinkedHashMap = " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            treeMap.put(element+(size+i),element);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for TreeMap = " + estimatedTime);
    }
    public void compareGetMap(String element){
        System.out.println("Compare Get for Maps");
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            hashMap.get(element+(600000-1-i*3));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for HashMap =  " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            linkedHashMap.get(element+(600000-1-i*3));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for LinkedHashMap = " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            treeMap.get(element+(600000-1-i*3));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for TreeMap = " + estimatedTime);
    }

    public void compareRemoveMap(String element){
        System.out.println("Compare Remove for Maps");
        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            hashMap.remove(element+(i*3+42));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for HashMap =  " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            linkedHashMap.remove(element+(i*3+42));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for LinkedHashMap = " + estimatedTime);

        startTime=System.nanoTime();
        for (int i=0;i<100000;i++) {
            treeMap.remove(element+(i*3+42));
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("Time for TreeMap = " + estimatedTime);
    }








}
