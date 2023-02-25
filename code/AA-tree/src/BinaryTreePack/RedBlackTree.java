//package BinaryTreePack;
//
//import BinaryTreePack.BaseBinaryTree;
//import BinaryTreePack.Node;
//
//public class RedBlackTree extends BaseBinaryTree {
//    static final boolean RED = false;
//    static final boolean BLACK = true;
//
//    public void insertNode(int key) {
//        Node node = root;
//        Node parent = null;
//
//        while (node != null) {
//            parent = node;
//            if (key < node.data) {
//                node = node.left;
//            }
//            else if (key > node.data) {
//                node = node.right;
//            }
//            else {
//                throw new IllegalArgumentException("BST already contains a node with key " + key);
//            }
//        }
//
//        Node newNode = new Node(key);
////        newNode.color = RED;
//        if (parent == null) {
//            root = newNode;
//        }
//        else if (key < parent.data) {
//            parent.left = newNode;
//        }
//        else {
//            parent.right = newNode;
//        }
//        newNode.parent = parent;
//
//        fixRedBlackPropertiesAfterInsert(newNode);
//    }
//
//    public void fixRedBlackPropertiesAfterInsert(Node node) {
//        Node parent = node.parent;
//
//        // CASE 1
//        if (parent == null) {
//            node.color = BLACK;
//            return;
//        }
//
//        if (parent.color == BLACK) {
//            return;
//        }
//
//        // Начиная отсюда, parent node - красный
//        Node grandparent = parent.parent;
//
//        // CASE 2
//        if (grandparent == null) {
//            parent.color = BLACK;
//            return;
//        }
//
//        // Начиная отсюда, нам нужен uncle node
//        Node uncle = getUncle(parent);
//
//        // CASE 3
//        if (uncle != null && uncle.color == RED) {
//            parent.color = BLACK;
//            grandparent.color = RED;
//            uncle.color = BLACK;
//
//            fixRedBlackPropertiesAfterInsert(grandparent);
//        }
//        else if (parent == grandparent.left) {
//            // CASE 4A
//            if (node == parent.right) {
//                rotateLeft(parent);
//                parent = node;
//            }
//
//            // CASE 5A
//            rotateRight(grandparent);
//
//            parent.color = BLACK;
//            grandparent.color = RED;
//        }
//        else {
//            // CASE 4B
//            if (node == parent.left) {
//                rotateRight(parent);
//                parent = node;
//            }
//
//            // CASE 5B
//            rotateLeft(grandparent);
//            parent.color = BLACK;
//            grandparent.color = RED;
//        }
//    }
//
//    private Node getUncle(Node parent) {
//        Node grandparent = parent.parent;
//        if (grandparent.left == parent) {
//            return grandparent.right;
//        }
//        else if (grandparent.right == parent) {
//            return grandparent.left;
//        }
//        else {
//            throw new IllegalStateException("Parent is not a child of its grandparent");
//        }
//    }
//
////    public void deleteNode(int key) {
////        Node node = root;
////
////        while (node != null && node.data != key) {
////            if (key < node.data) {
////                node = node.left;
////            }
////            else {
////                node = node.right;
////            }
////        }
////
////        if (node == null) {
////            return;
////        }
////
////        Node movedUpNode;
////        boolean deleteNodeColor;
////
////        // Node has zero or one child
////        if (node.left == null || node.right == null) {
////            movedUpNode = deleteNodeWithZeroOrOneChild(node);
////            deleteNodeColor = node.color;
////        }
////
////        // Node has two children
////        else {
////            // Find minimum node of right subtree ("inorder successor" of current node)
////            Node inOrderSuccessor = findMinimum(node.right);
////
////            // Copy inorder successor's data to current node (keep its color!)
////            node.data = inOrderSuccessor.data;
////
////            // Delete inorder successor just as we would delete a node with 0 or 1 child
////            movedUpNode = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
////            deleteNodeColor = inOrderSuccessor.color;
////        }
////
////        if (deleteNodeColor == BLACK) {
////            fixRedBlackPropertiesAfterDelete();
////
////            if (movedUpNode.getClass() == NilNode.class) {
////                replaceParentsChild(movedUpNode.parent, movedUpNode, null);
////            }
////        }
////    }
//
//    public Node searchNode(int key) {
//        Node node = root;
//        while (node != null) {
//            if (key == node.data) {
//                return node;
//            }
//            else if (key < node.data) {
//                node = node.left;
//            }
//            else {
//                node = node.right;
//            }
//        }
//        return null;
//    }
//
//    private void rotateRight(Node node) {
//        Node parent = node.parent;
//        Node leftChild = node.left;
//
//        node.left = leftChild.right;
//        if (leftChild.right != null) {
//            leftChild.right.parent = node;
//        }
//
//        leftChild.right = node;
//        node.parent = leftChild;
//
//        replaceParentsChild(parent, node, leftChild);
//    }
//
//    private void rotateLeft(Node node) {
//        Node parent = node.parent;
//        Node rightChild = node.right;
//
//        node.right = rightChild.left;
//        if (rightChild.left != null) {
//            rightChild.left.parent = node;
//        }
//
//        rightChild.left = node;
//        node.parent = rightChild;
//
//        replaceParentsChild(parent, node, rightChild);
//    }
//
//    private void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
//        if (parent == null) {
//            root = newChild;
//        }
//        else if (parent.left == oldChild) {
//            parent.left = newChild;
//        }
//        else if (parent.right == oldChild) {
//            parent.right = newChild;
//        }
//        else {
//            throw new IllegalStateException("BinaryTreePack.Node is not a child of its parent");
//        }
//
//        if (newChild != null) {
//            newChild.parent = parent;
//        }
//    }
//}
//
//
//// Inner Grandchild - внук, от деда до которого "треугольник"
//// Outer Grandchild - внук, от деда до которого пряма линия