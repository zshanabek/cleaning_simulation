import javax.swing.JFrame;

public class SimulationRunner {
  public static void main(String[] args) {
    try {
      if (args.length != 5) {
        System.out.println("Usage: CleanSim <Width><Height><NumberOfDirts><NumberOfCleaners><StrategySteps>");
        return;
      }
      int displayWidth = Integer.parseInt(args[0]);
      int displayHeight = Integer.parseInt(args[1]);
      int numberOfDirts = Integer.parseInt(args[2]);
      int numberOfCleaners = Integer.parseInt(args[3]);
      int strategySteps = Integer.parseInt(args[4]);
      Simulation simulation = new Simulation(displayWidth, displayHeight, numberOfDirts, numberOfCleaners,
          strategySteps);
      Display display = new Display(simulation);
      JFrame frame = new JFrame("Cleaning Simulation" + "[" + displayWidth + "x" + displayHeight + " " + numberOfDirts
          + "/" + numberOfCleaners + ":" + strategySteps + "]");
      frame.add(display);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationByPlatform(true);
      frame.pack();
      frame.setVisible(true);
      while (true) {
        simulation.stepAll();
        display.repaint();
        Thread.sleep(40);
      }
    } catch (Exception e) {
      System.out.println("An exception has been raised!");
      System.out.println(e.toString());
    }
  }
}