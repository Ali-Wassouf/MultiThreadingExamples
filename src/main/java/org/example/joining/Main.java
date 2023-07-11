package org.example.joining;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String... args){
        var list = Arrays.asList(0L, 3746L, 899997L, 8290L);
        var threadList = new ArrayList<FactorialThread>();
        for(long i : list){
            threadList.add(new FactorialThread(i));
        }

        for(Thread thread : threadList){
            thread.start();
        }
        for (Thread thread: threadList){
            try {
                thread.join(2000);
                thread.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for(int i = 0; i < list.size(); i++){
            var thread = threadList.get(i);
            if(thread.isFinished()){
                System.out.println("Factorial of "+list.get(i)+" is "+thread.getResult());
            }else {
                System.out.println("Still waiting for "+list.get(i));
            }
        }
    }
}
