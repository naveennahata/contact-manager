package com.helpshift.trie;

/**
 * Created by naveen.nahata on 04/03/17.
 */
public interface Trie<T> {

    /**
     * Insert key and value associated with Trie DS
     * @param key
     * @param value
     */
    void insert(String key,T value);
}
