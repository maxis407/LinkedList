public class BinaryThree {

    Node root;

    public BinaryThree(int[] values) {
        root = null;
        for (int value : values) {
            insert(value);
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else {
            if (value < node.value) {
                node.left = insert(node.left, value);
            } else {
                node.right = insert(node.right, value);
            }
        }
        return node;
    }

    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(Node node, int value) {
        if (node == null) {
            return false;
        } else if (node.value == value) {
            return true;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }


    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        } else if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {

            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                Node temp = node.right;
                node.right = null;
                return temp;
            } else if (node.right == null) {
                Node temp = node.left;
                node.left = null;
                return temp;
            } else {
                Node successor = findMin(node.right);
                node.value = successor.value;
                node.right = delete(node.right, successor.value);
            }
        }

        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


}





