package data;

import shapes.base.VectorialObject;
import shapes.derived.*;
import shapes.factories.*;
import data.*;
import view.*;

import java.io.*;
import java.util.List;

/**
 * A task that saves a list of {@link VectorialObject} instances to a file.
 * <p>
 * This class is intended to be run in a separate thread to avoid blocking the user interface
 * during potentially slow file I/O operations.
 */
public class SaveState implements Runnable {
    /** The file to which the application state will be saved. */
    private File file;
    /** The list of vectorial objects to be saved. */
    private List<VectorialObject> objects;

    /**
     * Constructs a new SaveState task.
     *
     * @param file    the destination file where the objects will be saved
     * @param objects the list of vectorial objects to serialize
     */
    public SaveState(File file, List<VectorialObject> objects) {
        this.file = file;
        this.objects = objects;
    }

    /**
     * Executes the save operation.
     * <p>
     * Serializes the list of {@link VectorialObject} instances and writes it to the specified file.
     */
    @Override
    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(objects);
            System.out.println("Duomenys išsaugoti.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

