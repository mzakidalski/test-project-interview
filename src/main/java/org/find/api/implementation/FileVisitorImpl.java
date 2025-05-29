package org.find.api.implementation;


import org.find.api.FileResult;
import org.find.filesystem.FileSystemVisitor;

import java.util.List;

public class FileVisitorImpl implements FileSystemVisitor {



    @Override
    public void setCurrentPath(String path) {

    }

    @Override
    public List<FileResult> listFiles() {
        return List.of();
    }
}
