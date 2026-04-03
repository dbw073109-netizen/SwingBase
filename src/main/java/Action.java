/** 
 * A shorthand for an AbstractAction that simply runs the Runnable whenever the action is performed.
 */
public class Action extends javax.swing.AbstractAction {
    private Runnable task;

    public Action(Runnable task) {
        this.task = task;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        task.run();
    }
}
