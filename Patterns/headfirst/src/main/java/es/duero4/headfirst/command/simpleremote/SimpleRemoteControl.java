package es.duero4.headfirst.command.simpleremote;

/**
 *
 * @author ramon
 * 
 * This is the invoker
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }
    
    public void setCommand(Command command) {
        slot = command;
    }
    
    public void buttonWasPressed() {
        slot.execute();
    }
}
