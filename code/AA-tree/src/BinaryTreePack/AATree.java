package BinaryTreePack;

public class AATree extends BaseBinaryTree {
    private static final Node nil = new Node();
    static final int COUNT = 10;

    public AATree() {
        root = nil;
    }

    public void clear() {
        root = nil;
    }

    public void insert(int data) {
        root = insertNode(data, root);
    }

    private Node insertNode(int data, Node node) {
        if (node == nil) {
            node = new Node(data, nil, nil);
        } else if (data < node.data) {
            node.left = insertNode(data, node.left);
        } else if (data > node.data) {
            node.right = insertNode(data, node.right);
        } else {
            return node;
        }

        node = skew(node);
        node = split(node);
        return node;
    }

    public void delete(int data) {
        root = deleteNode(data, root);
    }

    private Node deleteNode(int data, Node node) {
        if (node == nil) {
            return node;
        } else if (data > node.data) {
            node.right = deleteNode(data, node.right);
        } else if (data < node.data) {
            node.left = deleteNode(data, node.left);
        } else {
            if (node.left == nil && node.right == nil) {
                return nil;
            } else if (node.left == nil) {
                Node temp = node.right;
                while (temp.left.data != 0) {
                    temp = temp.left;
                }
                node.right = deleteNode(temp.data, node.right);
                node.data = temp.data;
            } else {
                Node temp = node.left;
                while (temp.right.data != 0) {
                    temp = temp.right;
                }
                node.left = deleteNode(temp.data, node.left);
                node.data = temp.data;
            }
        }

        node = decreaseLevel(node);
        node = skew(node);
        node.right = skew(node.right);

        if (node.right != nil) {
            node.right.right = skew(node.right.right);
        }
        node = split(node);
        node.right = split(node.right);
        return node;
    }

    private Node skew(Node node) {
        if (node == nil) {
            return nil;
        } else if (node.left == nil) {
            return node;
        } else if (node.left.level == node.level) {
            Node leftChild = node.left;
            node.left = leftChild.right;
            leftChild.right = node;
            return leftChild;
        } else {
            return node;
        }
    }

    private Node split(Node node) {
        if (node == nil) {
            return nil;
        } else if (node.right == nil || node.right.right == nil) {
            return node;
        } else if (node.level == node.right.right.level) {
            Node rightChild = node.right;
            node.right = rightChild.left;
            rightChild.left = node;

            rightChild.level = rightChild.level + 1;
            return rightChild;
        } else {
            return node;
        }
    }

    private Node decreaseLevel(Node node) {
        int shouldBe = Math.min(node.left.level, node.right.level) + 1;
        if (shouldBe < node.level) {
            node.level = shouldBe;
            if (shouldBe < node.right.level) {
                node.right.level = shouldBe;
            }
        }
        return node;
    }

    public int countNodes(Node rNode) {
        if (rNode == nil) {
            return 0;
        } else {
            int l = 1;
            l += countNodes(rNode.left);
            l += countNodes(rNode.right);
            return l;
        }
    }

    public boolean search(int data) {
        return searchNode(root, data);
    }

    private boolean searchNode(Node rNode, int data) {
        boolean found = false;
        while ((rNode != nil) && !found) {
            int rData = rNode.data;
            if (data < rData) {
                rNode = rNode.left;
            } else if (data > rData) {
                rNode = rNode.left;
            } else {
                found = true;
                break;
            }
            found = searchNode(rNode, data);
        }
        return found;
    }

    public void inorderTraversal(Node rNode) {
        if (rNode != nil) {
            inorderTraversal(rNode.left);
            System.out.printf("%d ", rNode.data);
            inorderTraversal(rNode.right);
        }
    }

    public void preorderTraversal(Node rNode) {
        if (rNode != nil) {
            System.out.printf("%d ", rNode.data);
            preorderTraversal(rNode.left);
            preorderTraversal(rNode.right);
        }
    }

    public void postorderTraversal(Node rNode) {
        if (rNode != nil) {
            postorderTraversal(rNode.left);
            postorderTraversal(rNode.right);
            System.out.printf("%d ", rNode.data);
        }
    }

    public void print2DUtil(Node root, int space) {
        if (root == null)
            return;

        space += COUNT;

        print2DUtil(root.right, space);

        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        print2DUtil(root.left, space);
    }

    public void print2D(Node root) {
        print2DUtil(root, 0);
    }
}
