package view;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.Dimension;
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
        Border lineBorder = BorderFactory.createLineBorder(Color.black, 5);
        super.setBorder( BorderFactory.createTitledBorder(lineBorder, "Drawing Panel"));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        Controller.renderStructure(g2);
    }
}
