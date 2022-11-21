package ir.isc.assignment.memory_statistic;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MemoryUsage extends Thread {
    private Thread newThread;
    private String threadName;

    public MemoryUsage(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        try {
            while (true) {
                long memoryUsage = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000000;
                System.out.println("memory Usage at " + timeFormatter() + " is: " + memoryUsage + " MB");
                Thread.sleep(10000);
            }
        } catch (Exception e) {
            System.out.println("the memory usage thread is exited! error: " + e.getMessage());
        }
    }

    public void start() {
        if (this.newThread == null) {
            newThread = new Thread(this, this.threadName);
            newThread.start();
        }
    }

    private String timeFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        return LocalTime.now().format(formatter);
    }
}
