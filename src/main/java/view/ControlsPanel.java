package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.util.Arrays;
import java.util.stream.Collectors;

import model.Structure;
import util.Argumentable;
import controller.Controller;

public class ControlsPanel extends JPanel implements ActionListener, WindowListener {

    private final int WIDTH, HEIGHT;

    public ControlsPanel(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        super.setSize(WIDTH, HEIGHT);
        Border lineBorder = BorderFactory.createLineBorder(Color.black, 5);
        super.setBorder( BorderFactory.createTitledBorder(lineBorder, "Controls"));

        initPanel();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
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
        Controller.setOperation(methodName);

        Argumentable[] argumentables = Controller.getArgs(source.getText());

        System.out.printf("The method %s takes the following types as arguments: ", methodName);
        System.out.println(Arrays.stream(argumentables).map(Enum::name).collect(Collectors.joining(", ")));

        String success = null;
        ArgumentsDialog ad = new ArgumentsDialog(this, methodName);
        ad.addWindowListener(this);
        ad.setVisible(true);
    }

    public void windowClosed(WindowEvent we) {
        String errorMessage = Controller.execute();

        if( errorMessage == null ) {
            JOptionPane.showMessageDialog(this, "The method executed successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "The execution failed with the following error: " + errorMessage, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* Unimplemented window listener methods */
    public void windowActivated(WindowEvent we) { }
    public void windowClosing(WindowEvent we) { }
    public void windowDeactivated(WindowEvent we) { }
    public void windowDeiconified(WindowEvent we) { }
    public void windowIconified(WindowEvent we) { }
    public void windowOpened(WindowEvent we) { }
}
