package org.find.api;

import java.time.LocalDateTime;

public interface FileResult {
    String getName();
    long getSize();
    LocalDateTime getLastModified();
    LocalDateTime getCreationModified();
    boolean isDirectory();
    String getFullPath();
}
