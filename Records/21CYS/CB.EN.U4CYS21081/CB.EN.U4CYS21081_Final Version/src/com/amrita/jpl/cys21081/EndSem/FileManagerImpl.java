package com.amrita.jpl.cys21081.EndSem;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagerImpl implements FileManager {
    private List<File> files;

    public FileManagerImpl() {
        files = new ArrayList<>();
    }

    @Override
    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public void deleteFile(String fileName) {
        for (File file : files) {
            if (file.getFileName().

                    equals(fileName)) {
                files.remove(file);
                break;
            }
        }
    }

    @Override
    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
        }
    }

    @Override
    public void saveToFile(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(files);
            System.out.println("File details saved to " + fileName);

        } catch (IOException e) {
            System.out.println("Error saving file details: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            files = (List<File>) ois.readObject();
            System.out.println("File details loaded from " + fileName);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading file details: " + e.getMessage());
        }
    }

    @Override
    public List<File> getFiles() {
        return files;
    }
}