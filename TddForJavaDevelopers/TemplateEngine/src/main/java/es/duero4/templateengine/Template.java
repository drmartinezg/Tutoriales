package es.duero4.templateengine;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Ramon
 */
class Template {
    private Map<String, String> variables;
    private final String templateText;

    public Template(String templateText) {
        this.variables = new HashMap<String, String>();
        this.templateText = templateText;
    }

    void set(String name, String value) {
        this.variables.put(name, value);
    }
    
    public String evaluate() {
        String result = replaceVariables();
        checkForMissingValues(result);
        return result;
    }

    private String replaceVariables() {
        String result = templateText;
        for (Entry<String, String> entry : variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }

    private void checkForMissingValues(String result) {
        if (result.matches(".*\\$\\{.+\\}.*")) {
            throw new MissingValueException();
        }
    }
}
