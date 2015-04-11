import javax.swing.JFrame;

public class DataStructuresFrame extends JFrame {

    private final static int WIDTH = 500, HEIGHT = 500;

    public DataStructuresFrame() {
        initComponents();
        initFrame();
    }

    private void initComponents() {

    }

    private void initFrame() {
        super.setSize(WIDTH, HEIGHT);
        super.setLayout( null );
        super.setDefaultCloseOperation( EXIT_ON_CLOSE );
        super.setLocationRelativeTo( null );
        super.setResizable( false );
    }

    public static void main(String[] args) {

    }
}
