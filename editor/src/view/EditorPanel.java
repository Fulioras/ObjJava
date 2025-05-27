package view;

import shapes.base.VectorialObject;
import shapes.derived.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Panel responsible for rendering and editing vector shapes.
 * <p>
 * Supports modes for selecting, drawing rectangles, and drawing circles.
 * Handles mouse interactions for drawing, selecting, and moving shapes.
 * Also supports keyboard shortcuts to switch modes.
 */
public class EditorPanel extends JPanel {
    /** List of vector shapes currently on the canvas */
    private List<VectorialObject> shapes = new ArrayList<>();

    /** Current interaction mode */
    private Mode currentMode = Mode.SELECT;

    /** Sidebar panel reference for UI controls (not directly used here) */
    SidebarPanel sidebar;

    /** Currently selected shape for moving */
    private VectorialObject selectedShape = null;

    /** Shape being currently drawn */
    private VectorialObject currentShape = null;

    /** Offset for dragging selected shape */
    private int offsetX, offsetY;

    /** Start coordinates for drawing new shape */
    private int startX, startY;

    /** Current fill color for new shapes */
    private Color fillColor = Color.BLUE;

    /** Current stroke color for new shapes */
    private Color strokeColor = Color.BLACK;

    /** Default line width for shapes */
    private double defaultLineWidth = 2.0;

    /**
     * Constructs an EditorPanel attached to a sidebar.
     * Initializes mouse and keyboard listeners.
     *
     * @param sidebar the sidebar panel linked to this editor panel
     */
    EditorPanel(SidebarPanel sidebar){
        this.sidebar = sidebar;
        initMouseListeners();
        initKeyBindings();
        setFocusable(true);
        requestFocusInWindow();
    }

