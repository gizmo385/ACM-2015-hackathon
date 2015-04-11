package util;

/**
 * Created by jkoike on 4/10/15.
 */
public class Node<K> {
    K data;
    public Node(K data){
        this.data = data;
    }

    public boolean equals(Object o) {
        return data.equals(o);
    }

    public String toString() {
        return data.toString();
    }
}
