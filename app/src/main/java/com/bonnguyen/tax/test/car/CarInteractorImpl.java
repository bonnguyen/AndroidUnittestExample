package com.bonnguyen.tax.test.car;

import com.bonnguyen.tax.test.BaseInteractor;
import com.bonnguyen.tax.test.Vehicle;

/**
 * Created by nguyenbon on 10/18/16.
 */

public class CarInteractorImpl extends Vehicle implements BaseInteractor {
    private long engine;
    private long emission;

    public long getEngine() {
        return engine;
    }

    public void setEngine(long engine) {
        this.engine = engine;
    }

    public long getEmission() {
        return emission;
    }

    public void setEmission(long emission) {
        this.emission = emission;
    }

    @Override
    public long calcTax() throws IllegalArgumentException {
        if (getRegistered() < 0) {
            throw new IllegalArgumentException("Registered of car should be greater than 0");
        } else if (getRegistered() < 2002) {
            return this.calcInvoiceForCarWhenRegisteredLessThan2002();
        } else {
            return this.calcInvoiceForCarWhenRegisteredGreaterAndEqual2002();
        }
    }

    private long calcInvoiceForCarWhenRegisteredLessThan2002() throws IllegalArgumentException {
        if (getEngine() < 0) {
            throw new IllegalArgumentException("Engine of car should be greater than 0");
        } else if (getEngine() <= 1550) {
            return 110;
        } else {
            return 165;
        }
    }

    private long calcInvoiceForCarWhenRegisteredGreaterAndEqual2002() throws IllegalArgumentException {
        if (getEmission() < 0) {
            throw new IllegalArgumentException("Emission of car should be greater than 0");
        } else if (getEmission() <= 100) {
            return 65;
        } else if (getEmission() > 100 && getEmission() <= 120) {
            return 75;
        } else if (getEmission() > 120 && getEmission() <= 150) {
            return 105;
        } else if (getEmission() > 150 && getEmission() <= 165) {
            return 125;
        } else if (getEmission() > 165 && getEmission() <= 185) {
            return 145;
        } else {
            return 160;
        }
    }
}
