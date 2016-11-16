package ru.supernacho.rollercalc;

/**
 * Created by Thirteenth on 16.11.2016.
 */

public class Calc {
    private double lenR, ds, vt, h,dOut,dIn;

    public double getLenR() {
        return lenR;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setdOut(double dOut) {
        this.dOut = dOut;
    }

    public void setdIn(double dIn) {
        this.dIn = dIn;
    }

    public void proc(){
    ds = (dOut + dIn) / 2;
    vt = ((dOut - dIn) / 2) / h;
    lenR = ds * 3.14 * vt;

    }
}
