package kim.dencka.java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(suggestedProducts(products, searchWord));
        System.out.println(suggestedProductsTrie(products, searchWord));
        // output: [[mobile, moneypot, monitor], [mobile, moneypot, monitor], [mouse, mousepad], [mouse, mousepad], [mouse, mousepad]]
    }

    // brute force
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : searchWord.toCharArray()) {
            sb.append(ch);
            results.add(findFirstThree(products, sb.toString()));
        }

        return results;
    }

    public static List<String> findFirstThree(String[] products, String target) {
        List<String> result = new ArrayList<>();
        for (String product : products) {
            if (result.size() == 3) break;
            if (product.startsWith(target)) {
                result.add(product);
            }
        }
        return result;
    }


    // trie
    public static List<List<String>> suggestedProductsTrie(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();

        for (String w : products) {
            trie.insert(w);
        }

        StringBuilder prefix = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            prefix.append(c);
            result.add(trie.startsWith(prefix.toString()));
        }

        return result;
    }

    static class Trie {

        static class Node {
            Node[] children = new Node[26];
            boolean isWord = false;
        }

        Node root;
        List<String> results;

        Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node cur = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new Node();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }


        public List<String> startsWith(String prefix) {
            Node cur = root;
            results = new ArrayList<>();

            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return results;
                }
                cur = cur.children[c - 'a'];
            }

            dfsWithPrefix(cur, prefix);
            return results;
        }

        private void dfsWithPrefix(Node curr, String word) {
            if (results.size() == 3) return;
            if (curr.isWord) results.add(word);

            for (char c = 'a'; c <= 'z'; c++) {
                if (curr.children[c - 'a'] != null) {
                    dfsWithPrefix(curr.children[c - 'a'], word + c);
                }
            }
        }
    }

}
