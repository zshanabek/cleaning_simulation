import java.util.Random;

public class MoveRandomStrategy implements MoveStrategy {
    @Override
    public void step(Cleaner aCleaner) {
        Random random = new Random();
        int max = 3;
        int min = -3;
        aCleaner.x += random.nextInt(max - min + 1) + min;
        aCleaner.y += random.nextInt(max - min + 1) + min;
        Dirt[] dirts = aCleaner.simulation.dirts;
        for (int i = 0; i < dirts.length; i++) {
            double c1c2 = Math.sqrt(Math.pow((dirts[i].x - aCleaner.x), 2) + Math.pow((dirts[i].y - aCleaner.y), 2));
            if (c1c2 == aCleaner.size / 2 + dirts[i].size / 2 || c1c2 < aCleaner.size / 2 + dirts[i].size / 2) {
                aCleaner.simulation.dirts = Dirt.removeTheElement(dirts, i);
                aCleaner.numberOfDirtsCleaned++;
            }
        }
    }
}
