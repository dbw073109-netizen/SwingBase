package swing_base;

/**
 * An option for a menu that is used in BaseStartPanel.java. Holds
 * keys and values(of type T), where values are used when onSelection(...) 
 * is called in BaseStartPanel.java. Also can use itself as a key and 
 * omit the key parameter.
 */
public class BaseMenuOption<T> extends javax.swing.JButton {
    protected Object key;
    protected T value;

    public BaseMenuOption(String text, Object key, T value) {
        super();

        setText(text);
        this.key = key;
        this.value = value;

        setPreferredSize(new java.awt.Dimension(300, 100));
    }

    public BaseMenuOption(String text, T value) {
        super();

        setText(text);
        key = this;
        this.value = value;
        putClientProperty(key, value);

        setPreferredSize(new java.awt.Dimension(300, 100));
    }

    public Object getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}
