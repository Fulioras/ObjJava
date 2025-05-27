package data;

import shapes.base.VectorialObject;
import shapes.derived.*;
import shapes.factories.*;
import data.*;
import view.*;

import java.io.*;
import java.util.List;
import javax.swing.*;

/**
 * A task that loads a serialized list of {@link VectorialObject} instances from a file
 * and updates the associated {@link EditorPanel} with the loaded data.
 * <p>
 * This class is intended to be run in a separate thread to avoid blocking the UI.
 */
public class LoadState implements Runnable {
    /** The file from which the application state is loaded. */
    private File file;
    /** The panel that will be updated with the loaded objects. */
    private EditorPanel panel;

    /**
     * Constructs a new LoadState task.
     *
     * @param file  the file containing the serialized list of vectorial objects
     * @param panel the editor panel to be updated with the loaded data
     */
    public LoadState(File file, EditorPanel panel) {
        this.file = file;
        this.panel = panel;
    }

    /**
     * Executes the file loading operation.
     * <p>
     * Reads the list of {@link VectorialObject} instances from the specified file,
     * and updates the UI on the Swing event dispatch thread.
     */
    @Override
    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            List<VectorialObject> objects = (List<VectorialObject>) in.readObject();
            SwingUtilities.invokeLater(() -> panel.setObjects(objects));
            System.out.println("Duomenys nuskaityti.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}