package com.helpshift;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.helpshift.module.ContactManagerModule;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by naveen.nahata on 04/03/17.
 */
public class ContactMain {
    public static void main(String args[]) throws IOException {
        Injector injector = Guice.createInjector(new ContactManagerModule());
        ContactManagerApplication app = injector.getInstance(ContactManagerApplication.class);
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1) Add contact 2) Search 3) Exit");
            int input = sc.nextInt();
            switch (input){
                case 1:
                    System.out.print("\nEnter name:");
                    app.createContact(sc.next(sc.nextLine()));
                    System.out.println("\n============================\n");
                    break;
                case 2:
                    System.out.print("\nEnter name:");
                    app.searchContact(sc.nextLine());
                    System.out.println("\n============================\n");
                    break;
                case 3:
                    break;
                default:
                    System.out.print("\nInvalid option entered. Please try again");
                    System.out.println("\n============================\n");
            }
        }
    }
}
