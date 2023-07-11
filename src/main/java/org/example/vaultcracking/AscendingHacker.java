package org.example.vaultcracking;

public class AscendingHacker extends HackerThread{

    public AscendingHacker(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for (int guess = 0; guess < MAX_PASSWORD; guess++) {
            if (vault.isCorrect(guess)) {
                System.out.println(this.getName() + " guessed the password " + guess);
                System.exit(0);
            }
        }
    }
}
