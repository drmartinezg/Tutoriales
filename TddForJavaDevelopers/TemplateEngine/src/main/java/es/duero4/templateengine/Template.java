package es.duero4.templateengine;

/**
 *
 * @author Ramon
 */
class Template {
    private String variableValue;
    private final String templateText;

    public Template(String templateText) {
        this.templateText = templateText;
    }

    void set(String variable, String value) {
        this.variableValue = value;
    }
    
    public String evaluate() {
        return templateText.replaceAll("\\$\\{name\\}", variableValue);
    }
}
