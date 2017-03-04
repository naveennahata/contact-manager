package com.helpshift.contact;

import com.google.inject.Inject;
import com.helpshift.trie.Pair;
import com.helpshift.trie.Trie;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public List<Contact> searchContacts(String searchString) {
        List<Contact> prefixMatchedContacts = new ArrayList<>();
        if (!StringUtils.isEmpty(searchString)) {
            Set<Pair<Contact, Boolean>> firstNameMatch = firstNameTrie.getValuesWithDist(searchString);
            Set<Contact> firstNameMatchContact = firstNameMatch.stream().map(o -> o.getLeft()).collect(Collectors.toSet());

            Set<Pair<Contact, Boolean>> lastNameMatch = lastNameTrie.getValuesWithDist(searchString);
            Set<Pair<Contact, Boolean>> lastNameMatchFiltered = lastNameMatch.stream().filter(o ->
                    !firstNameMatchContact.contains(o.getLeft())).collect(Collectors.toSet());
            firstNameMatch.addAll(lastNameMatchFiltered);
            prefixMatchedContacts = firstNameMatch.stream()
                    .sorted((o1,o2) -> o1.getRight()==o2.getRight() ? 0 : (o1.getRight() ? -1:1))
                    .map(o->o.getLeft())
                    .collect(Collectors.toList());
        }
        return prefixMatchedContacts;
    }

    /**
     * Checking if contact alrady exist
     * @param contact
     * @return
     */
    private boolean isDuplicateEntry(Contact contact){
        Set<Contact> matchedContacts = firstNameTrie.getExactMatchValues(contact.getFirstName());
        matchedContacts.addAll(lastNameTrie.getExactMatchValues(contact.getLastName()));
        if (matchedContacts.size() > 0 && matchedContacts.stream().filter(o -> o.equals(contact)).count() > 0) {
            return true;
        }
        return false;
    }
}
