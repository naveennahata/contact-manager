package com.helpshift;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.helpshift.contact.Contact;
import com.helpshift.module.ContactManagerModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * Created by naveen.nahata on 04/03/17.
 */
public class ContactMain {
    public static void main(String args[]) throws IOException {
        Injector injector = Guice.createInjector(new ContactManagerModule());
        ContactManagerApplication app = injector.getInstance(ContactManagerApplication.class);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("1) Add contact 2) Search 3) Exit");
            int input = getIntegerInput(br.readLine());
            switch (input){
                case 1:
                    System.out.print("\nEnter name:");
                    app.createContact(br.readLine());
                    break;
                case 2:
                    System.out.print("\nEnter name:");
                    List<Contact> contactList = app.searchContact(br.readLine());
                    for (Contact contact : contactList){
                        System.out.println(contact.displayContact());
                    }
                    break;
                case 3:
                    System.out.println("Happy Searching");
                    System.exit(0);
                    break;
                default:
                    System.out.print("\nInvalid option entered. Please try again");
            }
        }
    }

    private static int getIntegerInput(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e){
            return -1;
        }
    }

}
