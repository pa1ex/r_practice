package rudn.edu.practice1.limiter;

public enum TimeUnit {
    SECOND {
        @Override
        int toDivider() {
            return 1;
        }
    },
    MINUTE {
        @Override
        int toDivider() {
            return 60;
        }
    },
    HOUR {
        @Override
        int toDivider() {
            return 3600;
        }
    };

    abstract int toDivider();
    }
