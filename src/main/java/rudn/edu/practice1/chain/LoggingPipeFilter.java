package rudn.edu.practice1.chain;

public class LoggingPipeFilter implements PipeFilter {

    private String text;

    public LoggingPipeFilter(String text) {
        this.text = text;
    }

    @Override
    public boolean doFilter(Context context) throws Exception {
        System.out.println(this.text);
        return true;
    }
}
