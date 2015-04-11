package Model;

import Util.Argumentable;
import Util.Node;

import java.util.HashMap;

/**
 * Created by jkoike on 4/10/15.
 */
public class SinglyLinkedList extends Structure<String> {
    final _Node head;
    public SinglyLinkedList(){
        head = new _Node(null, null);
        HashMap<String, HashMap<String, Argumentable>> ops = new HashMap<>();
        ops.put("add", new HashMap<>());
        ops.put("delete", new HashMap<>());
        ops.get("add").put("data", Argumentable.String);
        ops.get("add").put("prev", Argumentable.Node);
        ops.get("delete").put("toDelete", Argumentable.Node);
    }

    @Override
    public boolean setOperation(String name) {
        return false;
    }

    @Override
    public boolean setArgument(String name, Object value) {
        return false;
    }

    private void add(String value, Node position){
        _Node tmp = head;
        while(!tmp.data.equals(position)){
            if(tmp.next == null){
                tmp.next = new _Node(new Node<>(value), null);
            }
            else tmp = tmp.next;
        }
    }

    private class _Node{
        protected Util.Node data;
        protected _Node next;
        protected _Node(Node<String> data, _Node next){
            this.data = data;
            this.next = next;
        }
    }
}
