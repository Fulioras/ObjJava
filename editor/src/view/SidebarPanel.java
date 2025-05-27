package view;

import java.util.function.Consumer;
import javax.swing.colorchooser.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Sidebar panel providing UI controls for shape drawing and color selection.
 * <p>
 * Contains buttons to select rectangle or circle drawing modes,
 * and buttons to pick fill and stroke colors with color choosers.
 * Supports setting callback actions for shape mode selection and
 * color change notifications.
 */
public class SidebarPanel extends JPanel {
    /** Action to run when the "Draw Rectangle" button is pressed */
    private Runnable drawRectangleAction;

    /** Action to run when the "Draw Circle" button is pressed */
    private Runnable drawCircleAction;

    /** Consumer to accept fill color changes */
    private Consumer<Color> fillColorSetter;

    /** Consumer to accept stroke color changes */
    private Consumer<Color> strokeColorSetter;

    /** Button for choosing fill color */
    private JButton fillColorButton;

    /** Button for choosing stroke color */
    private JButton strokeColorButton;

    /** Currently selected fill color */
    private Color fillColor = Color.LIGHT_GRAY;

    /** Currently selected stroke color */
    private Color strokeColor = Color.BLACK;

    /**
     * Constructs a SidebarPanel with predefined layout and background.
     * Initializes UI components via {@link #initUI()}.
     */
    public SidebarPanel() {
        setLayout(new GridLayout(10, 1, 5, 5));
        setPreferredSize(new Dimension(180, 0));
        setBackground(new Color(240, 240, 240));

        // Initialize the UI components and layout
        initUI();
    }

    /**
     * Initializes UI components:
     * - Buttons for selecting rectangle and circle drawing modes,
     * - Buttons to select fill and stroke colors via color choosers.
     * <p>
     * Registers action listeners to invoke configured callbacks.
     */
    public void initUI(){
        // Rectangle button with icon and tooltip
        JButton rectButton = new JButton();
        Icon rectIcon = new Icon() {
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.setColor(Color.BLACK);
                g.drawRect(x + 2, y + 4, getIconWidth() - 4, getIconHeight() - 8);
            }
            public int getIconWidth() { return 24; }
            public int getIconHeight() { return 24; }
        };
        rectButton.setIcon(rectIcon);
        rectButton.setToolTipText("Draw Rectangle");
        rectButton.addActionListener(e -> {
            if (drawRectangleAction != null) drawRectangleAction.run();
        });

        // Circle button with icon and tooltip
        JButton circleButton = new JButton();
        Icon circleIcon = new Icon() {
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.setColor(Color.BLACK);
                g.drawOval(x + 2, y + 4, getIconWidth() - 4, getIconHeight() - 8);
            }
            public int getIconWidth() { return 24; }
            public int getIconHeight() { return 24; }
        };
        circleButton.setIcon(circleIcon);
        circleButton.setToolTipText("Draw Circle");
        circleButton.addActionListener(e -> {
            if (drawCircleAction != null) drawCircleAction.run();
        });

        JPanel shapePanel = new JPanel(new FlowLayout());
        shapePanel.add(rectButton);
        shapePanel.add(circleButton);

        // Fill Color Button setup
        fillColorButton = new JButton("Fill Color");
        fillColorButton.setBackground(fillColor);
        fillColorButton.addActionListener(e -> {
            JColorChooser chooser = new JColorChooser(fillColor);
            chooser.setPreviewPanel(new JPanel());  // Remove preview panel

            // Retain only "Swatches" color chooser panel
            AbstractColorChooserPanel[] panels = chooser.getChooserPanels();
            for (AbstractColorChooserPanel panel : panels) {
                if (!"Swatches".equals(panel.getDisplayName())) {
                    chooser.removeChooserPanel(panel);
                }
            }

            JDialog dialog = JColorChooser.createDialog(
                    this, "Choose Fill Color", true, chooser,
                    e2 -> {
                        fillColor = chooser.getColor();
                        fillColorButton.setBackground(fillColor);
                        if (fillColorSetter != null) {
                            fillColorSetter.accept(fillColor);
                        }
                    },
                    null
            );
            dialog.setVisible(true);
        });

        // Stroke Color Button setup
        strokeColorButton = new JButton("Stroke Color");
        strokeColorButton.setBackground(strokeColor);
        strokeColorButton.addActionListener(e -> {
            JColorChooser chooser = new JColorChooser(strokeColor);
            chooser.setPreviewPanel(new JPanel());  // Remove preview panel

            // Retain only "Swatches" color chooser panel
            AbstractColorChooserPanel[] panels = chooser.getChooserPanels();
            for (AbstractColorChooserPanel panel : panels) {
                if (!"Swatches".equals(panel.getDisplayName())) {
                    chooser.removeChooserPanel(panel);
                }
            }

            JDialog dialog = JColorChooser.createDialog(
                    this, "Choose Stroke Color", true, chooser,
                    e2 -> {
                        strokeColor = chooser.getColor();
                        strokeColorButton.setBackground(strokeColor);
                        if (strokeColorSetter != null) {
                            strokeColorSetter.accept(strokeColor);
                        }
                    },
                    null
            );
            dialog.setVisible(true);
        });

        add(shapePanel);
        add(fillColorButton);
        add(strokeColorButton);
    }

    /**
     * Returns the currently selected fill color.
     *
     * @return current fill color
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * Returns the currently selected stroke color.
     *
     * @return current stroke color
     */
    public Color getStrokeColor() {
        return strokeColor;
    }

    /**
     * Sets the action to be performed when the rectangle draw button is clicked.
     *
     * @param action runnable to execute on rectangle draw button press
     */
    public void setDrawRectangleAction(Runnable action) {
        this.drawRectangleAction = action;
    }

    /**
     * Sets the action to be performed when the circle draw button is clicked.
     *
     * @param action runnable to execute on circle draw button press
     */
    public void setDrawCircleAction(Runnable action) {
        this.drawCircleAction = action;
    }

    /**
     * Sets the consumer to be notified when the fill color changes.
     *
     * @param setter consumer accepting the new fill color
     */
    public void setFillColorSetter(Consumer<Color> setter) {
        this.fillColorSetter = setter;
    }

    /**
     * Sets the consumer to be notified when the stroke color changes.
     *
     * @param setter consumer accepting the new stroke color
     */
    public void setStrokeColorSetter(Consumer<Color> setter) {
        this.strokeColorSetter = setter;
    }
}
