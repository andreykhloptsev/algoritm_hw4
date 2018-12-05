package ru.geekbrains.algoritm.hw_4;

public class MyLinkedList<Item> {

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
            return item;
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
