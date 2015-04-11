package model;

import util.Argumentable;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by jkoike on 4/10/15.
 */
public class BinaryTree extends Structure<String>{

    HashMap<String, Object> args;
    String operation;
    public BinaryTree(){
        root = new Node("HEAD", null, null);
        args = new HashMap<>();
        operations.put("add", new HashMap<>());
        operations.put("delete", new HashMap<>());
        operations.get("add").put("data", Argumentable.String);
        operations.get("delete").put("toDelete", Argumentable.String);
    }

    @Override
    public String go() {
        System.out.println("Operation: "+operation+", Args: ");
        for(String arg : args.keySet())
            System.out.println(arg+", "+args.get(arg));
        switch(operation){
            case "add":
                return add((String)args.get("data"))?null:"Failed?";
            case "delete":
                return delete(root, (String)args.get("toDelete"))?null:"Failed?";
            default: return null;
        }
    }

    @Override
    public void render(Graphics g) {

    }

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

    public boolean add(String data){
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

    private Node parent = null;
    private boolean delete(Node node, String data) {
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
            return delete(node.left, data);
        } else {
            return delete(node.right, data);
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
