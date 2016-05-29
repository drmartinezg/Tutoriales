package es.duero4.headfirst.command.party;

/**
 *
 * @author ramon
 */
public class HottubOffCommand implements Command {
    private final Hottub hottub;

    public HottubOffCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    @Override
    public void execute() {
        hottub.setTemperature(98);
        hottub.off();
    }

    @Override
    public void undo() {
        hottub.on();
    }
    
}
