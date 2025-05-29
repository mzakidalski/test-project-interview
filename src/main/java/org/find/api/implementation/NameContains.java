package org.find.api.implementation;

import org.find.api.FileCriterion;
import org.find.api.FileResult;

public class NameContains implements FileCriterion {

    private String namePart;
    public NameContains(String namePart) {
        this.namePart = namePart;
    }

    @Override
    public boolean fullfilled(FileResult file) {
        return file.getName().contains(namePart);
    }
}
