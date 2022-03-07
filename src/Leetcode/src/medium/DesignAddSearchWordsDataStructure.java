package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DesignAddSearchWordsDataStructure {

	public static void main(String[] args) {

	}

	// can use a Hashmap
	// but not practical enough to solve in general use cases
	// such as search autocomplete system, word search 2 LC

}

class WordDictionary {

	private Map<Integer, Set<String>> map;

	public WordDictionary() {
		map = new HashMap<>();
	}

	public void addWord(String word) {
		int len = word.length();
		if (!map.containsKey(len))
			map.put(len, new HashSet<>());

		map.get(len).add(word);
	}

	public boolean search(String word) {
		int len = word.length();
		for (String w : map.get(len)) {
			int i = 0;
			while ((i < len) && (word.charAt(i) == w.charAt(i) || word.charAt(i) == '.'))
				i++;
			if (i == len)
				return true;
		}
		return false;
	}

	//using a trie
	// its nothing but nested hashmaps
}

class WordDictionary2 {

	//using class node trie
	class Trie {
		Map<Character, Trie> children = new HashMap<>();
		boolean word = false;
	}

	Trie trieNode;

	public WordDictionary2() {
		trieNode = new Trie();
	}

	public void addWord(String word) {
		// create a temp trie currNode to add chars of word in nested maps
		Trie currNode = trieNode;

		for (char ch : word.toCharArray()) {
			if (!currNode.children.containsKey(ch)) {
				currNode.children.put(ch, new Trie());
			}
			// update curr currNode
			currNode = currNode.children.get(ch);
		}
		// finally make the node as true
		// so that whenever we are searching for this we know when to stop
		currNode.word = true;
	}

	public boolean search(String word) {
		return searchWord(word, trieNode);
	}

	// TC:
	private boolean searchWord(String word, Trie trieNode) {
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			// if not found
			if (!trieNode.children.containsKey(ch)) {
				//check if char is '.'
				if (ch == '.') {
					// if '.' then check for every node
					for (char key : trieNode.children.keySet()) {
						// get curr child node and recurse for i+1 substring
						Trie child = trieNode.children.get(key);
						if (searchWord(word.substring(i + 1), child))
							return true;
					}
					// if no nodes found and char not equal to '.'
					return false;
				}
			} else {
				// if found update curr node
				trieNode = trieNode.children.get(ch);
			}
		}
		return trieNode.word;
	}
}

