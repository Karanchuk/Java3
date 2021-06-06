import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            // barrier на подготовку к старту
            MainClass.barrier.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            synchronized (race.getMon()) {
                if (MainClass.winnerCount++ == 0) {
                    System.out.println(this.name + " победил в гонке");
                } else {
                    System.out.println(this.name + " пришел к финишу под номером " + MainClass.winnerCount);
                }
            }
            MainClass.barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
