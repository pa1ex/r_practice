package rudn.edu.practice1.limiter;

public interface RateLimiter {
    boolean needLimit(long weight);
}
