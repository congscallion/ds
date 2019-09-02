/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

/**
 *
 *
 * @author wangcong
 * @version $Id: TrieTree.java, v0.1 8/20/19 10:28 AM wangcong Exp $$
 */
public class TrieTree implements Tree {

  private static final int ALPHABET = 26;
  private TrieNode root;


  public TrieTree() {
    this.root = new TrieNode();
  }

  public static void main(String[] args) {

    TrieTree trieTree = new TrieTree();

    // Input keys (use only 'a' through 'z' and lower case)
    String keys[] = {"the", "a", "there", "answer", "any",
        "by", "bye", "their"};

    String output[] = {"Not present in trie", "Present in trie"};

    int i;
    for (i = 0; i < keys.length; i++) {
      trieTree.insert(keys[i]);
    }

    if (trieTree.search("the") == true) {
      System.out.println("the --- " + output[1]);
    } else {
      System.out.println("the --- " + output[0]);
    }

    if (trieTree.search("these") == true) {
      System.out.println("these --- " + output[1]);
    } else {
      System.out.println("these --- " + output[0]);
    }

    if (trieTree.search("their") == true) {
      System.out.println("their --- " + output[1]);
    } else {
      System.out.println("their --- " + output[0]);
    }

    if (trieTree.search("thaw") == true) {
      System.out.println("thaw --- " + output[1]);
    } else {
      System.out.println("thaw --- " + output[0]);
    }
  }

  void insert(String key) {

    int level;
    int length = key.length();
    int index;

    TrieNode pCrawl = root;

    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (pCrawl.children[index] == null) {
        pCrawl.children[index] = new TrieNode();
      }

      pCrawl = pCrawl.children[index];
    }

    pCrawl.isEndOfWord = true;

  }


  boolean search(String key) {
    int level;
    int length = key.length();
    int index;

    TrieNode pCrawl = root;

    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (pCrawl.children[index] == null) {
        return false;
      }
      pCrawl = pCrawl.children[index];
    }

    return (pCrawl != null && pCrawl.isEndOfWord);
  }

  static class TrieNode {

    TrieNode[] children = new TrieNode[ALPHABET];
    boolean isEndOfWord;

    TrieNode() {
      isEndOfWord = false;
      for (int i = 0; i < ALPHABET; i++) {
        children[i] = null;
      }
    }

  }


}
