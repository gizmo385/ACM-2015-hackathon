package model;

import util.Argumentable;
import util.Node;

import java.util.HashMap;

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
        ops = new HashMap<>();
        ops.put("add", new HashMap<>());
        ops.put("delete", new HashMap<>());
        ops.get("add").put("data", Argumentable.String);
        ops.get("add").put("prev", Argumentable.Node);
        ops.get("delete").put("toDelete", Argumentable.Node);
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

    private class _Node{
        protected Node data;
        protected _Node next;
        protected _Node(Node<String> data, _Node next){
            this.data = data;
            this.next = next;
        }
    }
}
