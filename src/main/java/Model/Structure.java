package main.java.Model;

import main.java.Util.Argumentable;

import java.util.HashMap;

/**
 * Created by jkoike on 4/10/15.
 */
public abstract class Structure<E> {
    private HashMap<String, HashMap<String, Argumentable>> operations;
    public abstract boolean setOperation(String name); // Returns true if success, false if operation doesn't exist
    public abstract boolean setArgument(String name, Object value); // Returns true if success, false if arg doesn't exist
    public HashMap<String, HashMap<String, Argumentable>> getOperations() {
        return operations; // TODO: Make this a deep clone. Fuck it for now.
    }

    protected void setOperations(HashMap<String, HashMap<String, Argumentable>> operations) {
        this.operations = operations;
    }
}
