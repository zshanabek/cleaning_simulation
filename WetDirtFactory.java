public class WetDirtFactory extends DirtFactory {
    @Override
    public Dirt createDirt(int x, int y) {
        return new WetDirt(x, y);
    }
}
