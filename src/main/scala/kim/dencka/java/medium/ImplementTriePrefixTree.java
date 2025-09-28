package kim.dencka.java.medium;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app")); // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app")); // true
    }

    static class Trie {

        private final static class Node {
            Node[] children = new Node[26];
            boolean isWord;
        }

        private final Node root = new Node();

        public Trie() {
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

        public boolean search(String word) {
            Node node = traverse(word);
            return node != null && node.isWord;
        }

        public boolean startsWith(String prefix) {
            Node node = traverse(prefix);
            return node != null;
        }

        private Node traverse(String target) {
            Node cur = root;
            for (char ch : target.toCharArray()) {
                cur = cur.children[ch - 'a'];
                if (cur == null) return null;
            }
            return cur;
        }
    }

}
