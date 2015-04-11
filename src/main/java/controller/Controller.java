package controller;

import model.Structure;
import util.Argumentable;

import java.util.Map;

public class Controller {

    /**
     * Returns the number of arguments that are required a method defined on some structure.
     *
     * @param structure The structure that the method should be defined on.
     * @param method The method whose argument count you are attempting to retrieve
     *
     * @return The number of arguments required by a certain method defined on a structure
     *
     */
    public static int numArgs(Structure structure, String method) {
        return getArgs(structure, method).length;
    }

    /**
     * Returns the argumentables that a particular method takes on a given structure.
     *
     * @param structure The structure that the method should be defined on.
     * @param method The method whose argument types you are attempting to retrieve
     *
     * @return An array of Argumentables, which are the types of arguments that can be represented
     * by this visualizer
     */
    public static Argumentable[] getArgs(Structure structure, String method) {
        Map<String, Map<String, Argumentable>> operations = structure.getOperations();
        Map<String, Argumentable> operationArgs = operations.get(method);

        return (Argumentable[]) operationArgs.values().toArray();
    }
}
