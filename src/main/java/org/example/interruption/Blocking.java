package org.example.interruption;

public class Blocking {

    public static void main(String... args){
        var blocking = new BlockingThread();
        blocking.start();
        blocking.interrupt();
    }

    private static class BlockingThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(5000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
