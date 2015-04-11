package controller;

import java.util.HashMap;

import java.awt.Graphics;

import util.Argumentable;
import model.Structure;
import util.Argumentable;

import java.util.Map;

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

    public static HashMap<String, Argumentable> getMethod(String methodName) {
        return structure.getOperations().get(methodName);
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

    /**
     * Delegate method for structure.go. This will execute the current operation and supply the
     * current arguments as specified in the user-defined go method.
     *
     * @return null on success, String with error on failure
     */
    public static String execute() {
        return structure.go();
    }

    /**
     * Paints the structure to the graphics object. This can be used to paint onto a JPanel or onto
     * something like a BufferedImage.
     *
     * @param g The graphics object that painting is being done to.
     */
    public static void renderStructure(Graphics g) {
        structure.render(g);
    }

    /**
     * Delegate method for structure.setOperation. This will set the object method that arguments
     * are currently beinge evaluated for.
     *
     * @param operationName The name of the method being evaluated
     */
    public static void setOperation(String operationName) {
        structure.setOperation(operationName);
    }

    /**
     * Delegate method for structure.setArgument. This will set the argument with a particular name
     * to be the object supplied. Type checking is not performed.
     *
     * @param argName The name of the argument that the value should correspond to
     * @param value The value of the argument
     */
    public static void setArgument(String argName, Object value) {
        structure.setArgument(argName, value);
    }
}
