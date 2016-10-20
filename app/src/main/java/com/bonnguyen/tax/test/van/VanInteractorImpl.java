package com.bonnguyen.tax.test.van;

import com.bonnguyen.tax.test.BaseInteractor;
import com.bonnguyen.tax.test.Vehicle;

/**
 * Created by nguyenbon on 10/18/16.
 */

public class VanInteractorImpl extends Vehicle implements BaseInteractor {
    private long weight;

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    @Override
    public long calcTax() {
        if (getWeight() < 3500) {
            return 165;
        } else {
            return 190;
        }
    }
}
