package edu.northeastern.martin;

public class GearBox {
    boolean isAuto;

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
