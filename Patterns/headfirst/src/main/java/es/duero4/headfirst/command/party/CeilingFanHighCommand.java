package es.duero4.headfirst.command.party;

/**
 *
 * @author ramon
 */
public class CeilingFanHighCommand implements Command {
    private final CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }
    
    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        switch (prevSpeed) {
            case CeilingFan.HIGH:
                ceilingFan.high(); 
                break;
            case CeilingFan.MEDIUM: 
                ceilingFan.medium(); 
                break;
            case CeilingFan.LOW: 
                ceilingFan.low(); 
                break;
            default: 
                ceilingFan.off(); 
                break;
        }
    }
}
