package com.helpshift;

import com.google.inject.Inject;
import com.helpshift.contact.Contact;
import com.helpshift.contact.ContactManager;

import java.io.IOException;
import java.util.List;

/**
 * Created by naveen.nahata on 04/03/17.
 */
public class ContactManagerApplication {
    private final ContactManager contactManager;

    @Inject
    public ContactManagerApplication(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    /**
     * Create contacts for entered line
     * @param line
     * @return
     */
    public List<Contact> searchContact(String line){
        try {
            String[] prefix = line.trim().split(" ");
            if (prefix.length <= 0) {
                System.out.print("Please enter valid prefix");
            }
            List<Contact> res1 = contactManager.searchContacts(prefix[0]);
            return res1;

        } catch (IllegalArgumentException e) {
            System.out.println(
                    String.format("\nError occurred while searching contact. Error message = %s", e.getMessage()));
        }
        return null;
    }

    /**
     * @param line
     * @return
     */
    public void createContact(String line) throws IOException {
        String[] input = line.split(" ");
        try {
            if (input.length <= 0) {
                System.out.print("\nPlease enter valid name");
            } else if (input.length == 1) {
                contactManager.addContact(input[0].trim(), null);
            } else {
                contactManager.addContact(input[0], input[1].trim());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(
                    String.format("\nError occurred while inserting contact. Error message = %s", e.getMessage()));
        }
    }
}
