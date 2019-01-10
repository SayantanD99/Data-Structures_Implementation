package com.sayantandas;

import java.util.Scanner;

public class Main {

    /**
     Create a program that implements a simple mobile phone with the following capabilities.
     Able to store, modify, remove and query contact names.
     You will want to create a separate class for Contacts (name and phone number).
     Create a master class (MobilePhone) that holds the ArrayList of Contacts
     The MobilePhone class has the functionality listed above.
     Add a menu of options that are available.
     Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact and search/find contact.
     When adding or updating be sure to check if the contact already exists (use name)
     Be sure not to expose the inner workings of the Arraylist to MobilePhone e.g. no ints, no .get(i) etc
     MobilePhone should do everything with Contact objects only.
     */

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("9933985143");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\nEnter Action : (6 to show the available actions)");
            int action=scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0 :

                    System.out.println("\nShutting Down...");
                    quit=true;
                    break;

                case 1 :

                    mobilePhone.printContacts();
                    break;

                case 2 :

                    addNewContact();
                    break;

                case 3 :

                    updateContact();
                    break;

                case 4 :

                    removeContact();
                    break;

                case 5 :

                    queryContact();
                    break;

                case 6 :

                    printActions();
                    break;

                default :

                    System.out.println("\nInvalid Option.");
                    break;
            }

        }
    }

    private static void addNewContact(){

        System.out.println("Enter New Contact Name : ");
        String name = scanner.nextLine();
        System.out.println("Enter Phone Number : ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name,phone);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("\nNew Contact Added : Name -> "+name+" , Phone -> "+phone);
        }
        else{
            System.out.println("\nCannot Add , "+name+" already exists on the directory.");
        }

    }

    private static void updateContact(){

        System.out.println("Enter Contact Name : ");
        String name = scanner.nextLine();
        Contact existingContactRecord=mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("\nContact Not Found.");
        }
        System.out.println("\nEnter new Contact Name - ");
        String newName = scanner.nextLine();
        System.out.println("\nEnter Contact Phone number - ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,newNumber);
        if(mobilePhone.updateContact(existingContactRecord,newContact)){
            System.out.println("\nSuccessfully Updated Record");
        }
        else{
            System.out.println("\nError Updating Record.");
        }
    }

    private static void removeContact() {

        System.out.println("Enter Contact Name : ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("\nContact Not Found.");
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("\nSuccessfully Deleted.");
        }
        else{
            System.out.println("\nError Deleting the Contact");
        }
    }

    private static void queryContact() {

        System.out.println("Enter Contact Name : ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("\nContact Not Found.");
        }
        System.out.println("Name : "+existingContactRecord.getName()+" \t Phone Number - "+existingContactRecord.getPhoneNumber());
    }

    private static void startPhone(){

        System.out.println("Starting the Phone...");

    }

    private static void printActions(){

        System.out.println("\nAvailable Actions : \nPress - \n");
        System.out.println("0. To ShutDown.");
        System.out.println("1. To Print the Contacts.");
        System.out.println("2. To Add a New Contact.");
        System.out.println("3. To Update an Existing Contact.");
        System.out.println("4. To Remove an Existing Contact.");
        System.out.println("5. To Query if an Contact Exists in the directory or not.");
        System.out.println("6. To Print the List of available Actions.");
        System.out.println("\n Enter Your Choice Below - ");

    }
}
