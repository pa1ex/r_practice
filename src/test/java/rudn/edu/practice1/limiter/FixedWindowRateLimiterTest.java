package rudn.edu.practice1.limiter;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class FixedWindowRateLimiterTest {

    @Test
    public void test() throws InterruptedException {
        RateLimiter rateLimiter = new FixedWindowRateLimiter(20, TimeUnit.SECOND);

        int limited = 0;
        int passed = 0;

        while (true) {
            if (rateLimiter.needLimit(1)) {
                limited += 1;
            } else {
                passed += 1;
            }


            System.out.printf("time: %s, limited: %d, passed: %d\n",
                    LocalDateTime.now().toLocalTime().toString(), limited, passed);

            Thread.sleep(10);
        }
    }
}
