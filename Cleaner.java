import java.awt.Graphics2D;
import java.awt.*;

public class Cleaner extends Location {
    double size;
    int numberOfDirtsCleaned;
    Simulation simulation;
    MoveStrategy strategy;

    public Cleaner(int x, int y, int aSize, Simulation aSimulation, MoveStrategy aStrategy) {
        super(x, y);
        size = aSize;
        strategy = aStrategy;
        simulation = aSimulation;
    }

    void step() {
        strategy.step(this);
    }

    void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawOval((int) (this.x - (size / 2)), (int) (this.y - (size / 2)), (int) (this.size), (int) (this.size));
        g2d.setColor(Color.red);
        g2d.drawString(String.valueOf(numberOfDirtsCleaned), (int) (this.x - 6), (int) (this.y + 2));
    }
}
