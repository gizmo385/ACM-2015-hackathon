package view;

import controller.Controller;
import model.SinglyLinkedList;
import util.Config;

import javax.swing.*;
import java.awt.*;

public class DataStructuresFrame extends JFrame {


    public DataStructuresFrame() {
        // Frame properties
        super.setSize(Config.WIDTH, Config.HEIGHT);
        super.setLayout( new FlowLayout() );
        super.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        super.setLocationRelativeTo( null );
        super.setResizable( false );

        // Components and component properties
        DrawingPanel drawingPanel = new DrawingPanel(Config.D_WIDTH, Config.D_HEIGHT);
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
