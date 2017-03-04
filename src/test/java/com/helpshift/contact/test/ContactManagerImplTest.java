package com.helpshift.contact.test;

import com.helpshift.contact.Contact;
import com.helpshift.contact.ContactManagerImpl;
import com.helpshift.trie.Trie;
import com.helpshift.trie.TrieImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naveen.nahata on 04/03/17.
 */
public class ContactManagerImplTest {

    private static ContactManagerImpl contactManager;

    public ContactManagerImpl getContactManager(){
        Trie<Contact> firstNameTrie = new TrieImpl<>();
        Trie<Contact> lastNameTrie = new TrieImpl<>();
        return new ContactManagerImpl(firstNameTrie,lastNameTrie);

    }

    @BeforeClass
    public static void setUp(){
       Trie<Contact> firstNameTrie = new TrieImpl<>();
       Trie<Contact> lastNameTrie = new TrieImpl<>();
        contactManager = new ContactManagerImpl(firstNameTrie,lastNameTrie);
    }

    @Test
    public void addContactTest(){
        contactManager.addContact("Chris","Harris");
        contactManager.addContact("Chris","");
        try {
            contactManager.addContact("Chris","Harris");
            Assert.fail();
        } catch (Exception e){
            Assert.assertEquals(e.getMessage(),"contact already exist");

        }
    }

    @Test
    public void searchContact(){
        ContactManagerImpl contactManager1 = getContactManager();
        contactManager1.addContact("Chris","Harris");
        contactManager1.addContact("Chris","");
        List<Contact> arrayList = contactManager1.searchContacts("Ch");
        Assert.assertEquals(arrayList.size(),2);
    }
}
