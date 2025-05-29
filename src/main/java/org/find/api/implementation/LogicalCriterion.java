package org.find.api.implementation;

import org.find.api.FileCriterion;
import org.find.api.FileResult;

import java.util.ArrayList;
import java.util.List;

public class LogicalCriterion implements FileCriterion {
    private final Operation operation;
    private List<FileCriterion> criteria = new ArrayList<>();

    public class Builder {
        private List<FileCriterion> addedCriteria = new ArrayList<FileCriterion>();
        private Operation operation;
        public Builder(Operation operation) {
            this.operation = operation;
        }

        public Builder add(FileCriterion criterion) {
            addedCriteria.add(criterion);
            return this;
        }

        public LogicalCriterion build() {
            return new LogicalCriterion(operation, this.addedCriteria);
        }
    }

    private LogicalCriterion(Operation operation, List<FileCriterion> criteria) {
        this.operation = operation;
        this.criteria = criteria;
    }

    @Override
    public boolean fullfilled(FileResult file) {
        if (operation == Operation.AND) {
            return fullfilledAnd(file);
        } else {
            return fullfilledOr(file);
        }
    }

    private boolean fullfilledAnd(FileResult file) {
        for (FileCriterion criterion : criteria) {
            if (!criterion.fullfilled(file)) {
                return false;
            }
        }
        return true;
    }

    private boolean fullfilledOr(FileResult file) {
        for (FileCriterion criterion : criteria) {
            if (criterion.fullfilled(file)) {
                return true;
            }
        }
        return false;
    }
}