    /**
     * Initializes mouse listeners for press, drag, and release events.
     * Handles selection, movement, and drawing of shapes based on current mode.
     */
    private void initMouseListeners() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                onMousePressed(e.getX(), e.getY());
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                onMouseReleased(e.getX(), e.getY());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                onMouseDragged(e.getX(), e.getY());
            }
        });
    }

    /**
     * Handles mouse press event.
     * If in SELECT mode, attempts to select a shape under cursor.
     * If in drawing mode, starts a new shape at the pressed location.
     *
     * @param x mouse x coordinate
     * @param y mouse y coordinate
     */
    private void onMousePressed(int x, int y) {
        if (currentMode == Mode.SELECT) {
            selectedShape = getShapeAt(x, y);
            if (selectedShape != null) {
                offsetX = (int)(x - selectedShape.getX());
                offsetY = (int)(y - selectedShape.getY());
            }
        }
        else{
            startX = x;
            startY = y;
            switch(currentMode) {
                case DRAW_RECT:
                    currentShape = new shapes.derived.Rectangle(x, y, defaultLineWidth, fillColor, strokeColor);
                    shapes.add(currentShape);
                    break;
                case DRAW_CIRCLE:
                    currentShape = new shapes.derived.Circle(x, y, defaultLineWidth, fillColor, strokeColor);
                    shapes.add(currentShape);
                    break;
                default:
                    currentShape = null;
            }
        }
    }

    /**
     * Handles mouse drag event.
     * Moves selected shape if in SELECT mode.
     * Resizes the shape currently being drawn if in a draw mode.
     *
     * @param x current mouse x coordinate
     * @param y current mouse y coordinate
     */
    private void onMouseDragged(int x, int y) {
        if (currentMode == Mode.SELECT && selectedShape != null) {
            selectedShape.move(x - offsetX, y - offsetY);
            repaint();
        }
        else {
            if (currentShape == null) return;

            int width = Math.abs(x - startX);
            int height = Math.abs(y - startY);

            if (currentShape instanceof shapes.derived.Rectangle) {
                shapes.derived.Rectangle rect = (shapes.derived.Rectangle) currentShape;
                try {
                    rect.setWidth(width);
                    rect.setHeight(height);
                    rect.setX(startX);
                    rect.setY(startY);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (currentShape instanceof shapes.derived.Circle) {
                shapes.derived.Circle circle = (shapes.derived.Circle) currentShape;
                int diameter = Math.max(width, height);
                try {
                    circle.setRadius(diameter / 2.0);
                    circle.setX(startX);
                    circle.setY(startY);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        repaint();
    }

    /**
     * Returns the topmost shape containing the point (x, y).
     * Checks rectangles and circles for containment.
     *
     * @param x x coordinate of point
     * @param y y coordinate of point
     * @return the shape containing the point or null if none found
     */
    private VectorialObject getShapeAt(int x, int y) {
        for (int i = shapes.size() - 1; i >= 0; i--) { // topmost shape first
            VectorialObject shape = shapes.get(i);
            if (shape instanceof shapes.derived.Rectangle) {
                shapes.derived.Rectangle r = (shapes.derived.Rectangle) shape;
                if (x >= r.getX() && x <= r.getX() + r.getWidth() &&
                        y >= r.getY() && y <= r.getY() + r.getHeight()) {
                    return shape;
                }
            } else if (shape instanceof shapes.derived.Circle) {
                shapes.derived.Circle c = (shapes.derived.Circle) shape;
                double dx = x - c.getX();
                double dy = y - c.getY();
                if (Math.sqrt(dx*dx + dy*dy) <= c.getRadius()) {
                    return shape;
                }
            }
        }
        return null;
    }

    /**
     * Handles mouse release event.
     * Resets mode to SELECT and clears the current shape being drawn.
     *
     * @param x mouse x coordinate
     * @param y mouse y coordinate
     */
    private void onMouseReleased(int x, int y) {
        currentMode = Mode.SELECT;
        currentShape = null;
    }

    /**
     * Initializes keyboard bindings for mode switching:
     * 'r' for rectangle draw mode,
     * 'c' for circle draw mode,
     * 's' for select mode.
     */
    private void initKeyBindings() {
        InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke('r'), "drawRectangle");
        am.put("drawRectangle", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMode(Mode.DRAW_RECT);
                System.out.println("Mode: DRAW_RECT");
            }
        });

        im.put(KeyStroke.getKeyStroke('c'), "drawCircle");
        am.put("drawCircle", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMode(Mode.DRAW_CIRCLE);
                System.out.println("Mode: DRAW_CIRCLE");
            }
        });

        im.put(KeyStroke.getKeyStroke('s'), "selectMode");
        am.put("selectMode", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMode(Mode.SELECT);
                System.out.println("Mode: SELECT");
            }
        });
    }

    /**
     * Paints all vector shapes in the panel.
     *
     * @param g the Graphics context
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (VectorialObject shape : shapes) {
            shape.draw(g);
        }
    }

    /**
     * Modes supported by the editor panel.
     */
    public enum Mode {
        SELECT,
        DRAW_RECT,
        DRAW_CIRCLE,
    }

    /**
     * Sets the current interaction mode.
     *
     * @param mode new mode to set
     */
    public void setMode(Mode mode) {
        this.currentMode = mode;
    }

    /**
     * Gets the current interaction mode.
     *
     * @return current mode
     */
    public Mode getMode() {
        return currentMode;
    }

    /**
     * Adds a new shape to the canvas.
     *
     * @param obj vector shape to add
     */
    public void addObject(VectorialObject obj) {
        shapes.add(obj);
        repaint();
    }

    /**
     * Returns all vector shapes currently on the canvas.
     *
     * @return list of vector shapes
     */
    public List<VectorialObject> getObjects() {
        return shapes;
    }

    /**
     * Replaces current shapes with the provided list.
     *
     * @param newObjects new list of vector shapes
     */
    public void setObjects(List<VectorialObject> newObjects) {
        shapes = newObjects;
        repaint();
    }

    /**
     * Sets the fill color used for new shapes.
     *
     * @param c fill color
     */
    public void setFillColor(Color c) {
        this.fillColor = c;
    }

    /**
     * Sets the stroke color used for new shapes.
     *
     * @param c stroke color
     */
    public void setStrokeColor(Color c) {
        this.strokeColor = c;
    }
}
