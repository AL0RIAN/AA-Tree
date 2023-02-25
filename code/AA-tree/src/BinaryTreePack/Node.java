package BinaryTreePack;

public class Node {
    public int data;
    int level;
    Node left;
    Node right;
    Node parent;

    public Node() {
        this.level = 0;
        this.data = 0;
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.level = 1;
    }
}
