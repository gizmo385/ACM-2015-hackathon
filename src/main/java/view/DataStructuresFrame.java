package view;

import javax.swing.JFrame;
import java.awt.FlowLayout;

import controller.Controller;
import model.Structure;
import model.SinglyLinkedList;

public class DataStructuresFrame extends JFrame {

    // Window properties
    private final static int WIDTH = 500, HEIGHT = 500;

    // Window components
    private DrawingPanel drawingPanel;
    private ControlsPanel controlPanel;

    public DataStructuresFrame() {
        initComponents();
        initFrame();
    }

    private void initComponents() {
        this.drawingPanel = new DrawingPanel(300, 300);
        this.controlPanel = new ControlsPanel(100, 100);
    }

    private void initFrame() {
        super.setSize(WIDTH, HEIGHT);
        super.setLayout( new FlowLayout() );
        super.setDefaultCloseOperation( EXIT_ON_CLOSE );
        super.setLocationRelativeTo( null );
        super.setResizable( false );

        super.add(this.drawingPanel);
        super.add(this.controlPanel);
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Controller.setStructure(sll);
        DataStructuresFrame dsf = new DataStructuresFrame();

        dsf.setVisible(true);
    }
}
