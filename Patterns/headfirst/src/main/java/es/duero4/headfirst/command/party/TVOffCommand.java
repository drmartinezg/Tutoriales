package es.duero4.headfirst.command.party;

/**
 *
 * @author ramon
 */
public class TVOffCommand implements Command {
    private final TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
    
}
