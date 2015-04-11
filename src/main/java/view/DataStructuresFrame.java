package view;

import controller.Controller;
import model.SinglyLinkedList;

import javax.swing.*;
import java.awt.*;

public class DataStructuresFrame extends JFrame {

    // Window properties
    private final static int WIDTH = 700, HEIGHT = 600;

    public DataStructuresFrame() {
        // Frame properties
        super.setSize(WIDTH, HEIGHT);
        super.setLayout( new FlowLayout() );
        super.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        super.setLocationRelativeTo( null );
        super.setResizable( false );

        // Components and component properties
        DrawingPanel drawingPanel = new DrawingPanel(WIDTH - 5, 300);
        ControlsPanel controlPanel = new ControlsPanel(this, 300, 300);
        controlPanel.setLocation(0, 305);

        // Add the components to the view
        super.add(drawingPanel);
        super.add(controlPanel);
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add("1");
        Controller.setStructure(sll);
        DataStructuresFrame dsf = new DataStructuresFrame();

        dsf.setVisible(true);
    }
}
