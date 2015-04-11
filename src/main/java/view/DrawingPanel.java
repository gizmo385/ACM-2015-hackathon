import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawingPanel extends JPanel {

    private final int WIDTH, HEIGHT;

    public DrawingPanel(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;

        initComponents();
        initPanel();
    }

    private void initComponents() {
    }

    private void initPanel() {
        super.setSize(WIDTH, HEIGHT);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
    }
}
