package org.example.threadinitializationusingthread;

public class Main {

    public static void main(String... args){
        var thread = new MyThread();
        thread.start();
    }
    private static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("MyThread is now running");
        }
    }
}
