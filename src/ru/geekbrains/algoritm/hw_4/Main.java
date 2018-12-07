package ru.geekbrains.algoritm.hw_4;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException {
	    MyLinkedList<Integer> list = new MyLinkedList<>();
    	list.insertFirst(5);
        list.insertFirst(6);
        list.insertFirst(3);
        list.deleteFirst();
        list.insertFirst(7);
        list.deleteFirst();
        list.insertFirst(5);
        list.insertLast(25);
        list.insert(113,1);
        list.insert(18,3);
        list.insert(list.delete(4),3);
        list.insert(24,list.find(18));
        System.out.println(list.toString());
        list.insert(1,112);

    }
}
