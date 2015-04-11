package model;

import util.Argumentable;

import java.util.HashMap;

/**
 * Time to explain all of my bullshit!
 * Conceptual workflow goes:
 *  getOperations tells us what we need to do (And what we need to do it)
 *  setOperation tells us what we are doing
 *  setArgument is called to fill the arguments for our operation
 */
public abstract class Structure<E> {
    HashMap<String, Object> args;
    String operation;
    protected HashMap<String, HashMap<String, Argumentable>> ops;

    /**
     * @param name Name of the operation to be done
     * @return True if the operation exists and is possible, false otherwise
     */
    public boolean setOperation(String name) {
        if(!ops.containsKey(name))
            return false;
        operation = name;
        return true;
    }

    /**
     * @param name Name of the argument being set
     * @param value Value to set the argument to
     * @return True if the argument exists and is being set to a valid value, false otherwise
     */
    public boolean setArgument(String name, Object value) {
        if(!ops.get(operation).containsKey(name))
            return false;
        args.put(name, value);
        return true;
    }
    public abstract String go(); // Does the thing. Returns null if success, fail message if fail

    /**
     *
     * @return Nested HashMap describing possible operations for given data structure
     * Example for SinglyLinkedList:
     *      "add" -> "value"(Value of node to be added) -> String
     *               "prev"(Node before insertion location) -> Node
     *      "delete" -> "toDelete" -> Node
     */
    public HashMap<String, HashMap<String, Argumentable>> getOperations() {
        return ops; // TODO: Make this a deep clone. Fuck it for now.
    }

    protected void setOperations(HashMap<String, HashMap<String, Argumentable>> operations) {
        this.ops = operations;
    }
}
