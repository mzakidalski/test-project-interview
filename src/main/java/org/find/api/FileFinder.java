package org.find.api;

import java.util.List;

public interface FileFinder {
    List<FileResult> findFiles(String startPath, List<FileCriterion> criteria);


}
