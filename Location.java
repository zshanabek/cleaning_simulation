public class Location {
    double x;
    double y;

    public Location(double aX, double aY) {
        x = aX;
        y = aY;
    }

    public double distanceTo(Location other) {
        double deltaX = this.x - other.x;
        double deltaY = this.y - other.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
