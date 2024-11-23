package rudn.edu.practice1.chain;

public interface Pipe extends PipeFilter {
    void addFilter(PipeFilter filter);
}
