package logic;


// TODO: 5/6/2018 Look into multithreading

// TODO: 5/6/2018 Test different TICK_RATEs later
    /*
    Implement constant TICK with variable, maximum frame times
    http://www.koonsolo.com/news/dewitters-gameloop/
     */
public class GameManager implements Runnable{
    private GameState gs;
    private API api;
    private Thread thread;
    private boolean running = false;

    private final int TICKS_PER_SECOND = 15;
    private final int TICK_SKIP = 1000 / TICKS_PER_SECOND;
    private final int MAX_FRAME_SKIP = 5;

    private final long START_TIME = System.currentTimeMillis();

    public GameManager() {
        gs = new GameState();
        api = new API(gs);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
        run();
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public void run() {
        while (running) {
            System.out.println("testing");
        }
    }

    private long getRunningTime() {
        return System.currentTimeMillis() - START_TIME;
    }
}
