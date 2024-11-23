package rudn.edu.practice1.limiter;

public class FixedWindowRateLimiter implements RateLimiter {

    private long lowBorder;
    private long counter;
    private long limit;
    private TimeUnit limitTimeunit;

    public FixedWindowRateLimiter(long limit, TimeUnit limitTimeunit) {
        this.limit = limit;
        this.limitTimeunit = limitTimeunit;
        this.counter = 0;
        this.lowBorder = getCurrentLowBorder();
    }

    @Override
    public boolean needLimit(long weight) {

        long nowLowBorder = getCurrentLowBorder();

        if (nowLowBorder > this.lowBorder) {
            this.lowBorder = nowLowBorder;
            this.counter = 0;
        }

        long newCount = this.counter + weight;
        if (newCount > this.limit) {
            return true;
        } else {
            this.counter = newCount;
            return false;
        }
    }

    private long getCurrentLowBorder() {
        return ((System.currentTimeMillis() / 1000L) / limitTimeunit.toDivider()) * limitTimeunit.toDivider();
    }
}
