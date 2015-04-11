package view;

import javax.swing.JPanel;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import controller.Controller;

public class DrawingPanel extends JPanel {

    private final int WIDTH, HEIGHT;

    public DrawingPanel(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;

        initPanel();
    }

    private void initPanel() {
        super.setSize(WIDTH, HEIGHT);
        super.setBorder( BorderFactory.createLineBorder(Color.black, 5) );
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        Controller.renderStructure(g2);
    }
}
