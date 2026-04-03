package main.java.swing_base;

/**
 * An option for a menu that is used in BaseStartPanel.java. Holds
 * a value(of type T), which is used when onSelection(...) is called 
 * in BaseStartPanel.java.
 */
public class BaseMenuOption<T> extends javax.swing.JButton {
    protected T value;

    public BaseMenuOption(String text, T value) {
        super();

        setText(text);
        this.value = value;

        setPreferredSize(new java.awt.Dimension(300, 100));
    }

    public T getValue() {
        return value;
    }
}
