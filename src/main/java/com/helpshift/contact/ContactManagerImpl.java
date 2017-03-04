package com.helpshift.contact;

import com.google.inject.Inject;
import com.helpshift.trie.Trie;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.util.List;

/**
 * Created by naveen.nahata on 04/03/17.
 */
public class ContactManagerImpl implements ContactManager {

    private final Trie<Contact> firstNameTrie;
    private final Trie<Contact> lastNameTrie;

    @Inject
    public ContactManagerImpl(Trie<Contact> firstNameTrie, Trie<Contact> lastNameTrie) {
        this.firstNameTrie = firstNameTrie;
        this.lastNameTrie = lastNameTrie;
    }

    /**
     * Adding contact with given params firstName and lastName
     * @param firstName
     * @param lastName
     */
    @Override
    public void addContact(String firstName, String lastName) {
        Validate.isTrue(!StringUtils.isEmpty(firstName)||!StringUtils.isEmpty(lastName),"First Name and lastName cannot be empty");

        Contact contact = new Contact(firstName,lastName);

        Validate.isTrue(!isDuplicateEntry(contact),"contact already exist");
    }

    @Override
    public List<Contact> searchContact(String key) {
        return null;
    }

    private boolean isDuplicateEntry(Contact contact){
        
    }
}
