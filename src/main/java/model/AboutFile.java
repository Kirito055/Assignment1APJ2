package model;

import java.io.File;
import java.util.ArrayList;

public class AboutFile extends File {
    private File file;

    public AboutFile() {
        super("null");
        this.file = null;
    }

    public AboutFile(File file) {
        super(file.getPath());
        this.file = file;
    }

    @Override
    public String getPath() {
        return file.getPath();
    }

    @Override
    public String getName() {
        return file.getName();
    }

    @Override
    public boolean isFile() {
        return file.isFile();
    }

    public ArrayList<AboutFile> getFiles(File rootFile, String filename) {
        ArrayList<AboutFile> fileList = new ArrayList<>();
        if (rootFile.isDirectory()) {
            System.out.println("searching: " + rootFile.getAbsolutePath());
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        getFiles(file, filename);
                    } else {
                        if (file.getName().equalsIgnoreCase(filename)) {
                            fileList.add(new AboutFile(file));
                        }
                    }
                }
            }
        }
        return fileList;
    }
}
