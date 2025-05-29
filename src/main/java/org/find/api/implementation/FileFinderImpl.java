package org.find.api.implementation;

import org.find.api.FileCriterion;
import org.find.api.FileFinder;
import org.find.api.FileResult;
import org.find.filesystem.FileSystemVisitor;

import java.util.ArrayList;
import java.util.List;

public class FileFinderImpl implements FileFinder {

    private FileSystemVisitor visitor;
    public FileFinderImpl(FileSystemVisitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public List<FileResult> findFiles(String startPath, List<FileCriterion> criteria) {
        var result = new ArrayList<FileResult>();
        browseRecursive(startPath, criteria, result);
        return result;
    }

    private void browseRecursive(String path, List<FileCriterion> criteria, List<FileResult> result) {
        visitor.setCurrentPath(path);
        var files = visitor.listFiles();
        for (var file : files) {
            if (file.isDirectory()) {
                browseRecursive(file.getFullPath(), criteria, result);
            } else {
                if (matchesCriterias(file, criteria)) {
                    result.add(file);
                }
            }
        }
    }

    private boolean matchesCriterias(FileResult file, List<FileCriterion> criteria) {
        for (FileCriterion criterion : criteria) {
            if (!criterion.fullfilled(file)) {
                return false;
            }
        }
        return true;
    }
}
