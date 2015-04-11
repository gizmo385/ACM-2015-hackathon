package model;

/**
 * Created by jkoike on 4/10/15.
 */
public class BinaryTree {
    
    private class Node {
        String data;
        Node left;
        Node right;

        public Node(String data, Node, left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    final Node root;

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

    private Node delete(Node toDelete) {
        
    }

}
