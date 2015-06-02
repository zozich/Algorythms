package prometheus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Alex on 12.03.2015.
 */
public class BinarySearchTrees {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = readFromFile("D:\\JavaProjects\\Algorythms\\input_07.txt");
        System.out.println(list.size());
        Tree tr = new Tree();

    }

    private static ArrayList<Integer> readFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<Integer> list = new ArrayList<Integer>();
        String[] i = reader.readLine().split(" ");
        for (String s:i) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }

    static class Node {
        private int data;
        private Node left;
        private Node right;
        private Node parent;

        public int getData() {
            return this.data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return this.parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    static class Tree {
        private Node root;
        public Tree() {
            this.root = null;
        }
    }
}
