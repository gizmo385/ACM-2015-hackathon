package Model;

import Util.Node;
import Util.Tuple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Function;

/**
 * Created by jkoike on 4/10/15.
 */
public class LinkedList extends Structure<Integer> {
    @Override
    Iterator<Integer> walk() {
        return null;
    }

    @Override
    HashMap<String, Function<Object[], Object>> getOperations() {
        return null;
    }

    @Override
    Tuple<String, Class[]>[] getOperationInformation() {
        return new Tuple[]{
                new Tuple<>("add", new Class[]{Node.class}),
                new Tuple<>("delete", new Class[]{Node.class}),
        };
    }
}
