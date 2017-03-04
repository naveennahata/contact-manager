package com.helpshift.trie;

import java.util.Set;

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

    /**
     * Getting Exact match Set
     * @param key
     * @return
     */
    Set<T> getExactMatchValues(String key);

    /**
     *
     */
    Set<Pair<T,Boolean>> getValuesWithDist(String prefix);
}
