package rudn.edu.practice1.limiter;

public class LeakyBucketRateLimiter implements RateLimiter {
    private long limit;
    private long timeUnitDivider;
    private long currentCounter;

    public LeakyBucketRateLimiter(int limit, TimeUnit timeUnit) {
        this.limit = limit;
        this.timeUnitDivider = timeUnit.toDivider();
    }

    @Override
    public boolean needLimit(long weight) {
        long unixTimeSeconds = System.currentTimeMillis() / 1000L;

        double divider =  ((double) this.limit / (double) this.timeUnitDivider);
        double lowBorder = ((double) unixTimeSeconds * divider);
        long highBorder = (long) (lowBorder + this.limit);

        if (this.currentCounter < lowBorder) {
            this.currentCounter = (long) lowBorder;
        }

        long newCount = this.currentCounter + weight;

        System.out.printf("now: %d, divider: %f, l: %f, h: %d, c: %d, new: %d\n",
                unixTimeSeconds, divider, lowBorder, highBorder, currentCounter, newCount);

        if (newCount > highBorder) {
            return true;
        } else if (newCount <= lowBorder){
            this.currentCounter = (long) lowBorder + weight;
            return false;
        } else if (newCount > lowBorder && newCount <= highBorder) {
            this.currentCounter = newCount;
            return false;
        }

        return false;
    }
}
