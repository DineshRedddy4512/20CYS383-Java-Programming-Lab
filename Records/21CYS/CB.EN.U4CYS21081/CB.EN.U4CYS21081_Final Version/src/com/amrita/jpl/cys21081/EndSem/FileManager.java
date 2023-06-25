package com.amrita.jpl.cys21081.EndSem;

import java.util.List;

public interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
    void saveToFile(String fileName);
    void loadFromFile(String fileName);
    List<File> getFiles();
}