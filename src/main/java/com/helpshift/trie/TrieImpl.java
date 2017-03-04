package com.helpshift.trie;

import java.util.Optional;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by naveen.nahata on 04/03/17.
 */
public class TrieImpl<T> implements Trie<T> {

    private Node<T> root;

    public TrieImpl(){
        root = new Node<T>();
    }

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
        }
        node.setComplete(true);
        node.getValueSet().add(value);
    }

    @Override
    public Set<T> getExactMatchValues(String key) {
        Set<T> exactMatchingData = Sets.newHashSet();
        Optional<Node<T>> nodeO = searchNode(key);
        if (nodeO.isPresent() && nodeO.get().isComplete()) {
            exactMatchingData.addAll(nodeO.get().getValueSet());
        }
        return exactMatchingData;
    }

    @Override
    public Set<Pair<T, Boolean>> getValuesWithDist(String prefix) {
        Set<Pair<T, Boolean>> prefixMatchedSet = new HashSet<>();
        Optional<Node<T>> nodeO = searchNode(prefix);
        if (nodeO.isPresent()) {
            prefixMatchedSet = getAllCompleteWordsBelow(nodeO.get(), true).stream()
                    .flatMap(o1 ->
                            o1.getLeft().getValueSet().stream().map(o2 -> new Pair<>(o2, o1.getRight().booleanValue())))
                    .collect(Collectors.toSet());
        }
        return prefixMatchedSet;
    }

    private Set<Pair<Node<T>, Boolean>> getAllCompleteWordsBelow(Node<T> trieNode, boolean isExactMatch) {
        Set<Pair<Node<T>, Boolean>> completeWords = new HashSet<>();
        if (trieNode != null) {
            if (trieNode.isComplete()) completeWords.add(new Pair<>(trieNode, isExactMatch));
            for (Node node : trieNode.getChilds().values()){
                completeWords.addAll(getAllCompleteWordsBelow(node, false));
            }
        }
        return completeWords;
    }

    private Optional<Node<T>> searchNode(String word) {
        Node<T> node = root;
        if (StringUtils.isEmpty(word)) return Optional.empty();

        for (char ch : word.trim().toLowerCase().toCharArray()) {
            if (!node.getChilds().containsKey(ch)) {
                return Optional.empty();
            } else {
                node = node.getChilds().get(ch);
            }
        }
        if (node == root) return Optional.empty();
        return Optional.of(node);
    }
}
