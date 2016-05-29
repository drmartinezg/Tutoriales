package es.duero4.headfirst.command.party;

/**
 * Command Interface
 * 
 * @author ramon
 */
public interface Command {
    public void execute();
    public void undo();
}
