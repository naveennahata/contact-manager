package com.helpshift.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.helpshift.contact.Contact;
import com.helpshift.contact.ContactManager;
import com.helpshift.contact.ContactManagerImpl;
import com.helpshift.trie.Trie;
import com.helpshift.trie.TrieImpl;

/**
 * Created by naveen.nahata on 04/03/17.
 */
public class ContactManagerModule extends AbstractModule {
    /**
     * configure ContactManager Module
     */
    @Override
    protected void configure() {
        bind(new TypeLiteral<Trie<Contact>>(){}).to(new TypeLiteral<TrieImpl<Contact>>(){});
        bind(ContactManager.class).to(ContactManagerImpl.class).in(Singleton.class);
    }
}
