package model;

import util.Argumentable;
import util.Node;

import java.util.HashMap;

import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Created by jkoike on 4/10/15.
 */
public class SinglyLinkedList extends Structure<String> {
    final _Node head;
    HashMap<String, Object> args;
    String operation;
    public SinglyLinkedList(){
        head = new _Node(null, null);
        args = new HashMap<>();
        operations.put("add", new HashMap<>());
        operations.put("delete", new HashMap<>());
        operations.get("add").put("data", Argumentable.String);
        operations.get("add").put("prev", Argumentable.Node);
        operations.get("delete").put("toDelete", Argumentable.Node);
    }

    @Override
    public boolean setOperation(String name) {
        if(!operations.containsKey(name))
            return false;
        operation = name;
        return true;
    }

    @Override
    public boolean setArgument(String name, Object value) {
        if(!operations.get(operation).containsKey(name))
            return false;
        args.put(name, value);
        return true;
    }

    @Override
    public String go() {
        switch(operation){
            case "add":
                return add((String)args.get("value"), (Node)args.get("prev"));
            case "delete":
                return delete((Node)args.get("toDelete"));
            default: return null;
        }
    }

    private String add(String value, Node position){
        _Node tmp = head;
        while(!tmp.data.equals(position)){
            if(tmp.next == null){
                tmp.next = new _Node(new Node<>(value), null);
                return null;
            }
            else tmp = tmp.next;
        }
        tmp.next = new _Node(new Node<>(value), null);
        return null;
    }

    private String delete(Node toDelete){
        _Node tmp = head;
        while(!tmp.data.equals(toDelete)){
            if(tmp.next == null){
                return "Node never existed!";
            }
            else tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return null;
    }

    public void render(Graphics g) {
        _Node tmp = head;
        int currentX = 20;
        int currentY = 50;

        Polygon arrowHead = new Polygon();
        arrowHead.addPoint( 0,5);
        arrowHead.addPoint( -5, -5);
        arrowHead.addPoint( 5,-5);

        while( tmp.data != null && tmp.next != null ) {
            // Draw the node
            g.drawRect(currentX, currentY, 60, 60);

            // Draw the arrow
            g.drawRect(currentX + 60, currentY, 20, 1);
            g.drawPolygon(arrowHead);
        }
    }

    private class _Node{
        protected Node data;
        protected _Node next;
        protected _Node(Node<String> data, _Node next){
            this.data = data;
            this.next = next;
        }
    }
}
