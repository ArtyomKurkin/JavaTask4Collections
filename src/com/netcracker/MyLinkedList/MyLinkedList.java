package com.netcracker.MyLinkedList;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {

    private int size;
    private MyNode<E> first;
    private MyNode<E> last;
    private Class classE;

    public MyLinkedList(Class myClass) {
        this.classE = myClass;
    }

    public void add(E element){
        MyNode<E> node;
        if (size==0){
            node = new MyNode<>(element,null,null);
            first = node;
        }
        else{
            node = new MyNode<>(element,last,null);
            last.nextNode = node;
        }
        last = node;
        size+=1;
    }

    public void add(int index,E element){
        if(!checkIndexChange(index)){
            System.out.println("Error!Enter correct index!");
        }
        else {
            MyNode<E> node;
            if (index == 0) {
                node = new MyNode<>(element, null, first);
                first.prevNode = node;
                first = node;
            } else if (index == size) {
                node = new MyNode<>(element, last, null);
                last.nextNode = node;
                last = node;
            } else {
                MyNode<E> cur =getNode(index);
                MyNode<E> prev = cur.prevNode;
                cur.prevNode = new MyNode<>(element, prev, cur);
                prev.nextNode = cur.prevNode;
            }
            size++;
        }
    }

    public void clear(){
        first.nextNode = last = null;
        size = 0;
    }

    public E get(int index){
        if(!checkIndexGet(index)){
            System.out.println("Error!Enter correct index");
            return null;
        }
        else{
          MyNode<E> cur =getNode(index);
            return cur.element;
        }
    }

    public int indexOf(E element){
        int result = 0;
        MyNode<E> cur = first;
        while(result!=size){
            if(cur.element==element){
                return result;
            }
            else {
                cur = cur.nextNode;
                result++;
            }
        }
        return result;
    }

    public E remove(int index){
        if (!checkIndexGet(index)){
            System.out.println("Error! Enter correct index");
            return null;
        }
        else{
            MyNode<E> cur = getNode(index);
            MyNode<E> prev;
            MyNode<E> next;

            if(index==0){
                first=first.nextNode;
            }
            else if(index == (size-1)) {
                last = cur.prevNode;

            }
            else{
                prev = cur.prevNode;
                next = cur.nextNode;
                prev.nextNode = next;
                next.prevNode = prev;
            }
            E result = cur.element;
            cur.element = null;
            cur.nextNode = null;
            cur.prevNode = null;
            size-=1;
            return result;
        }
    }

    public E set(int index, E element){
        if(!checkIndexChange(index)){
            System.out.println("Error! Enter correct index");
            return null;
        }
        else{
            MyNode<E> cur =getNode(index);
            E changed = cur.element;
            cur.element = element;
            return changed;
        }
    }

    public int size(){
        return size;
    }

    public E[] toArray(){
        E[] result = (E[])Array.newInstance(classE,size);
        MyNode<E> cur = first;
        for (int i=0;i<size;i++) {
            result[i] = cur.element;
            cur=cur.nextNode;
        }
        return result;
    }

    public String toString(){
        String result="";
        if(size()==0){
            result="The Collection is empty";
        }
        else {
            MyNode<E> cur = first;
            for (int i = 0; i < (size() - 1); i++) {
                result += cur.element.toString() + "; ";
                cur = cur.nextNode;
            }
            result += cur.element.toString();
        }
        return result;
    }
    public Iterator<E> iterator(){
        return new MyIterator<E>(0);
    }
    public Iterator<E> iterator(int index){
        return new MyIterator<E>(index);
    }
    public MyListIterator<E> myIter(int index){
        checkIndexChange(index);
        return new MyIterator<E>(index);
    }

    MyNode<E> getNode(int index){
        MyNode node = first;
        for(int i=0;i<index;i++){
            node=node.nextNode;
        }
        return node;
    }
    public boolean checkIndexChange(int value){
        return (value>=0)&&(value<=size);
    }
    public boolean checkIndexGet(int value){
        return (value>=0)&&(value<size);
    }

    private class MyIterator<E> implements MyListIterator{
                private int curInd;
        private int nextInd;
        private MyNode<E> nextEl;
        private MyNode<E> curEl;
        private int iterSize;

        public MyIterator(int index){
            iterSize = size;
            nextInd=index;
            if(iterSize==0){
                nextEl=null;
            }
            else{
                nextEl=(MyNode<E>)getNode(nextInd);
            }
        }

        public boolean hasNext(){
            if (nextInd<iterSize){
                return true;
            }
            else {return false;}
        }

        public E next() {
            if (!hasNext()) {
                System.out.println("Next element not found!");
                return null;
            }
            else{
            curInd = nextInd;
            nextInd += 1;
            curEl = nextEl;
            nextEl = nextEl.nextNode;
            return curEl.element;
            }
        }

        public int nextInd(){
            if (hasNext()==false){
                return -1;
            }
            else return nextInd;
        }

        public void remove(){
            if (curEl == null){
                throw new NoSuchElementException("The element isn't found");
            }
            if(curInd==nextInd&&hasNext()){
                nextInd+=1;
                nextEl=nextEl.nextNode;
                iterSize-=1;
            }
            MyLinkedList.this.remove(curInd);
            curEl=null;
        }
    }

    private class MyNode<E>{
        private E element;
        private MyNode<E> prevNode;
        private MyNode<E>  nextNode;

        public MyNode(E element, MyNode<E> prevNode, MyNode<E> nextNode) {
            this.element = element;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
    }
}
