public class MoveToDirtStrategy implements MoveStrategy {
    @Override
    public void step(Cleaner aCleaner) {
        int index;
        double min;
        Dirt dirt;
        Dirt[] dirts;

        index = 0;
        dirt = null;
        min = 999999;
        dirts = aCleaner.simulation.dirts;
        for (int i = 0; i < dirts.length; i++) {
            if (aCleaner.distanceTo(dirts[i]) < min) {
                min = aCleaner.distanceTo(dirts[i]);
                dirt = dirts[i];
                index = i;
            }
        }
        if (dirt != null) {
            double angle = Math.atan2(dirt.y - aCleaner.y, dirt.x - aCleaner.x);
            aCleaner.x += 2 * Math.cos(angle);
            aCleaner.y += 2 * Math.sin(angle);
            double c1c2 = Math.sqrt(Math.pow((dirt.x - aCleaner.x), 2) + Math.pow((dirt.y - aCleaner.y), 2));
            if (c1c2 == aCleaner.size / 2 + dirt.size / 2 || c1c2 < aCleaner.size / 2 + dirt.size / 2) {
                aCleaner.simulation.dirts = Dirt.removeTheElement(dirts, index);
                aCleaner.numberOfDirtsCleaned++;
            }
        }
    };
}
