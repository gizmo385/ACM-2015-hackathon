package view;

import controller.Controller;
import model.SinglyLinkedList;
import model.RenderableArray;
import util.Config;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class DataStructuresFrame extends JFrame implements ActionListener {
    // Window properties
    private final static int WIDTH = 700, HEIGHT = 650;

    // Panels
    private DrawingPanel drawingPanel;
    private ControlsPanel controlPanel;

    public DataStructuresFrame() {
        // Frame properties
        super.setSize(Config.WIDTH, Config.HEIGHT);
        super.setLayout( new FlowLayout() );
        super.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        super.setTitle("Data Structures Visualization");
        super.setLocationRelativeTo( null );
        super.setResizable( false );


        // Components and component properties
        drawingPanel = new DrawingPanel(Config.D_WIDTH, Config.D_HEIGHT);
        controlPanel = new ControlsPanel(this, Config.C_WIDTH, Config.C_HEIGHT);
        controlPanel.setLocation(0, 305);

        // Add the components to the view
        super.add(drawingPanel);
        super.add(controlPanel);

        // Set up the menu
        JMenuBar jmb = new JMenuBar();
        JMenu structuresMenu = new JMenu("Structures");

        for( String structureName : Controller.getStructureNames() ) {
            JMenuItem menuItem = new JMenuItem(structureName);
            menuItem.addActionListener(this);

            structuresMenu.add(menuItem);
        }

        jmb.add(structuresMenu);

        setJMenuBar(jmb);

    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        RenderableArray ra = new RenderableArray();

        final String LINKED_LIST = "Linked List";
        final String GROWABLE_ARRAY = "Growable Array";

        Controller.addStructure("LinkedList", sll);
        Controller.addStructure("Array", ra);
        Controller.setStructure("Array");

        DataStructuresFrame dsf = new DataStructuresFrame();

        dsf.setVisible(true);
    }

    public void actionPerformed( ActionEvent ae ) {
        JMenuItem source = (JMenuItem)ae.getSource();
        Controller.setStructure(source.getText());
        controlPanel.reloadButtons();
        controlPanel.revalidate();
        controlPanel.repaint();
    }
}
