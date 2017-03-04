package com.helpshift.trie;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by naveen.nahata on 04/03/17.
 */

@Data
public class Node<T> {
    public static final short CHAR_SIZE = 26;
    private boolean isComplete = false;
    private HashMap<Character,Node> childs;
    private Set<T> valueSet;

    public Node(){
        this.valueSet = new HashSet<T>();
        this.childs = new HashMap<>();
    }
}
