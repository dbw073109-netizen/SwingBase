package main.java.swing_base;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * An expansion on JFrame that holds a MainPanel, which is the only location
 * where BaseFrames can be added to the Frame. Includes a bind() method that binds
 * keys to Runnables.
 */
public abstract class BaseFrame extends JFrame {
    protected final MainPanel mainPanel;

    protected BaseFrame() {
        mainPanel = new MainPanel();
        add(mainPanel);
        initialize();
        addComponents();
        bindKeys();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Binds a key to a Runnable action.
     * @param keyCode the key as defined in KeyEvent.{keyCode}
     * @param task the task that will be ran when the key is pressed.
     */
    protected void bind(int keyCode, Runnable task) {
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(keyCode, 0), keyCode);
        mainPanel.getActionMap().put(keyCode, new Action(task));
    }

    @Override
    public Component add(Component comp) {
        if (comp != mainPanel) {
            throw new UnsupportedOperationException("Must only add mainPanel to BaseFrame");
        }
        return super.add(comp);
    }

    /** Initialize just the BaseFrame. */
    protected abstract void initialize();
    /** Add BaseFrames to the BaseFrame and define simple behavior that is required of them in this class. */
    protected abstract void addComponents();
    /** Bind keys to actions using the bind() method. */
    protected abstract void bindKeys();
}   
