package com.sayantandas;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        LinkedList<String> placesToVisit = new LinkedList<String>();

       /** placesToVisit.add("Santiniketan");
        placesToVisit.add("Prantik");
        placesToVisit.add("Bolpur");
        placesToVisit.add("Burdwan");
        placesToVisit.add("Bandel");
        placesToVisit.add("Uttarpara");

        printList(placesToVisit);

        placesToVisit.add(5,"Hooghly");

        printList(placesToVisit);

        placesToVisit.remove(6);

        printList(placesToVisit); */

        addInOrder(placesToVisit,"Howrah");
        addInOrder(placesToVisit,"Santiniketan");
        addInOrder(placesToVisit,"Bolpur");
        addInOrder(placesToVisit,"Bandel");
        addInOrder(placesToVisit,"Burdwan");
        addInOrder(placesToVisit,"Hooghly");
        addInOrder(placesToVisit,"Uttarpara");

        printList(placesToVisit);
        visit(placesToVisit);

    }
    private static void printList(LinkedList<String> linkedlist){
        Iterator<String>i=linkedlist.iterator();
        while(i.hasNext()){
            System.out.println("Now Visiting "+i.next());
        }
        System.out.println("============");
    }

    private static  boolean addInOrder(LinkedList<String>linkedList,String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                //equal, do not add as match found.
                System.out.println(newCity + " is already included as a destination.");
                return false;
            } else if (comparison > 0) {
                //new City should appear before this one.
                //B->A (Alphabetical Order)
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                //moveon the next City.
            }
        }
        stringListIterator.add(newCity);
        return true;
    }
    private static void visit(LinkedList cities){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String>listIterator=cities.listIterator();
        if(cities.isEmpty()){
            System.out.println("No cities");
        }else{
            System.out.println("Now visiting "+listIterator.next());
            printMenu();
        }
        while(!quit){
            int action=sc.nextInt();
            sc.nextLine();
            switch (action){
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward=true;
                    }
                    if(listIterator.hasNext()){
                    System.out.println("Now Visiting "+listIterator.next());
                    }else{
                        System.out.println("Reached the end of the list");
                        goingForward=false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Visiting "+listIterator.previous());
                    }
                    else{
                        System.out.println("We are at the start of the list");
                        goingForward=true;
                    }
                case 3:
                    printMenu();
                    break;

            }
        }
    }
    private static void printMenu(){
        System.out.println("Available Actions ; \nPress");
        System.out.println("0. To quit\n1.To go to the next City\n2.To go to the previous City\n3.Print Menu Options");
    }
}



