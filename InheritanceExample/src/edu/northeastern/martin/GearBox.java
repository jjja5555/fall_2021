package edu.northeastern.martin;

public class GearBox {
    boolean isAuto;

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    int currentGear;
    public boolean isAuto() {
        return isAuto;
    }

    public void setAuto(boolean auto) {
        isAuto = auto;
    }

    public GearBox(boolean isAuto) {
        this.isAuto = isAuto;
    }
}
