package view;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import shapes.base.VectorialObject;
import shapes.derived.*;
import shapes.factories.*;
import data.*;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Main application window for the vector graphics editor.
 * <p>
 * This class sets up the GUI components including the drawing canvas,
 * sidebar controls, and buttons for saving and clearing the drawing.
 * It also handles loading and saving the vector objects to a file.
 */
public class EditorFrame extends JFrame {

    /** Canvas panel where shapes are drawn and manipulated */
    private EditorPanel canvas;

    /** File used for saving and loading vector graphic data */
    private File file = new File("vector_data.bin");

    /**
     * Constructs the main editor frame.
     * <p>
     * Initializes the window, sets up the canvas, sidebar, buttons,
     * and starts loading saved data if available.
     */
    public EditorFrame() {
        setTitle("Vektorinės grafikos redaktorius");
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        SidebarPanel sidebar = new SidebarPanel();
        canvas = new EditorPanel(sidebar);

        // Set sidebar actions for drawing modes and color pickers
        sidebar.setDrawRectangleAction(() -> canvas.setMode(EditorPanel.Mode.DRAW_RECT));
        sidebar.setDrawCircleAction(() -> canvas.setMode(EditorPanel.Mode.DRAW_CIRCLE));
        sidebar.setFillColorSetter(canvas::setFillColor);
        sidebar.setStrokeColorSetter(canvas::setStrokeColor);

        add(canvas, BorderLayout.CENTER);
        add(sidebar, BorderLayout.WEST);

        // Buttons panel with save and erase functionality
        JButton save = new JButton("Išsaugoti");
        JButton erase = new JButton("Ištrinti viską");

        JPanel buttons = new JPanel();
        buttons.add(save);
        buttons.add(erase);
        add(buttons, BorderLayout.SOUTH);

        // Save button triggers saving current shapes asynchronously
        save.addActionListener(e ->
                new Thread(new SaveState(file, canvas.getObjects())).start()
        );

        // Erase button clears all shapes and truncates the save file
        erase.addActionListener(e -> {
            canvas.setObjects(new ArrayList<>());

            try (FileOutputStream fos = new FileOutputStream(file)) {
                // Opening in write mode truncates the file
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            canvas.repaint();
        });

        // Load previously saved shapes if file exists
        if (file.exists()) {
            new Thread(new LoadState(file, canvas)).start();
        }

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Application entry point.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(EditorFrame::new);
    }
}
