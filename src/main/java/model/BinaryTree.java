package model;

import util.Argumentable;
import util.Config;
import util.Tuple;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by jkoike on 4/10/15.
 */
public class BinaryTree extends Structure<String>{
    int maxDepth = 0;

    HashMap<Node, Tuple<Integer, Integer>> map;
    public BinaryTree(){
        root = null;
        map = new HashMap<>();
        operations.put("add", new HashMap<>());
        operations.put("delete", new HashMap<>());
        operations.get("add").put("data", Argumentable.String);
        operations.get("delete").put("toDelete", Argumentable.String);
    }

    @Override
    public String go() {
        System.out.println("Operation: "+operation+", Args: ");
        for(String arg : args.keySet())
            System.out.println(arg+", "+args.get(arg).toString());
        switch(operation){
            case "add":
                return add((String)args.get("data"))?null:"Failed?";
            case "delete":
                return delete(root, (String)args.get("toDelete"))?null:"Failed?";
            default: return null;
        }
    }

    private void index(Node node, int depth, int index){
        if (depth > maxDepth){
            maxDepth = depth;
        }
        map.put(node, new Tuple<>(depth, index));
        if(node.left != null)
            index(node.left, depth + 1, index * 2 - 1);
        if(node.right != null)
            index(node.right, depth + 1, index * 2);
    }

    private void draw(Node n, Graphics g){
        int x = map.get(n).two * Config.D_WIDTH / ((int)Math.pow(map.get(n).one, 2) + 1)+60;
        int y = map.get(n).one * Config.D_HEIGHT/ ((maxDepth > 0)?maxDepth:1);
        System.out.println("Printing "+n.data+" at "+x+", "+y);
        g.drawRect(x/2, y/2, 60, 60);
        if(n.data != null){
            g.drawString(n.data, x/2 + 3, y/2 + 30);
        }
        if(n.left != null){
            int xL = map.get(n.left).two * Config.D_WIDTH / (int)(Math.pow(map.get(n.left).one, 2) + 1)+120;
            int yL = map.get(n.left).one * Config.D_HEIGHT/ maxDepth;
            g.drawLine(x/2, (y+60)/2, xL/2, yL/2);
            draw(n.left, g);
        }
        if(n.right != null){
            int xR = map.get(n.right).two * Config.D_WIDTH / ((int)Math.pow(map.get(n.right).one, 2) + 1)+120;
            int yR = map.get(n.right).one * Config.D_HEIGHT/ maxDepth;
            g.drawLine(x/2, (y+60)/2, xR/2, yR/2);
            draw(n.right, g);
        }
    }

    @Override
    public void render(Graphics g) {
        if(root != null) {
            index(root, 0, 1);
            draw(root, g);
        }
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
        if(root == null)
            root = new Node(data, null, null);
        else if ( data.compareTo(node.data) < 0 ) {
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
        return true;
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
