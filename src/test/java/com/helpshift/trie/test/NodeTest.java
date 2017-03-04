package com.helpshift.trie.test;

import com.helpshift.contact.Contact;
import com.helpshift.trie.Node;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by naveen.nahata on 04/03/17.
 */
public class NodeTest {
    @Test
    public void NodeSetupTest(){
        Node<Contact> node = new Node();
        Assert.assertNotNull(node.getValueSet());
        Assert.assertNotNull(node.getChilds());
    }

}
