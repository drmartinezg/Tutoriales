package es.duero4.headfirst.command.remote;

/**
 *
 * @author ramon
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
    
}
