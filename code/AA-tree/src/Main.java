import BinaryTreePack.AATree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AATree tree = new AATree();
        System.out.print("PROGRAM START");

        while (true) {
            System.out.print(
                    """
                    \n1 - INSERT
                    2 - DELETE
                    3 - SEARCH
                    4 - 2D OUTPUT
                    5 - INORDER
                    6 - PREORDER
                    7 - POSTORDER
                    8 - NUMBER OF NODES
                    9 - CLEAR TREE
                    0 - EXIT
                    ENTER:\040"""
            );
            int choice = scan.nextInt();
            switch (choice) {
                case 0 -> System.exit(1);
                case 1 -> {
                    System.out.print("\nEnter data for insert: ");
                    int data = scan.nextInt();
                    tree.insert(data);
                }
                case 2 -> {
                    System.out.print("\nEnter data for delete: ");
                    int data = scan.nextInt();
                    tree.delete(data);
                }
                case 3 -> {
                    System.out.print("\nEnter data for search: ");
                    int data = scan.nextInt();
                    if (tree.search(data)) {
                        System.out.printf("Node %d in the tree\n", data);
                    } else {
                        System.out.printf("Node %d not in the tree\n", data);
                    }
                }
                case 4 -> {
                    tree.print2D(tree.getRoot());
                }
                case 5 -> {
                    System.out.print("\nInorder traversal: ");
                    tree.inorderTraversal(tree.getRoot());
                }
                case 6 -> {
                    System.out.print("\nPreorder traversal: ");
                    tree.preorderTraversal(tree.getRoot());
                }
                case 7 -> {
                    System.out.print("\nPostorder traversal: ");
                    tree.postorderTraversal(tree.getRoot());
                }
                case 8 -> {
                    System.out.println("\nNumber of nodes: " + tree.countNodes(tree.getRoot()));
                }
                case 9 -> {
                    tree.clear();
                    System.out.println("\nComplete!");
                }
            }
        }
    }
}
