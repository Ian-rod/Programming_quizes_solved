import java.util.*;
/*
Design a data structure that supports adding new words and searching for existing words.

Implement the WordDictionary class:

void addWord(word) Adds word to the data structure.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
*/ 
public class WordDictionary {
    List<String> innerDictionary;
    public WordDictionary() {
    innerDictionary=new ArrayList<>();
    }

    public void addWord(String word) {
     innerDictionary.add(word);
    }

    public boolean search(String word) {
     if(word.contains("."))
     {
        for (String w : innerDictionary) {
            if(w.matches(word))
        { 
            return true;
        }
        }
        return false;
     }
     return innerDictionary.contains(word);
    }  

    public void main(String[] args) {
       WordDictionary wd=new WordDictionary();
       wd.addWord("complex");
       wd.addWord("complication");
       System.out.println(wd.search("complic.tion"));
    }
}
