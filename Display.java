import java.awt.*;
import javax.swing.*;

public class Display extends JPanel {
    Simulation simulation;
    private static final long serialVersionUID = 1L;

    public Display(Simulation aSimulation) {
        simulation = aSimulation;
        setBackground(Color.WHITE);
    }

    public Dimension getPreferredSize() {
        return new Dimension(simulation.displayWidth, simulation.displayHeight);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Cleaner c : this.simulation.cleaners)
            c.draw(g2d);
        for (Dirt d : this.simulation.dirts)
            d.draw(g2d);
    }
}
