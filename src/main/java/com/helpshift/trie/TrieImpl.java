package com.helpshift.trie;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
/**
 * Created by naveen.nahata on 04/03/17.
 */
public class TrieImpl<T> implements Trie<T> {

    private Node<T> root;

    @Override
    public void insert(String key, T value) {
        Node<T> node = root;
        Validate.isTrue(!StringUtils.isEmpty(key), "key is empty");
        for (char ch : key.trim().toLowerCase().toCharArray()){
            if (!node.getChilds().containsKey(ch)){
                Node child = new Node();
                node.getChilds().put(ch,child);
                node = child;
            } else {
                node = node.getChilds().get(ch);
            }
            node.setComplete(true);
            node.getValueSet().add(value);
        }
    }
}
