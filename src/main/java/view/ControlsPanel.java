package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;
import java.util.stream.Collectors;

import model.Structure;
import util.Argumentable;
import controller.Controller;

public class ControlsPanel extends JPanel implements ActionListener {

    private final int WIDTH, HEIGHT;

    public ControlsPanel(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;

        initPanel();
    }

    private void initPanel() {
        String[] methods = Controller.getMethods();

        for( String methodName : methods ) {
            JButton button = new JButton(methodName);
            button.addActionListener(this);

            System.out.printf("Adding a button for the \"%s\" method!\n", methodName);
            add(button);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        JButton source = (JButton) ae.getSource();
        String methodName = source.getText();

        Argumentable[] argumentables = Controller.getArgs(source.getText());

        System.out.printf("The method %s takes the following types as arguments: ", methodName);
        System.out.println(Arrays.stream(argumentables).map(Enum::name).collect(Collectors.joining(", ")));
    }
}
