package org.example.vaultcracking;

public abstract class HackerThread extends Thread {
    protected Vault vault;
    protected final int MAX_PASSWORD = 999;

    public HackerThread(Vault vault) {
        this.vault = vault;
        this.setName(this.getClass().getSimpleName());
        this.setPriority(Thread.MAX_PRIORITY);
    }

    @Override
    public void start(){
        System.out.println("Starting thread " +this.getName());
        super.start();
    }
}
