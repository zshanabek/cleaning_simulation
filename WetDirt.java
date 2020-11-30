import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class WetDirt extends Dirt {
    public WetDirt(int x, int y) {
        super(x, y);
        Random random = new Random();
        int max = 10;
        int min = 4;
        int rsize = random.nextInt(max - min + 1) + min;
        this.size = rsize;
        Color[] colors = new Color[] { Color.BLUE, Color.MAGENTA };
        this.color = colors[random.nextInt(2)];
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(this.color);
        g2d.fillRect((int) (this.x - size / 2), (int) (this.y - size / 2), (int) this.size, (int) this.size);
    }

    @Override
    public String toString() {
        return "x: " + x + "; y: " + y;
    }

}
