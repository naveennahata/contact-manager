package com.helpshift.trie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by naveen.nahata on 04/03/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pair<L,R> {
    private L left;
    private R right;
}
