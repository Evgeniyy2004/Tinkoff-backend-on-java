package edu.project1;

import org.jetbrains.annotations.NotNull;

sealed interface GuessResult {

    char[] state();

    int attempt();

    int maxAttempts();

    @NotNull String message();

    record SuccessfulGuess(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
        @Override
        public char[] state() {
            return state;
        }

        @Override
        public int attempt() {
            return attempt;
        }

        @Override
        public int maxAttempts() {
            return maxAttempts;
        }

        @Override
        public @NotNull String message() {
            return message;
        }
    }

    record FailedGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public char[] state() {
            return state;
        }

        @Override
        public int attempt() {
            return attempt;
        }

        @Override
        public int maxAttempts() {
            return maxAttempts;
        }

        @Override
        public @NotNull String message() {
            return  String.format("Missed, mistake %s out of %s", attempt, maxAttempts);
        }
    }
}
