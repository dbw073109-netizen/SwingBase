package swing_base;

import javax.swing.JPanel;

/**
 * A BasePanel forces JPanels to be able to be initialized.
 */
public abstract class BasePanel extends JPanel {
    protected abstract void initialize();
}
