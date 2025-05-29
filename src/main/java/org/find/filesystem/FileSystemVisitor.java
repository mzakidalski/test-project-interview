package org.find.filesystem;

import org.find.api.FileResult;

import java.util.List;

public interface FileSystemVisitor {

    void setCurrentPath(String path);
    List<FileResult> listFiles();
}
