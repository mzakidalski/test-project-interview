package org.find.api.implementation;

import org.find.api.FileResult;

import java.time.LocalDateTime;

public class FileResultImpl implements FileResult {

    private String fileName;
    private boolean isFolder;

    public FileResultImpl(String fileName, boolean isFolder) {
        this.fileName = fileName;
        this.isFolder = isFolder;
    }

    @Override
    public String getName() {
        return fileName;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public LocalDateTime getLastModified() {
        return null;
    }

    @Override
    public LocalDateTime getCreationModified() {
        return null;
    }

    @Override
    public boolean isDirectory() {
        return isFolder;
    }

    @Override
    public String getFullPath() {
        return "";
    }
}
