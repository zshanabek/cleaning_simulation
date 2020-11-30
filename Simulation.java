import java.util.Random;

public class Simulation {
    int displayWidth;
    int displayHeight;
    int strategySteps;
    int counter;
    Dirt[] dirts;
    Cleaner[] cleaners;
    MoveStrategy[] strategies;

    public static MoveStrategy getStrategy() {
        Random random = new Random();
        if (random.nextInt(2) == 1)
            return new MoveRandomStrategy();
        return new MoveToDirtStrategy();
    }

    public Simulation(int width, int height, int numberOfDirts, int numberOfCleaners, int strategySteps) {
        this.displayWidth = width;
        this.displayHeight = height;
        this.strategySteps = strategySteps;
        Random random = new Random();

        this.dirts = new Dirt[numberOfDirts];
        this.cleaners = new Cleaner[numberOfCleaners];

        DryDirtFactory dryFactory = new DryDirtFactory();
        WetDirtFactory wetFactory = new WetDirtFactory();

        for (int j = 0; j < numberOfDirts; j++) {
            int rX = random.nextInt(width);
            int rY = random.nextInt(height);
            if (random.nextInt(2) == 1)
                this.dirts[j] = wetFactory.createDirt(rX, rY);
            else
                this.dirts[j] = dryFactory.createDirt(rX, rY);
        }

        for (int i = 0; i < numberOfCleaners; i++)
            cleaners[i] = new Cleaner(random.nextInt(width), random.nextInt(height), 40, this, getStrategy());
    }

    void stepAll() {
        counter++;
        if (counter == strategySteps) {
            for (Cleaner c : this.cleaners)
                c.strategy = getStrategy();
            counter = 0;
        }
        for (Cleaner c : this.cleaners)
            c.step();
    }
}
