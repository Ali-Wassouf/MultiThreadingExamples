package org.example.vaultcracking;

public class Vault {
    private int password;

    public Vault(int password) {
        this.password = password;
    }

    public boolean isCorrect(int password){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {

        }
        return this.password == password;
    }
}
