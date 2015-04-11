package model;

import util.Argumentable;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by jkoike on 4/10/15.
 */
public class SinglyLinkedList extends Structure<String> {
    final _Node head;
    HashMap<String, Object> args;
    String operation;
    public SinglyLinkedList(){
        head = new _Node("HEAD", null);
        args = new HashMap<>();
        operations.put("add", new HashMap<>());
        operations.put("delete", new HashMap<>());
        operations.get("add").put("data", Argumentable.String);
        operations.get("delete").put("toDelete", Argumentable.String);
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
        System.out.println("Operation: "+operation+", Args: ");
        for(String arg : args.keySet())
            System.out.println(arg+", "+args.get(arg));
        switch(operation){
            case "add":
                return add((String)args.get("data"));
            case "delete":
                return delete((String)args.get("toDelete"));
            default: return null;
        }
    }

    //private String add(String value, Node position){
    public String add(String value) {
        _Node tmp = head;
        //head.data = new Node(value);
        //head.next = temp;

        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = new _Node(value, null);
        return null;
    }

    private String delete(String toDelete){
        _Node tmp = head;
        while(!tmp.next.data.equals(toDelete)){
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

        while( tmp.next != null ) {

            tmp = tmp.next;
            // Draw the node
            g.drawRect(currentX, currentY, 60, 60);

            if(tmp.next != null)
                // Draw the arrow
                g.drawRect(currentX + 60, currentY + 30, 20, 1);

            if( tmp.data != null ) {
                g.drawString(tmp.toString(), currentX + 3, currentY + 30);
                System.out.println(tmp.toString());
            }

            currentX += 80;
        }
    }

    private class _Node{
        protected String data;
        protected _Node next;
        protected _Node(String data, _Node next){
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return data;
        }
    }
}
