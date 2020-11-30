public class DryDirtFactory extends DirtFactory {
    @Override
    public Dirt createDirt(int x, int y) {
        return new DryDirt(x, y);
    }
}
