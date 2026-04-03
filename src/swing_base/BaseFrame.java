package swing_base;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * An expansion on JFrame that holds a MainPanel, which is the only location
 * where BaseFrames can be added to the Frame. Includes a bind() method that binds
 * keys to Runnables.
 */
public abstract class BaseFrame extends JFrame {
    protected MainPanel mainPanel;

    protected BaseFrame() {
        mainPanel = new MainPanel();
        add(mainPanel);
        initialize();
        addComponents();
        bindKeys();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    protected void bind(int keyCode, Runnable task) {
        mainPanel.getInputMap().put(KeyStroke.getKeyStroke(keyCode, 0), keyCode);
        mainPanel.getActionMap().put(keyCode, new Action(task));
    }

    @Override
    public Component add(Component comp) {
        if (comp != mainPanel) {
            throw new UnsupportedOperationException("Must only add mainPanel to BaseFrame");
        }
        return super.add(comp);
    }

    protected abstract void initialize();
    protected abstract void addComponents();
    protected abstract void bindKeys();
}   
