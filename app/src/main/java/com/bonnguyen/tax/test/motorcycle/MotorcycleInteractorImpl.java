package com.bonnguyen.tax.test.motorcycle;

import com.bonnguyen.tax.test.BaseInteractor;
import com.bonnguyen.tax.test.Vehicle;

/**
 * Created by nguyenbon on 10/18/16.
 */

public class MotorcycleInteractorImpl extends Vehicle implements BaseInteractor {
    private long engine;

    public long getEngine() {
        return engine;
    }

    public void setEngine(long engine) {
        this.engine = engine;
    }

    @Override
    public long calcTax() throws IllegalArgumentException {
        // TODO: Please implement this function
        return 0;
    }
}
