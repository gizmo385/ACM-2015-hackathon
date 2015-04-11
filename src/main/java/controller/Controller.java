package controller;

import model.Structure;
import util.Argumentable;

import java.util.Map;

public class Controller {

    public String[] numArgs(String method) {
        if (method.equals("add")) {
            return new String[] {"String", "Node"};
        } else if (method.equals("delete")) {
            return new String[] {"Node"};
        } else {
            return new String[] {};
        }
    }

    public String[] getArgs(Structure structure) {
        Map<String, Map<String, Argumentable>> operations = structure.getOperations();

        return null;
    }
}
