package controller;

import java.util.HashMap;

import java.awt.Graphics;

import util.Argumentable;
import model.Structure;

public class Controller {

    private static Structure<?> structure;

    public static <E> void setStructure( Structure<E> structure ) {
        Controller.structure = structure;
    }

    /**
     * Returns the number of arguments that are required a method defined on some structure.
     *
     * @param method The method whose argument count you are attempting to retrieve
     *
     * @return The number of arguments required by a certain method defined on a structure
     *
     */
    public static int numArgs(String method) {
        return getArgs(method).length;
    }

    /**
     * Returns the argumentables that a particular method takes on a given structure.
     *
     * @param method The method whose argument types you are attempting to retrieve
     *
     * @return An array of Argumentables, which are the types of arguments that can be represented
     * by this visualizer
     */
    public static Argumentable[] getArgs(String method) {
        HashMap<String, HashMap<String, Argumentable>> operations = structure.getOperations();
        HashMap<String, Argumentable> operationArgs = operations.get(method);

        int numValues = operationArgs.values().size();

        return operationArgs.values().toArray(new Argumentable[numValues]);
    }

    /**
     * Returns the methods that this structure has that can be used in the visualization.
     *
     * @return An array of strings representing usable methods in the visualization.
     */
    public static String[] getMethods() {
        HashMap<String, HashMap<String, Argumentable>> operations = structure.getOperations();
        return (String[]) operations.keySet().toArray(new String[operations.size()]);
    }

    public static void renderStructure(Graphics g) {
        structure.render(g);
    }
}
