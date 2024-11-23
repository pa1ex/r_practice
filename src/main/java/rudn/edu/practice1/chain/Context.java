package rudn.edu.practice1.chain;

import java.util.HashMap;
import java.util.Map;

public class Context {

    public static String FAILED_FILER_NAME = "failed.filter.name";

    private Map<String, String> contextValues = new HashMap<>();

    public Context() {
    }

    public void add(String key, String value) {
        this.contextValues.put(key, value);
    }

    public String get(String key) {
        return this.contextValues.get(key);
    }
}
