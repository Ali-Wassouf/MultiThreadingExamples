package org.example.vaultcracking;

public class Police extends Thread{
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(i);
        }

        System.out.println("Game over for you hackers");
        System.exit(0);
    }
}
