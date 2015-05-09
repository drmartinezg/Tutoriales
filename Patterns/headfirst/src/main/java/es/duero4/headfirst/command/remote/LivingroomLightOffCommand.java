package es.duero4.headfirst.command.remote;

/**
 *
 * @author ramon
 */
public class LivingroomLightOffCommand implements Command {
    Light light;

    public LivingroomLightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
    
    
}
