package rudn.edu.practice1.chain;

import rudn.edu.practice1.limiter.RateLimiter;

public class RateLimiterFilter implements PipeFilter {

    private RateLimiter rateLimiter;

    public RateLimiterFilter(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @Override
    public boolean doFilter(Context context) throws Exception {
        if (this.rateLimiter.needLimit(1)) {
            context.add(Context.FAILED_FILER_NAME, "ratelimiter filter");
            return false;
        } else {
            return true;
        }
    }
}
