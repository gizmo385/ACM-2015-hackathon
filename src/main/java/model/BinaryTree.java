package model;

/**
 * Created by jkoike on 4/10/15.
 */
public class BinaryTree {

    private class Node {
        String data;
        Node left;
        Node right;

        public Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    private boolean add(String data){
        return addHelp(root, data);
    }

    private boolean addHelp(Node node, String data) {
        if ( node.data.equals(data) || (node.left == null && node.right == null) ) {
            return false;
        } else if ( data.compareTo(node.data) < 0 ) {
            if (node.left == null) {
                node.left = new Node(data, null, null);
                return true;
            } else {
                addHelp(node.left, data);
            }
        } else if ( data.compareTo(node.data) > 0 ) {
            if (node.right == null) {
                node.right = new Node(data, null, null);
                return true;
            } else {
                addHelp(node.right, data);
            }
        }
        return false;
    }

    private boolean delete(Node toDelete) {
        return deleteHelp(root, toDelete.data);
    }

    private Node parent = null;
    private boolean deleteHelp(Node node, String data) {
        if (node == null) {
            return false;
        }
        if (node.data.compareTo(data) == 0) {

            if ((node.left == null) && (node.right == null)) {
                // leaf node
                node = null;
                return true;
            }

            if ((node.left != null) && (node.right != null)) {
                // node with two children
                node.data = findMinimumAndReturnWithDelete(node.right);
                return true;
            }

            // either left child or right child
            if (node.left != null) {
                parent.left = node.left;
                node = null;
                return true;
            }

            if (node.right != null) {
                parent.right = node.right;
                node = null;
                return true;
            }
        }
        parent = node;
        if (node.data.compareTo(data) > 0) {
            return deleteHelp(node.left, data);
        } else {
            return deleteHelp(node.right, data);
        }
    }

    private String findMinimumAndReturnWithDelete(Node node) {
        if (node.left == null) {
            String v = node.data;
            node = null;
            return v;
        }
        return findMinimumAndReturnWithDelete(node.left);
    }

}
