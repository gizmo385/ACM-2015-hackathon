package view;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import util.Argumentable;
import controller.Controller;

public class ArgumentsDialog extends JDialog {

    private final int WIDTH = 400, HEIGHT = 400;
    private Map<String, JTextField> fields;

    public ArgumentsDialog(JComponent parent, String methodName) {
        setSize(WIDTH, HEIGHT);
        setLayout( new GridLayout(0, 1) );
        setLocationRelativeTo(parent);

        this.fields = new HashMap<>();

        initComponents(methodName);
    }

    private void initComponents(String methodName) {
        HashMap<String, Argumentable> method = Controller.getMethod(methodName);

        // Add text fields for each argument
        for( String argName : method.keySet() ) {
            Argumentable argType = method.get(argName);

            JLabel label = new JLabel(argName);
            JTextField field = new JTextField(15);
            field.setToolTipText("This field expects the following type: " + argType.name());
            fields.put(argName, field);

            add(label);
            add(field);
        }

        // Add the buttons that handle calling the function and canceling execution
        JButton callButton = new JButton("Call function");
        callButton.addActionListener(ae -> publishArgs(method));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(ae -> {
            Arrays.stream(getWindowListeners()).forEach(wl -> removeWindowListener(wl));
            dispose();
        });

        add(callButton);
        add(cancelButton);
    }

    private void publishArgs(HashMap<String, Argumentable> method) {
        for( String argName : fields.keySet() ) {
            Argumentable argType = method.get(argName);
            String value = fields.get(argName).getText();

            // Convert the value based on the type of argument that we are expecting
            switch(argType) {
            case Integral:
                int finalValue;

                try {
                    finalValue = Integer.parseInt(value);
                } catch(NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(this, "Invalid input!", "This field requires an integer!", JOptionPane.ERROR_MESSAGE);
                    break;
                }

                Controller.setArgument(argName, finalValue);
                break;
            case String:
                Controller.setArgument(argName, value);
                break;
            case Node:
                System.out.println("These will be handled later!");
                break;
            default:
                break;
            }
        }

        dispose();
    }
}
