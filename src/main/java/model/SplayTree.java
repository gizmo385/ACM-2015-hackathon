package model;

/**
 * Created by jkoike on 4/11/15.
 */
public class SplayTree extends Structure<Integer> {
    public static void main(String[] args) {
        SplayTree test = new SplayTree();
        test.add(4);
        test.add(2);
        test.add(1);
        test.add(3);
        test.add(6);
        test.add(5);
        test.add(7);
        test.zigZig(test.head.right, test.head.right.right);
        System.out.println("Success?");
    }
    _Node head;
    public SplayTree(){
        head = null;
    }
    @Override
    public String go() {
        return null;
    }

    public String add(int i){
        _Node tmp = head;
        while(tmp != null){
            if(tmp.val > i) {
                if(tmp.left != null)
                    tmp = tmp.left;
                else {
                    tmp.left = new _Node(i);
                    tmp.left.parent = tmp;
                    return splay(tmp.left);
                }
            }
            else {
                if(tmp.right != null)
                    tmp = tmp.right;
                else {
                    tmp.right = new _Node(i);
                    tmp.right.parent = tmp;
                    return splay(tmp.right);
                }
            }
        }
        head = new _Node(i);
        return null;
    }

    public String splay(_Node n){
        //if((tmp.left == parent && parent.right == child)
        //        || (tmp.right == parent && parent.left == child))
        return null;
    }

    public String zig(_Node child, _Node parent){
        if(parent.left == child){
            _Node tmp = child.right;
            child.right = parent;
            child.parent = null;
            parent.left = tmp;
            tmp.parent = parent;
        }
        if(parent.right == child){
            _Node tmp = child.left;
            child.left = parent;
            child.parent = null;
            parent.right = tmp;
            tmp.parent = parent;
        }
        else
            return "Cannot zig when parent is not root";
        return null;
    }

    private String zigZag(_Node child, _Node parent){
        _Node tmp = parent.parent;
        child.parent = tmp.parent;
        if(tmp == head) {
            head = child;
            child.parent = null;
        }
        else if(tmp.parent.left == tmp.parent) {
            tmp.parent.left = child;
            child.parent = tmp.parent;
        }
        else {
            tmp.parent.right = child;
            child.parent = tmp.parent;
        }
        if(parent.right == child) {
            tmp.left = child.right;
            if(tmp.left != null)
                tmp.left.parent = tmp;
            child.right = tmp;
            tmp.parent = child;
            parent.right = child.left;
            if(parent.right != null)
                parent.right.parent = parent;
            child.left = parent;
            parent.parent = child;
        }
        else {
            tmp.right = child.left;
            if(tmp.right != null)
                tmp.right.parent = tmp;
            child.left = tmp;
            tmp.parent = child;
            parent.left = child.right;
            if(parent.left != null)
                parent.left.parent = parent;
            child.right = parent;
            parent.parent = child;
        }
        return null;
    }

    private String zigZig(_Node child, _Node parent){
        _Node tmp = parent.parent;
        child.parent = tmp.parent;
        if(tmp == head) {
            head = child;
        }
        else if(tmp.parent.left == tmp.parent) {
            tmp.parent.left = child;
            child.parent = tmp.parent;
        }
        else {
            tmp.parent.right = child;
            child.parent = tmp.parent;
        }
        if(tmp.left == parent && parent.left == child){
            parent.left = child.right;
            parent.left.parent = parent;
            child.right = parent;
            parent.parent = child;
            tmp.left = parent.left;
            parent.left.parent = tmp;
            parent.left = tmp;
            tmp.parent = parent;
        }
        else{
            parent.right = child.left;
            parent.right.parent = parent;
            child.left = parent;
            parent.parent = child;
            tmp.right = parent.right;
            parent.right.parent = tmp;
            parent.right = tmp;
            tmp.parent = parent;
        }
        return null;
    }

    private class _Node{
        protected _Node left, right, parent;
        protected int val;
        public _Node(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }
}
