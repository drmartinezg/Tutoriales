package es.duero4.headfirst.command.party;

/**
 *
 * @author ramon
 */
public class HottubOnCommand implements Command {
    private final Hottub hottub;

    public HottubOnCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    @Override
    public void execute() {
        hottub.on();
        hottub.setTemperature(104);
        hottub.circulate();
    }

    @Override
    public void undo() {
        hottub.off();
    }
    
}
