package com.amrita.jpl.cys21081.EndSem;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FileManagementSystemUI {
    private FileManager fileManager;
    private JFrame frame;
    private JTextField nameField;
    private JTextField sizeField;
    private JTextField typeField;
    private JTextField resolutionField;
    private JTextField durationField;
    private JTable table;

    public FileManagementSystemUI(FileManager fileManager) {
        this.fileManager = fileManager;
        createUI();
    }

    private void createUI() {
        frame = new JFrame("21UCYS End Semester Assignment File Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("/home/dinesh/Downloads/download.png");
        frame.setIconImage(icon.getImage());


        JPanel inputPanel = createInputPanel();
        JPanel buttonPanel = createButtonPanel();
        JPanel tablePanel = createTablePanel();

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(tablePanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        inputPanel.add(new JLabel("File Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("File Size:"));
        sizeField = new JTextField();
        inputPanel.add(sizeField);

        inputPanel.add(new JLabel("File Type:"));
        typeField = new JTextField();
        inputPanel.add(typeField);

        inputPanel.add(new JLabel("Enter Image Resolution:"));
        resolutionField = new JTextField();
        inputPanel.add(resolutionField);

        inputPanel.add(new JLabel("Enter Video Duration:"));
        durationField = new JTextField();
        inputPanel.add(durationField);

        return inputPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFile();
            }
        });
        buttonPanel.add(addButton);

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });
        buttonPanel.add(deleteButton);

        JButton displayButton = new JButton("Refresh");
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAllFiles();
            }
        });
        buttonPanel.add(displayButton);



        return buttonPanel;
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        return tablePanel;
    }

    private void addFile() {
        String name = nameField.getText();
        long size = Long.parseLong(sizeField.getText());

        if (!typeField.getText().isEmpty()) {
            String type = typeField.getText();
            fileManager.addFile(new Document(name, size, type));
        } else if (!resolutionField.getText().isEmpty()) {
            String resolution = resolutionField.getText();
            fileManager.addFile(new Image(name, size, resolution));
        } else if (!durationField.getText().isEmpty()) {
            String duration = durationField.getText();
            fileManager.addFile(new Video(name, size, duration));
        }

        updateTableData();
        clearInputFields();
    }

    private void deleteFile() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String fileName = (String) table.getValueAt(selectedRow, 0);
            fileManager.deleteFile(fileName);
            updateTableData();
        }
    }

    private void displayAllFiles() {
        List<File> files = fileManager.getFiles();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (File file : files) {
            if (file instanceof Document) {
                Document document = (Document) file;
                model.addRow(new Object[]{document.getFileName(), document.getFileSize(), document.getDocumentType()});
            } else if (file instanceof Image) {
                Image image = (Image) file;
                model.addRow(new Object[]{image.getFileName(), image.getFileSize(), image.getResolution()});
            } else if (file instanceof Video) {
                Video video = (Video) file;
                model.addRow(new Object[]{video.getFileName(), video.getFileSize(), video.getDuration()});
            }
        }
    }

    private void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            String fileName = fileChooser.getSelectedFile().getAbsolutePath();
            fileManager.saveToFile(fileName);
        }
    }

    private void loadFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            String fileName = fileChooser.getSelectedFile().getAbsolutePath();
            fileManager.loadFromFile(fileName);
            updateTableData();
        }
    }

    private void updateTableData() {
        displayAllFiles();
        clearInputFields();
    }

    private void clearInputFields() {
        nameField.setText("");
        sizeField.setText("");
        typeField.setText("");
        resolutionField.setText("");
        durationField.setText("");
    }
}

