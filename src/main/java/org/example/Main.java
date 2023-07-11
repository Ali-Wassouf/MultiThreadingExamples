package org.example;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private List<Thread> threads = new ArrayList<>();

    /*
     * @param tasks to executed concurrently
     */
    public Main(List<Runnable> tasks) {
        tasks.forEach(task -> threads.add(new Thread(task)));
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        threads.forEach(thread -> thread.start());
    }
}