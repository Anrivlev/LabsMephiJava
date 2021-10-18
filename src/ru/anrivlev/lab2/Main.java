package ru.anrivlev.lab2;
import ru.anrivlev.lab1.MyList;

import java.util.*;

public class Main {
    public static void task1() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.trim();
        String[] words = str.split(" ");
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            if (!wordsCount.containsKey(word)) {
                wordsCount.put(word, 1);
            } else {
                wordsCount.put(word, wordsCount.get(word) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry: wordsCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }
    public void task2() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.trim();
        String[] words = str.split(" ");
        Set<String> wordsCount = new TreeSet<>();
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!wordsCount.contains(word)) {
                wordsCount.add(word);
                result.append(word);
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        task1();
    }

    public static class MyTree {
        private Node root;
        private int size;
        public class Node {
            private final Node parent;
            private final MyList children;
            private Object value;
            private final int depth;
            private Node(Object value, Node parent) {
                this.parent = parent;
                this.children = new MyList();
                this.value = value;
                if (parent == null) {
                    this.depth = 0;
                } else this.depth = parent.depth + 1;
            }
            public void addChild(Node value) {
                this.children.add(value);
                size++;
            }
            public void removeChild(int index) {
                this.children.remove(index);
                size--;
            }
            public Node getChild(int index) {
                return (Node) this.children.get(index);
            }
            public Node getParent() {
                return this.parent;
            }
            public Node findParent(Node another) {
                if (this == another) {
                    return this;
                }
                if (this.depth >= another.depth) {
                    return this.parent.findParent(another);
                } else return this.findParent(another.parent);
            }
            public MyList path() {
                MyList path = new MyList(this);
                Node ptr = this.parent;
                while (ptr != null) {
                    path.add(ptr);
                    ptr = ptr.parent;
                }
                return path;
            }
            public MyTree subtree() {
                MyTree subtree = new MyTree();
                subtree.root = new Node(this.value, null);
                subtree.size = 1;
                Node tmp;
                for (int i = 0; i < this.children.getSize(); i++) {
                    tmp = (Node) this.children.get(i);
                    tmp.copyToSubtree(subtree.root);
                }
                return subtree;
            }
            private void copyToSubtree(Node parent) {
                Node copy = new Node(this.value, parent);
                parent.addChild(copy);
                Node tmp;
                for (int i = 0; i < this.children.getSize(); i++) {
                    tmp = (Node) this.children.get(i);
                    tmp.copyToSubtree(copy);
                }
            }
            private void toMyListAddNode(MyList result) {
                result.add(this.value);
                Node tmp;
                for (int i = 0; i < this.children.getSize(); i++) {
                    tmp = (Node) this.children.get(i);
                    tmp.toMyListAddNode(result);
                }
            }
            private Node find(Object value) {
                if (this.value == value) {
                    return this;
                } else {
                    Node result;
                    Node tmp;
                    for (int i = 0; i < this.children.getSize(); i++) {
                        tmp = (Node) this.children.get(i);
                        result = tmp.find(value);
                        if (result != null) return result;
                    }
                    return null;
                }
            }
            private int getMaxDepth() {
                if (this.children.isEmpty()) { return this.depth; }
                int maxDepth = 0;
                for (int i = 0; i < this.children.getSize(); i++) {
                    Node tmp = (Node) this.children.get(i);
                    int maxDepthChild = tmp.getMaxDepth();
                    if (maxDepthChild > maxDepth) { maxDepth = maxDepthChild; }
                }
                return  maxDepth;
            }
        }
        public MyTree() {
            this.root = null;
            this.size = 0;
        }
        public MyTree(Object value) {
            this.root = new Node(value, null);
            this.size = 1;
        }
        public MyList toMyList() {
            MyList result = new MyList();
            result.add(this.root.value);
            for (int i = 0; i < this.root.children.getSize(); i++) {
                Node tmp = (Node) this.root.children.get(i);
                tmp.toMyListAddNode(result);
            }
            return result;
        }
        public Node find(Object value) {
            if (this.root.value == value) {
                return this.root;
            } else {
                Node result;
                for (int i = 0; i < this.root.children.getSize(); i++) {
                    Node tmp = (Node) this.root.children.get(i);
                    result = tmp.find(value);
                    if (result != null) return result;
                }
                return null;
            }
        }
        public int getSize() {
            return size;
        }
        public boolean isEmpty() {
            return this.root == null;
        }
        public int getMaxDepth() {
            int maxDepth = 0;
            for (int i = 0; i < this.root.children.getSize(); i++)
            {
                Node tmp = (Node) this.root.children.get(i);
                int maxDepthChild = tmp.getMaxDepth();
                if (maxDepthChild > maxDepth) {
                    maxDepth = maxDepthChild;
                }
            }
            return maxDepth;
        }
    }
}
