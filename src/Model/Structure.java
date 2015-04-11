package Model;

import Util.Tuple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Function;

/**
 * Created by jkoike on 4/10/15.
 */
public abstract class Structure<E> {
    abstract Iterator<E> walk(); // Return an iterator that walks through every node in the structure
    abstract HashMap<String, Function<Object[], Object>> getOperations();
    abstract Tuple<String, Class[]>[] getOperationInformation();
}
