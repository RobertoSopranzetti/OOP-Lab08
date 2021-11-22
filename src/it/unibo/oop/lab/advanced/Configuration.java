package it.unibo.oop.lab.advanced;

public final class Configuration {

    private final int max;
    private final int min;
    private final int attempts;

    /**
     * @param max
     * @param min
     * @param attempts
     */
    private Configuration(final int max, final int min, final int attempts) {
        this.max = max;
        this.min = min;
        this.attempts = attempts;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @return the number of attempts
     */
    public int getAttempts() {
        return attempts;
    }

    public boolean isConsistent() {
        return attempts > 0 && min < max;
    }

    public class Builder {
        private static final int MAX = 100;
        private static final int MIN = 0;
        private static final int ATTEMPTS = 10;

        private int min = MIN;
        private int max = MAX;
        private int attempts = ATTEMPTS;
        private boolean consumed = false;

        /**
         * 
         * @param min value
         * @return this builder
         */
        public Builder setMin(final int min) {
            this.min = min;
            return this;
        }

        /**
         * 
         * @param max value
         * @return this builder
         */
        public Builder setMax(final int max) {
            this.max = max;
            return this;
        }

        /**
         * 
         * @param attempt
         * @return this builder
         */
        public Builder setAttempts(final int attempt) {
            this.attempts = attempt;
            return this;
        }

        public final Configuration build() {
            if (consumed) {
                throw new IllegalStateException("The Builder can only be udes once");
            }
            consumed = true;
            return new Configuration(max, min, attempts);
        }
    }
}

