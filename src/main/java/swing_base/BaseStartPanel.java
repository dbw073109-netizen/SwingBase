package main.java.swing_base;

import java.util.List;
import java.util.function.Consumer;

import javax.swing.JLabel;

/**
 * A BasePanel for a typical starting screen for a program. Includes
 * a title and a list of options of type T whose actions are defined in 
 * initializeOptions() and are called in onSelection(...), likely
 * in a BaseFrame instance.
 */
public abstract class BaseStartPanel<T> extends BasePanel {
    protected JLabel title;
    protected BasePanel menu;
    protected List<BaseMenuOption<T>> options;

    protected BaseStartPanel(String title) {
        setLayout(new java.awt.BorderLayout());

        this.title = new JLabel(title);
        options = initializeOptions();

        menu = new BasePanel() {
            @Override
            public void initialize() {
                setLayout(new java.awt.GridLayout(options.size(), 1));
                for (BaseMenuOption<T> option : options) {
                    add(option);
                }
            }
        };
        menu.initialize();
    }

    protected BaseStartPanel() {
        this("");
    }

    /**
     * When a BaseMenuOption is clicked(action listens), the
     * consumer takes in the specified option's value that was 
     * clicked on and does the consumers defined behavior elsewhere,
     * typically in BaseFrame.java.
     * @param consumer takes in a value defined by the specific option
     */
    public void onSelection(Consumer<T> consumer) {
        options.stream().forEach(option -> option.addActionListener(new Action(() -> consumer.accept(option.getValue()))));
    }

    /**
     * Runs the task whenever a BaseMenuOption is clicked. Any 
     * BaseMenuOption will run the same task, regardless of it's
     * specified value.
     * @param task the task that will be ran on option press
     */
    public void onSelection(Runnable task) {
        options.stream().forEach(option -> option.addActionListener(new Action(task)));
    }

    protected abstract void initialize();
    /**
     * Defines a List of BaseMenuOptions, and more importantly, their
     * specified behaviors.
     */
    protected abstract List<BaseMenuOption<T>> initializeOptions();
}