package org.find.filesystem;

import org.find.api.FileResult;
import org.find.api.implementation.FileResultImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StubbedFileSystem implements FileSystemVisitor {

    private String path;
    private Map<String, List<FileResult>> pathToFileList = new HashMap<>();

    public StubbedFileSystem() {
        pathToFileList.put("/foo", List.of(new FileResultImpl("notes.txt", false),
                new FileResultImpl("other.txt", false)));

    }


    @Override
    public void setCurrentPath(String path) {
        this.path = path;
    }

    @Override
    public List<FileResult> listFiles() {
        return pathToFileList.get(path);
    }
}
