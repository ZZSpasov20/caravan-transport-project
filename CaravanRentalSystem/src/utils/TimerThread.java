package utils;

import DataAccessLayer.repositories.CaravanRepository;

public class TimerThread extends Thread{
    private int time = 0;

    private static TimerThread instance = new TimerThread();

    public static TimerThread getInstance() {

        return instance;
    }

    public int getTime() {
        return time;
    }

    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                time++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
