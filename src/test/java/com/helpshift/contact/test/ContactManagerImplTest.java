package com.helpshift.contact.test;

import com.helpshift.contact.Contact;
import com.helpshift.contact.ContactManager;
import com.helpshift.contact.ContactManagerImpl;
import com.helpshift.trie.Trie;
import com.helpshift.trie.TrieImpl;
import org.junit.BeforeClass;

/**
 * Created by naveen.nahata on 04/03/17.
 */
public class ContactManagerImplTest {

    ContactManagerImpl contactManager;

    @BeforeClass
    public void setUp(){
       Trie<Contact> firstNameTrie = new TrieImpl<>();
       Trie<Contact> lastNameTrie = new TrieImpl<>();
        contactManager = new ContactManagerImpl(firstNameTrie,lastNameTrie);
    }

}
