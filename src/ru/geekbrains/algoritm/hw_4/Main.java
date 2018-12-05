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
        System.out.println(list.toString());
    }
}
