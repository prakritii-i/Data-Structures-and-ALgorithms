class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BST {
    Node root;

    public BST() {
        root = null;
    }

    // Method to insert a new key into the BST
    Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Method to perform an inorder traversal of the BST
    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.key + " ");
            inorderTraversal(root.right);
        }
    }

    // Method to perform a preorder traversal of the BST
    void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    // Method to perform a postorder traversal of the BST
    void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.key + " ");
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();

        // Insert elements into the BST
        bst.root = bst.insert(bst.root, 50);
        bst.root = bst.insert(bst.root, 30);
        bst.root = bst.insert(bst.root, 20);
        bst.root = bst.insert(bst.root, 40);
        bst.root = bst.insert(bst.root, 70);
        bst.root = bst.insert(bst.root, 60);
        bst.root = bst.insert(bst.root, 80);

        // Perform inorder traversal
        System.out.println("Inorder traversal of the BST:");
        bst.inorderTraversal(bst.root);
        System.out.println();

        // Perform preorder traversal
        System.out.println("Preorder traversal of the BST:");
        bst.preorderTraversal(bst.root);
        System.out.println();

        // Perform postorder traversal
        System.out.println("Postorder traversal of the BST:");
        bst.postorderTraversal(bst.root);
    }
}
