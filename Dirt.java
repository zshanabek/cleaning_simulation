import java.awt.Color;
import java.awt.Graphics2D;

abstract class Dirt extends Location {
    double size;
    Color color;

    public Dirt(double aX, double aY) {
        super(aX, aY);
        x = aX;
        y = aY;
    }

    abstract void draw(Graphics2D g2d);
    
    public abstract String toString();

    public static Dirt[] removeTheElement(Dirt[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length)
            return arr;
        Dirt[] anotherArray = new Dirt[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index)
                continue;
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
}
