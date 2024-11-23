package rudn.edu.practice1.limiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeakyBucketRateLimiterTest {

    @Test
    public void test() throws InterruptedException {
        LeakyBucketRateLimiter rateLimiter = new LeakyBucketRateLimiter(10, TimeUnit.MINUTE);

        int limitedCounter = 0;
        int passedCounter = 0;

        long startMillis = System.currentTimeMillis();

        while (true) {
            if (rateLimiter.needLimit(1)) {
                limitedCounter += 1;
            } else {
                passedCounter += 1;
            }

            System.out.printf("passed counter: %d", passedCounter);

            if (System.currentTimeMillis() - startMillis > 60000) {
                break;
            }

            Thread.sleep(50);
        }

        Assertions.assertEquals(50, passedCounter);
    }
}
