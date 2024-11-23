package rudn.edu.practice1.chain;

import org.junit.jupiter.api.Test;
import rudn.edu.practice1.limiter.FixedWindowRateLimiter;
import rudn.edu.practice1.limiter.TimeUnit;

import java.util.List;

public class ChainTest {


    @Test
    public void test() throws Exception {
        PipeFilter logFilter = new LoggingPipeFilter("begin");
        PipeFilter rateLimitFilter = new RateLimiterFilter(new FixedWindowRateLimiter(10, TimeUnit.MINUTE));
        PipeFilter finishLogFilter = new LoggingPipeFilter("finish");

        ProcessingPipe processingPipe = new ProcessingPipe();
        processingPipe.addFilter(logFilter);
//        processingPipe.addFilter(rateLimitFilter);
        processingPipe.addFilter(finishLogFilter);

        while (true) {
            processingPipe.doFilter(new Context());
            Thread.sleep(500);
        }
    }
}
