package rudn.edu.practice1.chain;

import java.util.ArrayList;
import java.util.List;

public class ProcessingPipe implements Pipe {
    private List<PipeFilter> filters = new ArrayList<>();

    public ProcessingPipe(List<PipeFilter> filters) {
        this.filters = filters;
    }

    public ProcessingPipe() {
        this.filters = new ArrayList<>();
    }

    public List<PipeFilter> getFilters() {
        return filters;
    }

    public void addFilter(PipeFilter filter) {
        this.filters.add(filter);
    }

    @Override
    public boolean doFilter(Context context) throws Exception {
        for (PipeFilter filter : this.filters) {
            if (!filter.doFilter(context)) {
                throw new RuntimeException("filter not passed");
            }
        }

        return true;
    }
}
