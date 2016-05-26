package es.duero4.headfirst.command.undo;

/**
 * Command Interface
 * 
 * @author ramon
 */
public interface Command {
    public void execute();
    public void undo();
}
