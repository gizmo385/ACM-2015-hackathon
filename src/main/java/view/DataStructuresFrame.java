package view;

import javax.swing.JFrame;
import java.awt.FlowLayout;

import controller.Controller;
import model.Structure;
import model.SinglyLinkedList;

public class DataStructuresFrame extends JFrame {

    // Window properties
    private final static int WIDTH = 700, HEIGHT = 600;

    // Window components
    private DrawingPanel drawingPanel;
    private ControlsPanel controlPanel;

    public DataStructuresFrame() {
        // Frame properties
        super.setSize(WIDTH, HEIGHT);
        super.setLayout( new FlowLayout() );
        super.setDefaultCloseOperation( EXIT_ON_CLOSE );
        super.setLocationRelativeTo( null );
        super.setResizable( false );

        // Components and component properties
        this.drawingPanel = new DrawingPanel(WIDTH - 5, 300);
        this.controlPanel = new ControlsPanel(this, 300, 300);
        this.controlPanel.setLocation(0, 305);

        // Add the components to the view
        super.add(this.drawingPanel);
        super.add(this.controlPanel);
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add("1");
        sll.add("2");
        sll.add("3");
        sll.add("4");
        sll.add("5");
        sll.add("6");
        Controller.setStructure(sll);
        DataStructuresFrame dsf = new DataStructuresFrame();

        dsf.setVisible(true);
    }
}
