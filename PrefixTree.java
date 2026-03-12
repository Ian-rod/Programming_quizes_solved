/*
A prefix tree (also known as a trie) is a tree data structure used to efficiently store and retrieve keys in a set of strings. Some applications of this data structure include auto-complete and spell checker systems.

Implement the PrefixTree class:

PrefixTree() Initializes the prefix tree object.
void insert(String word) Inserts the string word into the prefix tree.
boolean search(String word) Returns true if the string word is in the prefix tree (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
*/

import java.util.*;
public class PrefixTree {
    ArrayList<String> innerTree;
    public PrefixTree() {
      innerTree=new ArrayList<>();
    }

    public void insert(String word) {
      innerTree.add(word);
    }

    public boolean search(String word) {
        return innerTree.contains(word);
    }

    public boolean startsWith(String prefix) {
        for (String s : innerTree) {
            if(s.startsWith(prefix))
            {
                return true;
            }
        }
        return false;
    }
}
