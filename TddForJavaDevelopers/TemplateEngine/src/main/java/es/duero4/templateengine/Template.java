package es.duero4.templateengine;

/**
 *
 * @author Ramon
 */
class Template {
    private String variableValue;

    public Template(String templateText) {
    }

    void set(String variable, String value) {
        this.variableValue = value;
    }
    
    public String evaluate() {
        return "Hello, " + variableValue;
    }
}
