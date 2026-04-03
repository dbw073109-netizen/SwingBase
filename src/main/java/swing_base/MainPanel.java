package main.java.swing_base;

import java.awt.Component;

import javax.swing.JPanel;

/**
 * A MainPanel is where BaseFrames are added to a BaseFrame. Can
 * only hold BaseFrames and not any other Component for consistency.
 */
public final class MainPanel extends JPanel {
    /** Only instantiable by BaseFrame */
    MainPanel() {
    }

    /**
     * Removes the BasePanel that was previously on MainPanel
     * and adds the BasePanel to add onto. Also revalidates and 
     * repaints.
     * 
     * @param remove BasePanel that was removed
     * @param add BasePanel that will be added
     */
    public void replace(BasePanel remove, BasePanel add) {
        remove(remove);
        add(add);
        revalidate();
        repaint();
    }

    /**
     * Removes the unnamed BasePanel that was previously on MainPanel
     * and adds the BasePanel to add onto. Also revalidates and 
     * repaints.
     * 
     * @param add BasePanel that will be added
     */
    public void replace(BasePanel add) {
        remove(0);
        add(add);
        revalidate();
        repaint();
    }

    @Override
    public Component add(Component comp) {
        if (getComponents().length > 0) {
            throw new UnsupportedOperationException("mainPanel must only hold one BasePanel at a time");
        }
        if (getComponents().length != 0 && !(getComponent(0) instanceof BasePanel)) {
            throw new UnsupportedOperationException("Must only add BasePanel to mainPanel");
        }
        return super.add(comp);
    }

    @Override
    public Component add(Component comp, int index) {
        if (getComponents().length > 0) {
            throw new UnsupportedOperationException("mainPanel must only own one Component");
        }
        if (getComponents().length != 0 && !(getComponent(0) instanceof BasePanel)) {
            throw new UnsupportedOperationException("Must only add BasePanel to mainPanel");
        }
        return super.add(comp, index);
    }
}
