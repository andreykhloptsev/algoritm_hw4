package ru.geekbrains.algoritm.hw_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<Item> implements Iterable<Item> {

    public class Node{
        Item info;
        Node previous;
        Node next;

        public Node(Item info, Node previous, Node next) {
            this.info = info;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return info.toString();
        }
    }
    private int size=0;
    private Node first= null;
    private Node last = null;

    public class MyLinkedListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else
                current = current.next;
            return current.info;
        }

    }

    @Override
    public Iterator<Item> iterator() {
        return new  MyLinkedListIterator();
    }

    public int getSize(){
        return size;
    }

    private boolean isEmpty(){
        return size==0;
    }

    public void insertFirst(Item item){
        if (isEmpty()){
            Node node= new Node(item,null,null);
            first = node;
            last = first;
        } else {
            Node node = new Node(item, null, first);
            first.previous=node;
            first = node;
        }
        size++;
    }

    public Item deleteFirst() throws NoSuchFieldException{
        if (isEmpty()){
            throw new NoSuchFieldException();
        } else {
            Item item = first.info;
            first = first.next;
            first.previous= null;
            size--;
            return item;
        }
    }

    public void insertLast(Item item){
        if (isEmpty()){
            Node node= new Node(item,null,null);
            first = node;
            last = first;
        } else {
            Node node = new Node(item, last, null);
            last.next = node;
            last = node;
        }
        size++;
    }

    public Item deleteLast() throws NoSuchFieldException{
        if (isEmpty()){
            throw new NoSuchFieldException();
        } else {
            Item item = last.info;
            last = last.previous;
            last.next= null;
            size--;
            return item;
        }
    }


    public void insert(Item item, int place) throws ArrayIndexOutOfBoundsException{
        if (place>size+2|| place<0){
            throw new ArrayIndexOutOfBoundsException();
        }else if (place==1){insertFirst(item);}
        else if (place==size+1){insertLast(item);}
        else{
            Node tempNode =first;
            for (int i = 0; i <place-1 ; i++) {
                tempNode=tempNode.next;
            }
            Node node = new Node(item,tempNode.previous,tempNode);

                tempNode.previous.next=node;
                tempNode.previous=node;
                size++;
        }
    }

    public Item delete(int place) throws ArrayIndexOutOfBoundsException, NoSuchFieldException {
        if (place < 0 || place >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (place == 1) {
            return deleteFirst();
        } else if (place == size) {
            return deleteLast();
        } else
        {
            Node tempNode =first;
            for (int i = 0; i <place-1 ; i++) {
                tempNode=tempNode.next;
            }
            tempNode.previous.next=tempNode.next;
            tempNode.next.previous=tempNode.previous;
            size--;
            return tempNode.info;
        }
    }

    public int find(Item item) throws NoSuchElementException {
        Node temp = first;
        int counter=1;
        while(temp.next!=null){
            if (temp.info==item)
            {
                return counter;
            } else {
                counter++;
                temp=temp.next;
            }
        } if (temp.next.info!=item) {
            throw new NoSuchElementException();
        } else {
            return size;
        }
    }


    @Override
    public String toString() {
       StringBuilder stringBuilder = new StringBuilder(size);
       if (!isEmpty()) {
         Node currentNode= first;
         while(currentNode.next!=null)
          {
               stringBuilder.append(currentNode+" ");
               currentNode=currentNode.next;
           }
           stringBuilder.append(currentNode);
       }
       else
           return null;
       return stringBuilder.toString();
    }
}
