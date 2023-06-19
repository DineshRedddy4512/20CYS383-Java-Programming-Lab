package com.amrita.EndSem;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManagerImpl();
        FileManagementSystemUI fileManagementSystemUI = new FileManagementSystemUI(fileManager);
    }
}
