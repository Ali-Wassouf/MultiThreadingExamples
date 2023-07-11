package org.example.vaultcracking;

public class DescendingHacker extends HackerThread {
    public DescendingHacker(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for (int guess = MAX_PASSWORD; guess >= 0; guess--) {
            if (vault.isCorrect(guess)) {
                System.out.println(this.getName() + " guessed the password " + guess);
                System.exit(0);
            }
        }
    }
}
