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

}