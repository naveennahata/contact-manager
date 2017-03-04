package com.helpshift.contact;

import java.util.List;

/**
 * Created by naveen.nahata on 04/03/17.
 */
public interface ContactManager {
    void addContact(String firstName, String lastName);
    List<Contact> searchContact(String key);
    List<Contact> searchContacts(String searchString);
}
