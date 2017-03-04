package com.helpshift.trie.test;

import com.helpshift.contact.Contact;
import com.helpshift.trie.Pair;
import com.helpshift.trie.TrieImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

/**
 * Created by naveen.nahata on 04/03/17.
 */
public class TrieImplTest {
    private static TrieImpl<Contact> trie;

    private TrieImpl<Contact> getTrie(){
        return new TrieImpl<>();
    }

    @BeforeClass
    public static void setUp(){
        trie = new TrieImpl<>();
    }

    @Test
    public void testSimpleInsert(){
        Contact contact = new Contact("Chris","Harris");
        trie.insert("Chris",contact);
        Assert.assertEquals(trie.getExactMatchValues("Chris").size(),1);
    }

    @Test
    public void testSimpleEmptykey(){
        try {
            Contact contact = new Contact("","Harris");
            trie.insert("",contact);
            Assert.fail();
        } catch (Exception e){
            Assert.assertEquals(e.getMessage(),"key is empty");
        }
    }

    @Test
    public void testExactMatchValues(){
        Contact contact = new Contact("Chris","Harris");
        trie.insert("Harris",contact);
        Assert.assertEquals(trie.getExactMatchValues("Harris").size(),1);

    }

    @Test
    public void testGetValuesWithDist(){
        TrieImpl<Contact> trie1 = getTrie();
        Contact contact1 = new Contact("Chris1","Harris");
        Contact contact2 = new Contact("Chris","");
        trie1.insert("Chris1",contact1);
        trie1.insert("Chris",contact2);
        Set<Pair<Contact, Boolean>> set = trie1.getValuesWithDist("Chris");
        Assert.assertEquals(set.size(),2);
        for (Pair<Contact,Boolean> pair : set){
            if (pair.getLeft()==contact1){
                Assert.assertEquals(pair.getRight(),false);
            }
            else if (pair.getLeft()==contact2){
                Assert.assertEquals(pair.getRight(),true);
            }

        }
    }
}
