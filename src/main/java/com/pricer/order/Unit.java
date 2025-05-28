package com.pricer.order;

enum UnitType {
    WEIGHT,
    VOLUME
}

public enum Unit {
    KILO(UnitType.WEIGHT, 1000);

    private UnitType unitType;
    private double factorToBaseUnits;

    Unit(UnitType unitType, double factorToBaseUnits) {
        this.unitType = unitType;
        this.factorToBaseUnits = factorToBaseUnits;
    }

    public double getFactorToBaseUnits() {
        return factorToBaseUnits;
    }

    public double convertTo(Unit otherUnit) {
        if (this.unitType != otherUnit.unitType) {
            throw new IllegalArgumentException("UnitTypes are not compatible");
        }
        return otherUnit.getFactorToBaseUnits()/getFactorToBaseUnits();
    }


}
