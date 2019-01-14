package com.sayantandas;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Sayantan",55.98);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(58.52);
        System.out.println("Balance for "+customer.getName()+" is "+customer.getBalance());
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(4);
        for(int i=0;i<intList.size();i++){
            System.out.println(i+": "+intList.get(i));
        }
        intList.add(2,3);
        for(int i=0;i<intList.size();i++){
            System.out.println(i+": "+intList.get(i));
        }
    }
}
