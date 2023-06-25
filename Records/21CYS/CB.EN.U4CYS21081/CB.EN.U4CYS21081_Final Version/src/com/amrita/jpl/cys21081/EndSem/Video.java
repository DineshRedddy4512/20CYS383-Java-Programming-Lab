package com.amrita.jpl.cys21081.EndSem;

public class Video extends File {
    private String duration;

    public Video(String fileName, long fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    // Getter and setter for duration

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}